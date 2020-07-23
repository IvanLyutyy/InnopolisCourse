package main.Innopolis.Lyutyy.task15.task01;

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
 * @author Lyutyy Ivan
 */
public class WorkWithFiles {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName1;
        String fileName2;
        String filePath1;
        String filePath2;

        while (true) {
            System.out.println("");
            System.out.println("Введите № операции (exit для выхода):");
            System.out.println("1 - создать папку");
            System.out.println("2 - создать файл");
            System.out.println("3 - переименовать папку");
            System.out.println("4 - переименовать файл");
            System.out.println("5 - копировать файл");
            System.out.println("6 - удалить папку");
            System.out.println("7 - удалить файл");

            String line = br.readLine();
            if (line.equals("exit")) break;

            switch (line) {
                case "1":
                    System.out.println("Введите полный путь до создаваемой папки:");
                    filePath1 = br.readLine();
                    FileUtility.createDirectories(filePath1);
                    break;
                case "2":
                    System.out.println("Введите полный путь к создаваемому файлу (с именем файла):");
                    fileName1 = br.readLine();
                    FileUtility.createFile(fileName1);
                    break;
                case "3":
                    System.out.println("Введите полный путь к папке, которую хотите переименовать:");
                    filePath1 = br.readLine();
                    System.out.println("Введите полный путь с новым именем папки:");
                    filePath2 = br.readLine();
                    FileUtility.renameFolder(filePath1,filePath2);
                    break;
                case "4":
                    System.out.println("Введите полный путь к файлу (с именем файла), который хотите переименовать:");
                    fileName1 = br.readLine();
                    System.out.println("Введите полный путь к файлу (с новым именем файла):");
                    fileName2 = br.readLine();
                    FileUtility.renameFile(fileName1,fileName2);
                    break;
                case "5":
                    System.out.println("Введите полный путь к файлу (с именем файла), который хотите копировать:");
                    fileName1 = br.readLine();
                    System.out.println("Введите полный путь к папке, в которую копируете файл:");
                    filePath1 = br.readLine();
                    try {
                        FileUtility.copyFile(fileName1, filePath1);
                    } catch (IOException e) {
                        System.out.println("Ошибка ввода-вывода:");
                        System.out.println(e.fillInStackTrace());
                    }
                    break;
                case "6":
                    System.out.println("Введите полный путь к папке, которую хотите удалить:");
                    filePath1 = br.readLine();
                    FileUtility.deleteFolder(filePath1);
                    break;
                case "7":
                    System.out.println("Введите полный путь к файлу (с именем файла), который хотите удалить:");
                    fileName1 = br.readLine();
                    FileUtility.deleteFile(fileName1);
                    break;
                default:
                    System.out.println("Введён некорректный номер операции");
                    break;
            }
        }
    }
}
