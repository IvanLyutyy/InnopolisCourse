package main.Innopolis.Lyutyy.task43;

import java.sql.*;
import java.util.Formatter;

/**
 * Класс {@code LibraryDB} обеспечивает работу с базой данных 'Библиотека':
 *  - вывод данных;
 *  - добавление данных;
 *  - обновление данных.
 * @author Lyutyy Ivan
 */
public class LibraryDB {
    private static final Connection con = ConnectionDB.getConnection();

    /**
     * Метод выводит список книг имеющихся в наличии.
     */
    public void showBooks() {
        String sql = "SELECT book_id, author, title, year, count FROM book " +
                "WHERE count > 0 " +
                "ORDER BY book_id;";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            printBooksString("№", "Автор", "Название", "Год(ы)", "Кол-во");
            printBooksString("====", "=====", "========", "======", "======");

            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String author = rs.getString("author");
                String title = rs.getString("title");
                String year = rs.getString("year");
                int count = rs.getInt("count");

                printBooksString(String.valueOf(bookId), author, title, year, String.valueOf(count));
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод выводит строку БД с информацией по книгам.
     * @param bookId
     * @param author
     * @param title
     * @param year
     * @param count
     */
    private void printBooksString(String bookId, String author, String title, String year, String count) {
        try (Formatter productFormatter = new Formatter()) {
            productFormatter.format("%4.4s %-20.20s %-30.30s %-9.9s %6.6s", bookId, author, title, year, count);
            System.out.println(productFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод выводит список читателей.
     */
    public void showReaders() {
        String sql = "SELECT reader_id, name FROM reader " +
                "ORDER BY reader_id;";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            printReadersString("№", "Имя");
            printReadersString("====", "===");

            while (rs.next()) {
                int readerId = rs.getInt("reader_id");
                String name = rs.getString("name");

                printReadersString(String.valueOf(readerId), name);
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод выводит строку с читателями.
     * @param readerId
     * @param name
     */
    private void printReadersString(String readerId, String name) {
        try (Formatter productFormatter = new Formatter()) {
            productFormatter.format("%4.4s %-30.30s", readerId, name);
            System.out.println(productFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод добавляет читателя в БД.
     * @param name
     */
    public void addReader(String name) {
        String sql = "INSERT INTO reader (name) VALUES (?);";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            int recCnt = ps.executeUpdate();

            if (recCnt > 0) {
                System.out.printf("Читатель '{}' добавлен", name);
            } else {
                System.out.printf("Читатель '{}' не был добавлен.", name);
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод назначает выбранную книгу указанному читателю.
     * @param bookNum
     * @param readerNum
     */
    public void takeBook(int bookNum, int readerNum) {
        boolean allRight = true;

        if (!isBookAvailable(bookNum)) {
            System.out.printf("Книга №{} недоступна в библиотеке.", bookNum);
            allRight = false;
        }

        if (!isReaderFound(readerNum)) {
            System.out.printf("Читатель №{} не найден.", readerNum);
            allRight = false;
        }

        if (isAlreadyTaken(bookNum, readerNum)) {
            System.out.printf("Книга №{} уже назначена на читателя №{}.", bookNum, readerNum);
            allRight = false;
        }

        if (allRight) {
            boolean delivered = false;

            /* Если книга уже бралась ранее этим читателем */
            if (bookWasTakenEarlier(bookNum, readerNum)) {
                String sqlDelivery = "UPDATE delivery SET returned = false " +
                        "WHERE reader_id = ? AND book_id = ? AND returned = true;";

                try (PreparedStatement ps = con.prepareStatement(sqlDelivery)) {
                    ps.setInt(1, readerNum);
                    ps.setInt(2, bookNum);
                    int recCnt = ps.executeUpdate();

                    if (recCnt > 0) {
                        delivered = true;
                    }
                } catch (SQLException e) {
                    System.out.println(e.fillInStackTrace());
                }
            } else {
                /* Если читатель первый раз берёт книгу (нет записи выдачи этой книги для читателя) */
                String sqlDelivery = "INSERT INTO delivery (reader_id, book_id, returned) VALUES (?, ?, false);";

                try (PreparedStatement ps = con.prepareStatement(sqlDelivery)) {
                    ps.setInt(1, readerNum);
                    ps.setInt(2, bookNum);
                    int recCnt = ps.executeUpdate();

                    if (recCnt > 0) {
                        delivered = true;
                    }
                } catch (SQLException e) {
                    System.out.println(e.fillInStackTrace());
                }
            }

            /* Если книга назначена читателю, то уменьшаем доступное кол-во книги на 1 */
            if (delivered) {
                String sqlBook = "UPDATE book SET count = count - 1 WHERE book_id = ?";

                try (PreparedStatement ps = con.prepareStatement(sqlBook)) {
                    ps.setInt(1, bookNum);
                    int recCnt = ps.executeUpdate();

                    if (recCnt > 0) {
                        System.out.printf("Книга №{} назначена читателю №{}.", bookNum, readerNum);
                    } else {
                        System.out.printf("Книга №{} не была назначена читателю №{}.", bookNum, readerNum);
                    }
                } catch (SQLException e) {
                    System.out.println(e.fillInStackTrace());
                }
            }
        }
    }

    /**
     * Метод проверяет, доступна ли указанная книга.
     * @param bookNum
     * @return true - доступна, иначе false.
     */
    private boolean isBookAvailable(int bookNum) {
        String sql = "SELECT COUNT(*) cnt FROM book " +
                "WHERE book_id = ? AND count > 0;";

        int recCnt = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, bookNum);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    recCnt = rs.getInt("cnt");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return recCnt > 0;
    }

    /**
     * Метод проверяет, существует ли читатель.
     * @param readerNum
     * @return true - существует, иначе false.
     */
    private boolean isReaderFound(int readerNum) {
        String sql = "SELECT COUNT(*) cnt FROM reader " +
                "WHERE reader_id = ?;";

        int recCnt = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, readerNum);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    recCnt = rs.getInt("cnt");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return recCnt > 0;
    }

    /**
     * Метод проверяет, взял ли уже читатель указанную книгу (чтобы не давать по несколько экземпляров в одни руки).
     * @param bookNum
     * @param readerNum
     * @return true - уже взял, иначе false.
     */
    private boolean isAlreadyTaken(int bookNum, int readerNum) {
        String sql = "SELECT COUNT(*) cnt FROM delivery " +
                "WHERE reader_id = ? AND book_id = ? AND returned = false;";

        int recCnt = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, readerNum);
            ps.setInt(2, bookNum);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    recCnt = rs.getInt("cnt");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return recCnt > 0;
    }

    /**
     * Метод проверяет, бралась ли ранее выбранная указанным читателем (чтобы не плодить записи в таблице Выдача).
     * @param bookNum
     * @param readerNum
     * @return true - бралась ранее, иначе false.
     */
    private boolean bookWasTakenEarlier(int bookNum, int readerNum) {
        String sql = "SELECT COUNT(*) cnt FROM delivery " +
                "WHERE reader_id = ? AND book_id = ? AND returned = true;";

        int recCnt = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, readerNum);
            ps.setInt(2, bookNum);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    recCnt = rs.getInt("cnt");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
        return recCnt > 0;
    }

    /**
     * Метод возвращает книгу в библиотеку (снимает её с читателя.)
     * @param bookNum
     * @param readerNum
     */
    public void returnBook(int bookNum, int readerNum) {
        boolean allRight = true;

        if (!isAlreadyTaken(bookNum, readerNum)) {
            System.out.printf("Не надено книги №{} назначенной на читателя №{}.", bookNum, readerNum);
            allRight = false;
        }

        if (allRight) {
            String sqlDelivery = "UPDATE delivery SET returned = true " +
                    "WHERE reader_id = ? AND book_id = ? AND returned = false;";
            boolean delivered = false;

            try (PreparedStatement ps = con.prepareStatement(sqlDelivery)) {
                ps.setInt(1, readerNum);
                ps.setInt(2, bookNum);
                int recCnt = ps.executeUpdate();

                if (recCnt > 0) {
                    delivered = true;
                }
            } catch (SQLException e) {
                System.out.println(e.fillInStackTrace());
            }

            /* Если книга снята с читателя, то увеличиваем доступное кол-во книги на 1 */
            if (delivered) {
                String sqlBook = "UPDATE book SET count = count + 1 WHERE book_id = ?";

                try (PreparedStatement ps = con.prepareStatement(sqlBook)) {
                    ps.setInt(1, bookNum);
                    int recCnt = ps.executeUpdate();

                    if (recCnt > 0) {
                        System.out.printf("Книга №{} снята с читателя №{}.", bookNum, readerNum);
                    } else {
                        System.out.printf("Книга №{} не была снята с читателя №{}.", bookNum, readerNum);
                    }
                } catch (SQLException e) {
                    System.out.println(e.fillInStackTrace());
                }
            }
        }
    }

    /**
     *  Метод выводит статистику по книгам, а также по авторам.
     */
    public void getStatistics() {
        /* Статистика по книгам*/
        String sqlBooks = "SELECT b.book_id, b.author, b.title, b.year, b.count, COALESCE(dlv.cnt,0) usecnt " +
                "FROM book b " +
                "LEFT JOIN ( " +
                "SELECT book_id, COUNT(*) cnt FROM delivery " +
                "WHERE returned = false " +
                "GROUP BY book_id " +
                ") dlv ON dlv.book_id = b.book_id " +
                "ORDER BY b.book_id;";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sqlBooks)) {
            System.out.println("Статистика по книгам:");
            printBooksString("№", "Автор", "Название", "Год(ы)", "Кол-во", "На руках");
            printBooksString("====", "=====", "========", "======", "======", "========");

            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String author = rs.getString("author");
                String title = rs.getString("title");
                String year = rs.getString("year");
                int count = rs.getInt("count");
                int useCnt = rs.getInt("usecnt");

                printBooksString(String.valueOf(bookId), author, title, year,
                        String.valueOf(count), String.valueOf(useCnt));
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }

        /* Статистика по авторам */
        String sqlAuthors = "SELECT b.author, SUM(b.count) cnt, SUM(COALESCE(dlv.cnt,0)) usecnt FROM book b " +
                "LEFT JOIN ( " +
                "SELECT book_id, COUNT(*) cnt FROM delivery " +
                "WHERE returned = false " +
                "GROUP BY book_id " +
                ") dlv ON dlv.book_id = b.book_id " +
                "GROUP BY b.author " +
                "ORDER BY b.author;";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sqlAuthors)) {
            System.out.println("");
            System.out.println("Статистика по авторам:");
            printAuthorsString("Автор", "Кол-во", "На руках");
            printAuthorsString("=====", "======", "========");

            while (rs.next()) {
                String author = rs.getString("author");
                int count = rs.getInt("cnt");
                int useCnt = rs.getInt("usecnt");

                printAuthorsString(author, String.valueOf(count), String.valueOf(useCnt));
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод выводит строку БД с информацией по книгам.
     * @param bookId
     * @param author
     * @param title
     * @param year
     * @param count
     * @param useCnt
     */
    private void printBooksString(String bookId, String author, String title, String year,
                                  String count, String useCnt) {
        try (Formatter productFormatter = new Formatter()) {
            productFormatter.format("%4.4s %-20.20s %-30.30s %-9.9s %6.6s %8.8s",
                    bookId, author, title, year, count, useCnt);
            System.out.println(productFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод выводит строку с информацией по авторам.
     * @param author
     * @param count
     * @param useCnt
     */
    private void printAuthorsString(String author, String count, String useCnt) {
        try (Formatter productFormatter = new Formatter()) {
            productFormatter.format("%-20.20s %6.6s %8.8s", author, count, useCnt);
            System.out.println(productFormatter);
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод выполняет поиск по автору.
     * @param authorName
     */
    public void searchByAuthor(String authorName) {
        String sql = "SELECT book_id, author, title, year, count FROM book " +
                "WHERE UPPER(author) LIKE CONCAT('%', UPPER(?), '%') " +
                "ORDER BY book_id;";

        try (PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            ps.setString(1, authorName);

            try (ResultSet rs = ps.executeQuery()) {
                rs.last();
                int recCnt = rs.getRow();
                rs.beforeFirst();

                if (recCnt == 0) {
                    System.out.printf("Книги автора '{}' не найдены.", authorName);
                } else {
                    printBooksString("№", "Автор", "Название", "Год(ы)", "Кол-во");
                    printBooksString("====", "=====", "========", "======", "======");

                    while (rs.next()) {
                        int bookId = rs.getInt("book_id");
                        String author = rs.getString("author");
                        String title = rs.getString("title");
                        String year = rs.getString("year");
                        int count = rs.getInt("count");

                        printBooksString(String.valueOf(bookId), author, title, year, String.valueOf(count));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Метод выполняет поиск по названию книги.
     * @param bookTitle
     */
    public void searchByTitle(String bookTitle) {
        String sql = "SELECT book_id, author, title, year, count FROM book " +
                "WHERE UPPER(title) LIKE CONCAT('%', UPPER(?), '%') " +
                "ORDER BY book_id;";

        try (PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE)) {
            ps.setString(1, bookTitle);

            try (ResultSet rs = ps.executeQuery()) {
                rs.last();
                int recCnt = rs.getRow();
                rs.beforeFirst();

                if (recCnt == 0) {
                    System.out.printf("Книги c названием '{}' не найдены.", bookTitle);
                } else {
                    printBooksString("№", "Автор", "Название", "Год(ы)", "Кол-во");
                    printBooksString("====", "=====", "========", "======", "======");

                    while (rs.next()) {
                        int bookId = rs.getInt("book_id");
                        String author = rs.getString("author");
                        String title = rs.getString("title");
                        String year = rs.getString("year");
                        int count = rs.getInt("count");

                        printBooksString(String.valueOf(bookId), author, title, year, String.valueOf(count));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
