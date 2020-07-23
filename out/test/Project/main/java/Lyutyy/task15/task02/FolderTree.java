package Lyutyy.task15.task02;

import java.io.File;

public class FolderTree {
    public void getFolderTree(String folder, int nestingLevel) {
        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < nestingLevel; i++) {
            tabs.append('\t');
        }
        File folderFile = new File(folder);
        File[] folderList = folderFile.listFiles();
        for (File file : folderList) {
            System.out.println(tabs.toString() + file.getName());
            if (file.isDirectory()) {
                getFolderTree(file.getAbsolutePath(),nestingLevel + 1);
            }
        }
    }
}
