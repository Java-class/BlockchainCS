package io;


import java.io.File;
import java.util.HashSet;

public class FileLocker {

    private static final Object LOCK = new Object();
    private static HashSet<String> lockedList = new HashSet<String>();

    public static boolean tryLockFile(File file) {
        return file == null || tryLockFile(file.getAbsolutePath());
    }

    public static boolean tryLockFile(String path) {

        if (path == null) return true;
        synchronized (LOCK) {
            if (!lockedList.contains(path)) {
                lockedList.add(path);
                return true;
            }
            return false;
        }
    }

    public static void lockFile(File file) {

        while (!tryLockFile(file))
            sleep(50);
    }

    public static void lockFile(String path) {
        while (!tryLockFile(path))
            sleep(50);
    }

    public static void lockFile(File file, long sleep) {

        while (!tryLockFile(file))
            sleep(sleep);
    }

    public static void lockFile(String path, long sleep) {
        while (!tryLockFile(path))
            sleep(sleep);
    }

    public static void unlockFile(File file) {
        if (file != null) unlockFile(file.getAbsolutePath());
    }

    public static void unlockFile(String path) {
        if (path != null) {
            synchronized (LOCK) {
                lockedList.remove(path);
            }
        }
    }

    public static boolean isLockFile(String path) {
        if (path == null) return true;

        synchronized (LOCK) {
            return lockedList.contains(path);
        }
    }

    public static boolean isLockFile(File file) {
        return file == null || isLockFile(file.getAbsolutePath());
    }

    public static boolean checkChildLock(File file) {
        if (isLockFile(file)) return true;

        if (file.isDirectory()) {
            for (File childFile : file.listFiles()) {
                if (checkChildLock(childFile)) return true;
            }
        }
        return false;
    }

    public static void sleep(long time) {
        try {
            if (time < 0) time = 50;
            Thread.sleep(time);
        } catch (Exception ignored) {
        }
    }
}
