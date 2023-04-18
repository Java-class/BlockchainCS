package ir.javaclass.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class FileServiceTest {

    @Autowired
    FileService fileService;

    @Test
    void saveFile() throws IOException {
        //fileService.saveFile("sss",null);
    }
}