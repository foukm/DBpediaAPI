package com.example.demo.service;

import org.springframework.ui.Model;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@Service
public class DBpediaSpotlightService {

    private final RestTemplate restTemplate;
    public DBpediaSpotlightService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public String annotateText(String textToAnnotate) {
        String apiUrl;
        apiUrl = "https://api.dbpedia-spotlight.org/en/annotate";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "text/html");

        String params = "?text=" + textToAnnotate;
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl + params,
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}
