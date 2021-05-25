package com.wellsfargo.api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class StaticController {

    @Value("classpath:category.json")
    private Resource category;

    @Value("classpath:trans-type.json")
    private Resource transactions;

    @GetMapping("/static/category")
    public List<String> getCategory() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream input = category.getInputStream();
        return mapper.readValue(input, new TypeReference<List<String>>() {});
    }

    @GetMapping("/static/transactions")
    public List<String> getTransactionTypes() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream input = transactions.getInputStream();
        return mapper.readValue(input, new TypeReference<List<String>>() {});
    }
}
