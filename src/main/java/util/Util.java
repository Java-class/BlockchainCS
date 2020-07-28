
package util;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.util.*;

public class Util {
    public static final long TIME_SECOND = 1000;
    public static final long TIME_5SECOND = TIME_SECOND * 5;
    public static final long TIME_MINUTE = TIME_SECOND * 60;
    public static final long TIME_5MINUTE = TIME_MINUTE * 5;
    public static final long TIME_HOUR = TIME_MINUTE * 60;
    public static final long TIME_DAY = TIME_HOUR * 24;
    public static final long TIME_WEEK = TIME_DAY * 7;
    public static final long TIME_MONTH = TIME_DAY * 30;
    public static final long TIME_YEAR = TIME_DAY * 365;

    static final String[] persianNumbers = {
            "۰", "۱", "۲", "۳", "۴",
            "۵", "۶", "۷", "۸", "۹",
    };

    public static String convertNumbersToPersian(String input) {
        for (int i = 0; i < 10; i++)
            input = input.replace(String.valueOf(i), persianNumbers[i]);

        return input;
    }

    public static int tryToInt(String input, int defValue) {
        int result;

        try {
            if (input != null) result = Integer.parseInt(input);
            else result = defValue;
        } catch (Exception ex) {
            result = defValue;
        }

        return result;
    }

    public static long tryToLong(String input, long defValue) {
        long result;

        try {
            if (input != null) result = Long.parseLong(input);
            else result = defValue;
        } catch (Exception ex) {
            result = defValue;
        }

        return result;
    }

    public static boolean tryToBool(String input, boolean defValue) {
        boolean result;
        try {
            if (input != null) {
                result = input.equals("1") || !input.equals("0") && Boolean.valueOf(input);
            } else result = defValue;
        } catch (Exception ex) {
            result = defValue;
        }
        return result;
    }

    public static String tryToString(String input, String defValue) {
        String result = input;
        if (result == null) result = defValue;
        return result;
    }

    public static Double tryToDouble(String input, double defValue) {
        Double result;

        try {
            if (input != null) result = Double.parseDouble(input);
            else result = defValue;
        } catch (Exception ex) {
            result = defValue;
        }

        return result;
    }

    public static boolean isNumber(String input) {
        boolean result = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void closeReader(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception ignored) {
            }
        }
    }

    public static void closeWriter(Writer writer) {
        if (writer != null) {
            try {
                writer.flush();
                writer.close();
            } catch (Exception ignored) {
            }
        }
    }

    public static void closeInputStream(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception ignored) {
            }
        }
    }

    public static void closeOutputStream(OutputStream stream) {
        if (stream != null) {
            try {
                stream.flush();
                stream.close();
            } catch (Exception ignored) {
            }
        }
    }





    public static String getTwoDigit(String numStr) {
        int num = tryToInt(numStr, 0);
        if (num < 0) num = -num;
        if (num >= 0 && num <= 9) return "0" + num;
        else return String.valueOf(num);
    }

    public static String getTwoDigit(int num) {
        return getTwoDigit(String.valueOf(num));
    }
    

    public static void sleep(long time) {
        try {
            if (time < 0) time = 50;
            Thread.sleep(time);
        } catch (Exception ignored) {
        }
    }












    public static String getHeader(Map<String, String> headers, String key) {
        String result = null;
        if (key != null) {
            if (headers.containsKey(key)) result = headers.get(key);
            else {
                key = key.toLowerCase();
                Set<String> keys = headers.keySet();
                for (String hkey : keys) {
                    if (hkey != null && hkey.toLowerCase().equals(key)) {
                        result = headers.get(hkey);
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void close(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception ignored) {
                Log.errorLog(ignored);
            }
        }
    }

    public static void close(Writer writer) {
        if (writer != null) {
            try {
                writer.flush();
                writer.close();
            } catch (Exception ignored) {
                Log.errorLog(ignored);
            }
        }
    }

    public static void close(InputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception ignored) {
                Log.errorLog(ignored);
            }
        }
    }

    public static void close(OutputStream stream) {
        if (stream != null) {
            try {
                stream.flush();
                stream.close();
            } catch (Exception ignored) {
                Log.errorLog(ignored);
            }
        }
    }

    private static void close(HttpURLConnection con) {
        if (con != null) {
            try {
                con.disconnect();
            } catch (Exception ignored) {
                Log.errorLog(ignored);
            }
        }
    }

    public static void close(Object... objs) {
        if (objs != null) {
            for (Object obj : objs) {
                if (obj != null) {
                    if (obj instanceof Reader) close((Reader) obj);
                    else if (obj instanceof Writer) close((Writer) obj);
                    else if (obj instanceof InputStream) close((InputStream) obj);
                    else if (obj instanceof OutputStream) close((OutputStream) obj);
                    else if (obj instanceof HttpURLConnection) close((HttpURLConnection) obj);
                }
            }
        }
    }

    public static void checkNull(Object param, String name) {
        if (param == null)
            throw new NullPointerException(name + " can not be null.");
    }

    public static void checkEmpty(String param, String name) {
        if (param.length() == 0)
            throw new IllegalArgumentException(name + " can not be empty.");
    }

    public static void checkNullOrEmpty(String param, String name) {
        if (param == null)
            throw new NullPointerException(name + " can not be null.");

        if (param.length() == 0)
            throw new IllegalArgumentException(name + " can not be empty.");
    }

    public static void checkLowerRange(int param, int lowLimit, String name) {
        if (param < lowLimit)
            throw new IllegalArgumentException(param + " must be greater than " + lowLimit + ".");
    }

    public static void checkUperRange(int param, int upLimit, String name) {
        if (param > upLimit)
            throw new IllegalArgumentException(param + " must be smaller than " + upLimit + ".");
    }

    public static void checkRange(int param, int lowLimit, int upLimit, String name) {
        if (param < lowLimit || param > upLimit)
            throw new IllegalArgumentException(param + " must be greater than " + lowLimit + " and smaller than " + upLimit + ".");
    }


    public static String getClientIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("HTTP_VIA");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    //<---------------------------------------------------------- private methods start -------------------------------------------------------->
    public static void writeToFile(InputStream inputStream, String filePath,boolean append){
        OutputStream outputStream = null;
        try {
            outputStream =
                    new FileOutputStream(new File(filePath),append);
            int read = 0;
            byte[] bytes = new byte[4096];
            while (inputStream.available()>0) {
                read = inputStream.read(bytes);
                outputStream.write(bytes, 0, read);
            }
            Log.debugLog("Write Data to File: " + filePath + " Done!");
        } catch (IOException e) {
            Log.errorLog(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.errorLog(e);
                }
            }if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    Log.errorLog(e);
                }
            }
        }
    }


    public static String readFileToString(String path) {
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        if (file.exists()) {
            BufferedReader reader = null;
            String line;

            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"), 1024 * 50);
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
            } catch (Exception ex) {
                Log.errorLog(ex);
            } finally {
                closeReader(reader);
            }
        }

        return sb.toString();
    }
    public static String loadSVGFile(String filePath) {
        return readFileToString(filePath);
    }
    public static String readFileToString(File input) {
        return readFileToString(input.getAbsolutePath());
    }

}
