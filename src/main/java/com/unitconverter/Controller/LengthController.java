package com.unitconverter.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/length")
@Slf4j
public class LengthController {
    @GetMapping
    public String index() {
        log.info("RETORNANDO VISTA");
        System.out.println("RETORNANDO VISTA");
        return "index";
    }

    @PostMapping("/convert")
    public String convertToLength(@RequestParam("unit") double unit, @RequestParam("from") String from, @RequestParam("to") String to){
        System.out.println("RETORNANDO VISTA");
        log.info("---------------------------Numero a convertir es: "+unit+" de "+from+" a "+to);
        return "index";
    }
    
}
