package demo.controller;

import demo.valueobject.WelcomeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

    @Value("${service.host}")
    private String host;

    @RequestMapping("/")
    public ModelAndView index() {
        final ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("host", host);

        return modelAndView;
    }

    @RequestMapping("/hello")
    public WelcomeMessage hello() {
        return new WelcomeMessage("Greetings from Spring Boot!");
    }
}