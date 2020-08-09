

import ir.javaclass.io.FileSplitter;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class Testing {
    private static final String dir = "C:\\Users\\Mostafa\\Desktop\\2020-06-09_20-26-06-cloud computing final session.mp4";
    private static final String suffix = "-chunk";
    public static void main(String[] args) {
        File orig = new File(dir);
        if(orig.exists()){
            System.out.println("orig file is exit... length: " +  orig.length());
            System.out.println("start chunking file...");
            try {
                FileSplitter fs = new FileSplitter(orig,50,"C:\\Users\\Mostafa\\Desktop");
                //List<File> files = fs.doSplit();
                List<File> files = fs.doSplit();
                File finalMerge = new File("C:\\Users\\Mostafa\\Desktop\\result.mp4");

                mergeFiles(files,finalMerge);
                /*for (File f:files) {
                    System.out.println("#### " + f.getName());
                    InputStream inputStream = new FileInputStream(f);
                    writeToFile(inputStream, finalMerge.getAbsolutePath(), true);
                    inputStream.close();
                }*/
            } catch (Exception  e) {
                e.printStackTrace();
            }
        }
    }


    public static void writeToFile(InputStream inputStream, String filePath,boolean append){
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(filePath),append);
            int read = 0;
            byte[] bytes = new byte[4096];
            while (inputStream.available()>0) {
                read = inputStream.read(bytes);
                outputStream.write(bytes, 0, read);
            }
            System.out.println("Write Data to File: " + filePath + " Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                   e.printStackTrace();
                }
            }
        }
    }


    public static void mergeFiles(List<File> files, File into)
            throws IOException {
        try (FileOutputStream fos = new FileOutputStream(into);
             BufferedOutputStream mergingStream = new BufferedOutputStream(fos)) {
            for (File f : files) {
                Files.copy(f.toPath(), mergingStream);
            }
        }
    }







}
