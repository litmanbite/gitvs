package com.example.proj1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/about")
public class AboutController {
    @GetMapping
    public String homeAbout() {
        return "about"; // Nome do template HTML
    }
}
