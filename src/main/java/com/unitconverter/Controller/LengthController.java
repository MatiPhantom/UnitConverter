package com.unitconverter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitconverter.ApiClient.ConvertApiClient;
import com.unitconverter.Service.LengthService;

import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/length")
@Slf4j
public class LengthController {

    @Autowired
    private LengthService lengthService;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("unities", lengthService.getUnities());
        return "length/index";
    }

    @PostMapping("/convert")
    public String convertToLength(@RequestParam("value") double value, @RequestParam("from") String from, @RequestParam("to") String to,RedirectAttributes redirect ){
        String result=lengthService.convertTo(value, from, to);
        redirect.addFlashAttribute("result",result);
        return "redirect:/length";
    }
    
}
