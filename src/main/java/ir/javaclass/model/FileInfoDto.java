package ir.javaclass.model;

import ir.javaclass.io.FileUtil;
import lombok.Getter;

import java.io.File;

@Getter
public class FileInfoDto {
    private final String name;
    private final String hash;
    private final long size;
    private final long lastModification;

    public FileInfoDto(File file){
        this.name = file.getName();
        this.hash = FileUtil.getSHA256(file);
        this.size = file.length();
        this.lastModification = file.lastModified();
    }
}
