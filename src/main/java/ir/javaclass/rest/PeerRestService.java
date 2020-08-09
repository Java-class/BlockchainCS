package ir.javaclass.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeerRestService {

    @GetMapping("/peer/info")
    public String getTestService() {
        return "Hello World !This is coming from webservice !!";
    }

}
