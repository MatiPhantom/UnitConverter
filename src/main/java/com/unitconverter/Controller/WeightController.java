package com.unitconverter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unitconverter.Service.WeightService;


@Controller
@RequestMapping("/weight")
public class WeightController {
    
    @Autowired
    private WeightService weightService;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("unities", weightService.getUnities());
        return "weight/index";
    }
    
}
