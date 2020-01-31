package com.study.cartService.entity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ResponseObject {

    RestTemplate restTemplate = new RestTemplate();

    public <T> T receive(Class<T> type, String resourceUrl) {
        ResponseEntity<T> response = restTemplate.getForEntity(resourceUrl, type);
        return response.getBody();
    }
}