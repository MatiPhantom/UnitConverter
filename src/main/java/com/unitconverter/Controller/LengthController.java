package com.unitconverter.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/length")
public class LengthController {
    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String postMethodName(@RequestBody String entity) {
                
        return entity;
    }
    
    
}
