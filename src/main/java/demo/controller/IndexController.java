package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Value("${service.host}")
    private String host;

    @RequestMapping("/")
    public ModelAndView index() {
        final ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("host", host);

        return modelAndView;
    }
}