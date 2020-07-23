package Lyutyy.task15.task01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс создаёт, переименовывает, копирует и удаляет файл.
 * Суть задачи:
 * Написать программу, которая будет создавать, переименовывать, копировать и удалять файл.
 * Написать рекурсивный обход всех файлов и подкаталогов внутри заданного каталога.
 * Дополнительное задание (необязательно): программа должна следить за глубиной рекурсии,
 * сдвигая название файла/каталога на соответствующее количество пробелов.
 * @author Savin Vladimir
 */
public class WorkWithFiles {
    static final Logger log = LogManager.getLogger(WorkWithFiles.class.getName());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName1;
        String fileName2;
        String filePath1;
        String filePath2;

        while (true) {
            log.info("");
            log.info("Введите № операции (exit для выхода):");
            log.info("1 - создать папку");
            log.info("2 - создать файл");
            log.info("3 - переименовать папку");
            log.info("4 - переименовать файл");
            log.info("5 - копировать файл");
            log.info("6 - удалить папку");
            log.info("7 - удалить файл");

            String line = br.readLine();
            if (line.equals("exit")) break;

            switch (line) {
                case "1":
                    log.info("Введите полный путь до создаваемой папки:");
                    filePath1 = br.readLine();
                    FileUtility.createDirectories(filePath1);
                    break;
                case "2":
                    log.info("Введите полный путь к создаваемому файлу (с именем файла):");
                    fileName1 = br.readLine();
                    FileUtility.createFile(fileName1);
                    break;
                case "3":
                    log.info("Введите полный путь к папке, которую хотите переименовать:");
                    filePath1 = br.readLine();
                    log.info("Введите полный путь с новым именем папки:");
                    filePath2 = br.readLine();
                    FileUtility.renameFolder(filePath1,filePath2);
                    break;
                case "4":
                    log.info("Введите полный путь к файлу (с именем файла), который хотите переименовать:");
                    fileName1 = br.readLine();
                    log.info("Введите полный путь к файлу (с новым именем файла):");
                    fileName2 = br.readLine();
                    FileUtility.renameFile(fileName1,fileName2);
                    break;
                case "5":
                    log.info("Введите полный путь к файлу (с именем файла), который хотите копировать:");
                    fileName1 = br.readLine();
                    log.info("Введите полный путь к папке, в которую копируете файл:");
                    filePath1 = br.readLine();
                    try {
                        FileUtility.copyFile(fileName1, filePath1);
                    } catch (IOException e) {
                        log.error("Ошибка ввода-вывода:");
                        log.error(e.fillInStackTrace());
                    }
                    break;
                case "6":
                    log.info("Введите полный путь к папке, которую хотите удалить:");
                    filePath1 = br.readLine();
                    FileUtility.deleteFolder(filePath1);
                    break;
                case "7":
                    log.info("Введите полный путь к файлу (с именем файла), который хотите удалить:");
                    fileName1 = br.readLine();
                    FileUtility.deleteFile(fileName1);
                    break;
                default:
                    log.error("Введён некорректный номер операции");
                    break;
            }
        }
    }
}
