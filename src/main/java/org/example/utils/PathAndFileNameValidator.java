package org.example.utils;

import java.io.File;

public class PathAndFileNameValidator {
    public static boolean isValidDirectory(String path) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                return dir.mkdirs();
            }
            return dir.isDirectory() && dir.canWrite();
        } catch (SecurityException e) {
            System.out.println("Ошибка доступа к директории: " + e.getMessage());
            return false;
        }
    }

    public static boolean isValidFileName(String prefix) {
        return prefix.matches("^[a-zA-Z0-9_-]+$");
    }
}
