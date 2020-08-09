package ir.javaclass.io;

import ir.javaclass.config.Commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSplitter {

    private File origFile;
    private int splitSize;
    private String outDirectory;
    private String chunkSuffix = Commons.CHUNK_SUFFIX;

    public FileSplitter(File origFile, int splitSize, String outDirectory) {
        this.origFile = origFile;
        this.splitSize = splitSize;
        this.outDirectory = outDirectory;
    }


    public List<File> doSplit() throws IOException {
        List<File> files = new ArrayList<>();
        int partCounter = 1;
        int sizeOfFiles = 1024 * 1024 * 10;// 10MB
        byte[] buffer = new byte[sizeOfFiles];

        try (FileInputStream fis = new FileInputStream(origFile);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int bytesAmount = 0;
            while ((bytesAmount = bis.read(buffer)) > 0) {
                String filePartName = origFile.getAbsolutePath() + chunkSuffix + partCounter++;
                File newFile = new File(filePartName);
                try (FileOutputStream out = new FileOutputStream(newFile)) {
                    out.write(buffer, 0, bytesAmount);
                }
                files.add(newFile);
            }
        }
        return files;
    }

}
