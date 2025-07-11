package com.unitconverter.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.unitconverter.ApiClient.ConvertApiClient;

@Service
public class LengthService {

    private ConvertApiClient client=new ConvertApiClient();

    private final Map<String,String> unities=Map.of(
        "mm", "Milímetros",
        "cm", "Centímetros",
        "m", "Metros",
        "km", "Kilómetros",
        "in", "Pulgadas",
        "ft", "Pies",
        "yd", "Yardas",
        "mi", "Millas"
    );

    public List<String> getUnities(){
        return client.getUnities("length");
    }

    public String convertTo(double value, String from, String to){
        return client.convertTo("length", value, from, to);
    }

}
