package Lyutyy.task15.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс выводит дерево файлов и подкаталогов для указанной папки
 */
public class Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filePath;
        FolderTree ft = new FolderTree();

        while (true) {
            System.out.println("Введите путь к папке, чтобы вывести её дерево файлов и подкаталогов (Выход: exit)");
            filePath = br.readLine();
            if (filePath.equals("exit")) break;

            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Папка " + filePath + " не сществует");
                continue;
            }
            if (!file.isDirectory()) {
                System.out.println("Нужно указать путь к папке");
                continue;
            }

            ft.getFolderTree(filePath,0);
            System.out.println();
        }
    }
}
