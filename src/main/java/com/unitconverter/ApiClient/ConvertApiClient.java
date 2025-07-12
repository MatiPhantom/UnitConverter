package com.unitconverter.ApiClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ConvertApiClient {
    private final String apiKey ="4dc2b79d34msh82ca35a4f7793e3p1a6300jsn61100b1a5896";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper= new ObjectMapper();
    
    public List<String> getUnities(String measure){
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://measurement-unit-converter.p.rapidapi.com/"+measure+"/units"))
		.header("x-rapidapi-key", apiKey)
		.header("x-rapidapi-host", "measurement-unit-converter.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        List<String> unities= new ArrayList<>();
        try{
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode()!=200){
            log.error("Error de cliente " + response.statusCode());
        }
        unities= mapper.readValue(response.body(), new TypeReference<List<String>>(){});
        log.info("Unidades pedidas: "+unities);
        }catch(Exception e){
            log.error("Error al obtener las unidades de longitud");
        }
        return unities;
    }

    public String convertTo(String measure,double value, String from, String to){
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://measurement-unit-converter.p.rapidapi.com/"+measure+"?value="+value+"&from="+from+"&to="+to))
		.header("x-rapidapi-key", apiKey)
		.header("x-rapidapi-host", "measurement-unit-converter.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode node=mapper.readTree(response.body());
            String result=node.get("result").asText();
            log.info("Resultado: "+result);
            return result;  
        }catch(Exception e){
            log.error("Error al obtener las unidades de longitud");
        }
        return "null";
    }



    
    
}
