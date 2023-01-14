package br.com.crud.backend.tests;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Swagger {
    @GetMapping("/")
    public String home() {
        return "redirect:/swagger-ui/index.html";
    }

}