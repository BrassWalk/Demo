package demo.controller;

import demo.valueobject.WelcomeMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public WelcomeMessage hello() {
        return new WelcomeMessage("Greetings from Spring Boot!");
    }
}