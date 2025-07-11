package com.unitconverter.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitconverter.ApiClient.ConvertApiClient;

import jakarta.annotation.PostConstruct;

@Service
public class WeightService {

    @Autowired
    private ConvertApiClient client;

    private Map<String, String> unities= new HashMap<>();

    private Set<String> keys;

    private final List<String> values = List.of("Nanómetro",
    "Micrómetro",
    "Milímetro",
    "Centímetro",
    "Metro",
    "Kilómetro",
    "Pulgada",
    "Yarda",
    "Pie (EE.UU.)",
    "Pie",
    "Braza",
    "Milla",
    "Milla náutica");

    @PostConstruct
    private void initComponenets(){
        this.keys = new HashSet<>(client.getUnities("length"));
        for (int i = 0; i < keys.size(); i++) {
            this.unities.put(this.keys.toArray()[i].toString(), this.values.get(i));
        }
    }
    
    public Map<String, String> getUnities(){
        
        return unities;
    }

    public String convertTo(double value, String from, String to){
        return client.convertTo("length", value, from, to);
    }


}
