package com.unitconverter.Controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitconverter.Service.WeightService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/weight")
@Slf4j
public class WeightController {
    
    @Autowired
    @Lazy
    private WeightService weightService;
    @GetMapping
    public String index(Model model,@RequestParam(required = false,name = "result")String result) {
        model.addAttribute("unities", weightService.getUnities());
        model.addAttribute("result", result);
        return "weight/index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("value") double value, @RequestParam("from") String from, @RequestParam("to") String to, RedirectAttributes redirect) {
        String result = weightService.convertTo(value, from, to);
        redirect.addAttribute("result", result);
        return "redirect:/weight";
    }
    
}
