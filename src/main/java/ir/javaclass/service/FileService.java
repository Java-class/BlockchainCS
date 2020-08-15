package ir.javaclass.service;

import ir.javaclass.config.Commons;
import ir.javaclass.config.FileDelimiter;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
@Scope(value = "prototype")
public class FileService {

    public boolean saveFile(String publicKey, MultipartFile inputFile) throws IOException {
        File userDirectory = new File(Commons.getPeerSetting().getMountAddress() + FileDelimiter.getSystemDelimiter() + publicKey);
        if(!userDirectory.exists())
            FileUtils.forceMkdir(userDirectory);
        File desFile = new File(userDirectory.getAbsolutePath() + FileDelimiter.getSystemDelimiter() + inputFile.getResource().getFilename());
        try(InputStream inputStream = inputFile.getInputStream()){
            FileUtils.copyToFile(inputStream,desFile);
        }
        return true;
    }

    public Resource loadAsResource(String publicKey, String fileName) throws IOException {
        File file = loadFile(publicKey, fileName);
        if(file.exists())
            return new FileSystemResource(file);
        else
            return null;
    }

    public File loadFile(String publicKey, String fileName){
        File userDirectory = new File(Commons.getPeerSetting().getMountAddress() + FileDelimiter.getSystemDelimiter() + publicKey);
        if(userDirectory.exists()){
            return new File(userDirectory.getAbsolutePath() + FileDelimiter.getSystemDelimiter() + fileName);
        }else
            return null;
    }

}
