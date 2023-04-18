

package ir.javaclass.io;

import ir.javaclass.util.Log;
import ir.javaclass.util.Util;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileUtil {

    private static final double KB = 1024.0;
    private static final double MB = KB * 1024.0;
    private static final double GB = MB * 1024.0;
    private static final double TB = GB * 1024.0;

    public static void deleteFile(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    FileLocker.unlockFile(file);
                    FileUtils.forceDelete(file);
                    Log.debugLog("File '" + file.getAbsolutePath() + "' deleted");
                }
            } catch (Exception ex) {
                Log.errorLog(ex);
            }
        }
    }


    public static String getSHA256(InputStream is) {
        String sha256 = "";
        if (is != null) {
            try {
                sha256 = DigestUtils.sha256Hex(is);
            } catch (Exception ex) {
                Log.errorLog(ex);
            } finally {
                Util.closeInputStream(is);
            }
        }
        return sha256;
    }

    public static String getSHA1(File file) {
        if(file==null||file.isDirectory())
            return null;
        String sha1 = "";
        FileInputStream fis = null;

        if (file != null && file.exists()) {
            try {
                fis = new FileInputStream(file);
                sha1 = DigestUtils.sha1Hex(fis);
            } catch (Exception ex) {
                Log.errorLog(ex);
            } finally {
                Util.closeInputStream(fis);
            }
        }

        return sha1;
    }

    public static String getSHA1(InputStream is) {
        String sha1 = "";

        if (is != null) {
            try {
                sha1 = DigestUtils.sha1Hex(is);
            } catch (Exception ex) {
                Log.errorLog(ex);
            } finally {
                Util.closeInputStream(is);
            }
        }

        return sha1;
    }

    public static String getSHA256(File file) {
        if(file==null||file.isDirectory())
            return null;
        String sha256 = "";
        FileInputStream fis = null;

        if (file != null && file.exists()) {
            try {
                fis = new FileInputStream(file);
                sha256 = DigestUtils.sha256Hex(fis);
            } catch (Exception ex) {
                Log.errorLog(ex);
            } finally {
                Util.closeInputStream(fis);
            }
        }

        return sha256;
    }

    public static String getSHA1(byte[] input, int len) {
        String sha1 = "";

        try {
            if (len == input.length) sha1 = DigestUtils.sha1Hex(input);
            else {
                byte[] data = new byte[len];
                System.arraycopy(input, 0, data, 0, len);
                sha1 = DigestUtils.sha1Hex(data);
            }
        } catch (Exception ignored) {
            Log.errorLog(ignored);
        }

        return sha1;
    }

    public static String getSHA256(byte[] input, int len) {
        String sha256 = "";

        try {
            if (len == input.length) sha256 = DigestUtils.sha256Hex(input);
            else {
                byte[] data = new byte[len];
                System.arraycopy(input, 0, data, 0, len);
                sha256 = DigestUtils.sha256Hex(data);
            }
        } catch (Exception ignored) {
            Log.errorLog(ignored);
        }

        return sha256;
    }

    public static String getSHA1(String input) {
        String sha1 = "";

        try {
            sha1 = DigestUtils.sha1Hex(input);
        } catch (Exception ignored) {
            Log.errorLog(ignored);
        }

        return sha1;
    }

    public static String getSHA256(String input) {
        String sha256 = "";

        try {
            sha256 = DigestUtils.sha256Hex(input);
        } catch (Exception ignored) {
            Log.errorLog(ignored);
        }

        return sha256;
    }

    public static String getMD5(String input) {
        String md5 = "";

        if (input != null) {
            try {
                md5 = DigestUtils.md5Hex(input);
            } catch (Exception ex) {
                Log.errorLog(ex);
            }
        }

        return md5;
    }

    public static String getMD5(InputStream is) {
        String md5 = "";

        if (is != null) {
            try {
                md5 = DigestUtils.md5Hex(is);
            } catch (Exception ex) {
                Log.errorLog(ex);
            } finally {
                Util.closeInputStream(is);
            }
        }

        return md5;
    }

    public static String getMD5(File file) {
        if(file==null||file.isDirectory())
            return null;
        String md5 = "";
        FileInputStream fis = null;

        if (file != null && file.exists()) {
            try {
                fis = new FileInputStream(file);
                md5 = DigestUtils.md5Hex(fis);
            } catch (Exception ex) {
                Log.errorLog(ex);
            } finally {
                Util.closeInputStream(fis);
            }
        }

        return md5;
    }


    public static void writeStringToFile(File file, String data, String encoding, boolean append) throws IOException {
        try {
            FileLocker.lockFile(file);
            FileUtils.writeStringToFile(file, data, encoding, append);
        }catch (Exception ex){
            Log.errorLog(ex);
        } finally {
            FileLocker.unlockFile(file);
        }
    }


    private static long getFilesSize(File file) {
        File[] files = file.listFiles();
        long count = 0;
        for (File f : files)
            if (f.isDirectory())
                count += getFilesSize(f);
            else
                count+=f.length();

        return count;
    }

}

