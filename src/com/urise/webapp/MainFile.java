package com.urise.webapp;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        File dir = new File("src");
        traverseRecursive(dir, "");
    }

    public static void traverseRecursive(File dir, String offset) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(offset + "F: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(offset + "D: " + file.getName());
                    traverseRecursive(file, offset + "  ");
                }
            }
        }
    }
}
