package com.unitconverter.Controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitconverter.Service.TemperatureService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@Slf4j
@RequestMapping("/temperature")
public class TemperatureController {
    @Autowired
    @Lazy
    private TemperatureService service;

    @GetMapping
    public String index(Model model, @RequestParam(required = false, name = "result") String result) {
        model.addAttribute("unities", service.getUnities()); 
            model.addAttribute("result", result);     
        return "temperature/index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("value") double value, 
                          @RequestParam("from") String from, 
                          @RequestParam("to") String to, 
                          RedirectAttributes redirect) {
        String result = service.convertTo(value, from, to);
        
        return "redirect:/temperature?result=" + result;
    }
    
    
}
