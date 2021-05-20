package com.controllers;

import com.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RepoController {
    @Autowired
    AnalysisService analysisService;

    @GetMapping(value="/report", produces = { MediaType.APPLICATION_PDF_VALUE})
    public ResponseEntity<byte[]> Table()
    {
        RestTemplate restTemplate = new RestTemplate();
        analysisService.Create();
        ResponseEntity<byte[]> quote = restTemplate.getForEntity(
                "http://localhost:9090/report?format=table", byte[].class);
        return quote;
    }
}
