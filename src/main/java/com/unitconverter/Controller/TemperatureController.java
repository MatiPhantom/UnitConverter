package com.unitconverter.Controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitconverter.Service.TemperatureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/temperature")
public class TemperatureController {
    @Autowired
    private TemperatureService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("unities", service.getUnities()); 

        return "temperature/index";
    }

    @GetMapping("/{result}")
    public String index(Model model,@PathVariable double result) {
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
