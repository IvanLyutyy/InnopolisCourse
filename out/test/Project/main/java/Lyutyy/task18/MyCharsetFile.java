package Lyutyy.task18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Используя данный класс, можно скопировать файл в одной кодировке в файл с другой кодировкой
 * Суть задачи:
 * Написать программу, которая копирует файл с одной кодировкой в файл с другой.
 * @author Savin Vladimir
 */
public class MyCharsetFile {
    static final Logger log = LogManager.getLogger(MyCharsetFile.class.getName());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Charset koi8r = Charset.forName("KOI8-R");
        Charset windows1251 = Charset.forName("windows-1251");

        String fileName1;
        String fileName2;
        String text;

        while (true) {
            log.info("");
            log.info("Введите № операции (exit для выхода):");
            log.info("1 - записать в файл KOI8-R");
            log.info("2 - записать в файл Windows-1251");
            log.info("3 - прочитать файл KOI8-R");
            log.info("4 - прочитать файл Windows-1251");
            log.info("5 - копировать файл из KOI8-R в Windows-1251");
            log.info("6 - копировать файл из Windows-1251 в KOI8-R");

            String line = br.readLine();
            if (line.equals("exit")) break;

            switch (line) {
                case "1":
                    log.info("Введите имя записываемого файла (можно с полным путём) с кодировкой KOI8-R:");
                    fileName1 = br.readLine();
                    log.info("Введите строку текста для записи в файл:");
                    text = br.readLine();
                    if (!CharsetFiles.writeFileWithCharset(fileName1, text, koi8r)) {
                        log.error("Файл {} не был записан", fileName1);
                    }
                    break;
                case "2":
                    log.info("Введите имя записываемого файла (можно с полным путём) с кодировкой Windows-1251:");
                    fileName1 = br.readLine();
                    log.info("Введите строку текста для записи в файл:");
                    text = br.readLine();
                    if (!CharsetFiles.writeFileWithCharset(fileName1, text, windows1251)) {
                        log.error("Файл {} не был записан", fileName1);
                    }
                    break;
                case "3":
                    log.info("Введите имя файла (можно с полным путём) с кодировкой KOI8-R для чтения:");
                    fileName1 = br.readLine();
                    if (!CharsetFiles.readFileWithCharset(fileName1, koi8r)) {
                        log.error("Файл {} не был прочитан", fileName1);
                    }
                    break;
                case "4":
                    log.info("Введите имя файла (можно с полным путём) с кодировкой Windows-1251 для чтения:");
                    fileName1 = br.readLine();
                    if (!CharsetFiles.readFileWithCharset(fileName1, windows1251)) {
                        log.error("Файл {} не был прочитан", fileName1);
                    }
                    break;
                case "5":
                    log.info("Введите имя копируемого файла (можно с полным путём) с кодировкой KOI8-R:");
                    fileName1 = br.readLine();
                    log.info("Введите имя записываемого файла (можно с полным путём) с кодировкой Windows-1251:");
                    fileName2 = br.readLine();
                    if (!CharsetFiles.copyFileWithCharsets(fileName1, koi8r, fileName2, windows1251)) {
                        log.error("Файл {} не был скопирован в {}", fileName1, fileName2);
                    }
                    break;
                case "6":
                    log.info("Введите имя копируемого файла (можно с полным путём) с кодировкой Windows-1251:");
                    fileName1 = br.readLine();
                    log.info("Введите имя записываемого файла (можно с полным путём) с кодировкой KOI8-R:");
                    fileName2 = br.readLine();
                    if (!CharsetFiles.copyFileWithCharsets(fileName1, windows1251, fileName2, koi8r)) {
                        log.error("Файл {} не был скопирован в {}", fileName1, fileName2);
                    }
                    break;
                default:
                    log.error("Введён некорректный номер операции");
                    break;
            }
        }
    }
}
