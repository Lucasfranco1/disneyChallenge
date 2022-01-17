package disney.challenge.entities.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/") 
public class HomeController {

    @GetMapping("/") 
    public String index() {
        return "index.html";
    }
     @GetMapping("/home") 
    public String home() {
        return "index.html";
    }
}
