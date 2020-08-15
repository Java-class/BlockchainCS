package ir.javaclass.rest;

import ir.javaclass.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
public class FileController {

    FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PutMapping(value = "/file/upload")
    public String uploadFile(@RequestParam("public_key") String publicKey, @RequestParam("file") MultipartFile inputFile) throws IOException {
        fileService.saveFile(publicKey,inputFile);
        return "true";
    }

    @PutMapping(value = "/file/multi-upload")
    public String uploadMultipartFile(@RequestParam("public_key") String publicKey, @RequestParam("file") MultipartFile[] parts) throws IOException {
        for(MultipartFile inputFile :parts) {
            fileService.saveFile(publicKey, inputFile);
        }
        return "true";
    }
}
