package ir.javaclass.rest;

import ir.javaclass.model.FileInfoDto;
import ir.javaclass.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@RestController
public class FileRestService {

    FileService fileService;

    @Autowired
    public FileRestService(FileService fileService) {
        this.fileService = fileService;
    }

    @PutMapping(value = "/file/upload")
    public String uploadFile(@RequestParam("public_key") String publicKey, @RequestParam("file") MultipartFile inputFile) throws IOException {
        fileService.saveFile(publicKey,inputFile);
        return "true";
    }

    @GetMapping(value = "/file/info")
    public ResponseEntity<FileInfoDto> getFileInfo(@RequestParam("public_key") String publicKey, @RequestParam("file_name") String fileName) throws IOException {
       FileInfoDto infoDto = fileService.getFileInfo(publicKey, fileName);
       if(infoDto!=null)
           return ResponseEntity.ok(infoDto);
       else
           return ResponseEntity.notFound().build();

    }
    @PutMapping(value = "/file/multi-upload")
    public String uploadMultipartFile(@RequestParam("public_key") String publicKey, @RequestParam("file") MultipartFile[] parts) throws IOException {
        for(MultipartFile inputFile :parts) {
            fileService.saveFile(publicKey, inputFile);
        }
        return "true";
    }

    @GetMapping("/file/download/{fileName}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@RequestHeader("public_key") String publicKey, @PathVariable String fileName) throws IOException {
        Resource file = fileService.loadAsResource(publicKey, fileName);
        if(file.exists()) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        }else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/file/delete/{fileName}")
    @ResponseBody
    public ResponseEntity<Resource> deleteFile(@RequestHeader("public_key") String publicKey, @PathVariable String fileName) {
        boolean result = fileService.deleteFile(publicKey, fileName);
        if(result)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}
