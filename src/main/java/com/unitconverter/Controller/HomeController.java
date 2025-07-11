package com.unitconverter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("unitconverter/")    
public class HomeController {
    @GetMapping
    public String index() {
        return "home/index";
    }
    
}
