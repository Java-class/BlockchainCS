package ir.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("index controller is called.");
        return  "index";
    }

    @RequestMapping("/login")
    public String next(Map<String, Object> model) {
        return "login";
    }

}
