package main.Innopolis.Lyutyy.task43;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс {@code ConnectionDB} обеспечивает подключение к базе данных.
 * @author Lyutyy Ivan
 */
public class ConnectionDB {
    private static Connection con = null;

    private ConnectionDB() {}

    static
    {
        String jdbcDriver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://127.0.0.1:5432/Library";
        String user = "postgres";
        String pass = "pg12su";

        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает ссылку на подключение к БД.
     * @return ссылка на подключение к БД.
     */
    public static Connection getConnection()
    {
        return con;
    }

    /**
     * Метод закрывает подключение к БД.
     */
    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
