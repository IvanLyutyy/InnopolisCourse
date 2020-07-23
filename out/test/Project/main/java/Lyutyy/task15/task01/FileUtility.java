package Lyutyy.task15.task01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс выполняет операции с файлами и папками
 */
public class FileUtility {
    static final Logger log = LogManager.getLogger(FileUtility.class.getName());

    public static boolean checkIfNameCorrect(String name) {
        Pattern pattern = Pattern.compile("(.+)?[><\\|\\?*/:\\\\\"](.+)?");
        Matcher matcher = pattern.matcher(name);
        return !matcher.find();
    }

    public static boolean createDirectory(String pathName) {
        File folder = new File(pathName);
        if (folder.exists() && folder.isDirectory()) {
            log.error("Папка {} уже существует",pathName);
            return true;
        }
        if (folder.mkdir()) {
            log.info("Папка {} создана",pathName);
            return true;
        } else {
            log.error("Папка {} не создана",pathName);
            return false;
        }
    }

    public static boolean createDirectories(String pathName) {
        try {
            File folder = new File(pathName);
            if (folder.exists() && folder.isDirectory()) {
                log.error("Папка {} уже существует",pathName);
                return true;
            }
            if (folder.mkdirs()) {
                log.info("Папка {} создана",pathName);
                return true;
            } else {
                log.error("Папка {} не создана",pathName);
                return false;
            }
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
        }
        return false;
    }

    public static boolean createFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.isFile()) {
            log.error("Файл {} уже существует",file.getAbsolutePath());
            return true;
        }
        try {
            if (file.createNewFile()) {
                log.info("Файл {} создан",file.getAbsolutePath());
                return true;
            } else {
                log.error("Файл {} не создан",file.getAbsolutePath());
                return false;
            }
        } catch (IOException e) {
            log.error(e.fillInStackTrace());
        }
        return false;
    }

    public static boolean renameFolder(String pathName1, String pathName2) {
        File path1 = new File(pathName1);
        File path2 = new File(pathName2);
        if (!path1.exists()) {
            log.error("Папка {} не существует",pathName1);
            return false;
        }
        if (path2.exists() && path2.isDirectory()) {
            log.error("Папка {} уже существует",pathName2);
            return false;
        }
        if (path1.renameTo(path2)) {
            log.info("Папка {} переименована в {}",pathName1,pathName2);
            return true;
        } else {
            log.error("Папка {} не была переименована",pathName1);
            return false;
        }
    }

    public static boolean renameFile(String fileName1, String fileName2) {
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        if (!file1.exists()) {
            log.error("Файл {} не существует",fileName1);
            return false;
        }
        if (file2.exists() && file2.isFile()) {
            log.error("Файл {} уже существует",fileName2);
            return false;
        }
        if (file1.renameTo(file2)) {
            log.info("Файл {} переименован в {}",fileName1,fileName2);
            return true;
        } else {
            log.error("Файл {} не был переименован",fileName1);
            return false;
        }
    }

    public static boolean copyFile(String file, String path) throws IOException {
        File inputFile = new File(file);
        File outputFile = new File(path + File.separator + inputFile.getName());
        try (FileInputStream fis = new FileInputStream(inputFile);
                FileOutputStream fos = new FileOutputStream(outputFile)) {
            if (copyFileWithStream(fis, fos)) {
                log.info("Файл {} скопирован в {}",file,path);
                return true;
            }
        }
        return false;
    }

    public static boolean copyFileWithStream(InputStream is, OutputStream os) {
        int nLength;
        byte[] buf = new byte[8000];
        try {
            while (true) {
                nLength = is.read(buf);
                if (nLength < 0) {
                    break;
                }
                os.write(buf, 0, nLength);
            }
            is.close();
            os.close();
        } catch (Exception e) {
            log.error(e.fillInStackTrace());
            return false;
        }
        return true;
    }

    public static boolean deleteFolder(String pathName) {
        File path = new File(pathName);
        if (!path.exists()) {
            log.error("Папка {} не существует",pathName);
            return false;
        }
        if (path.exists() && path.isDirectory()) {
            if (path.delete()) {
                log.info("Папка {} удалена",pathName);
                return true;
            } else {
                log.error("Папка {} не был удалена",pathName);
                return false;
            }
        }
        return false;
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            log.error("Файл {} не существует",fileName);
            return false;
        }
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                log.info("Файл {} удалён",fileName);
                return true;
            } else {
                log.error("Файл {} не был удалён",fileName);
                return false;
            }
        }
        return false;
    }
}
