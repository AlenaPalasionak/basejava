package com.urise.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File dir = new File("src");
        traverseRecursive(dir);
    }

    public static void traverseRecursive(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    traverseRecursive(file);
                }
            }
        }
    }
}
