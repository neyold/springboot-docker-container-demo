package com.serverless.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Value("${external.param}")
    private String externalParam;

    @Value("${project.version}")
    private String appVer;

    @GetMapping(value = "/welcome", produces = "application/json")
    private ResponseEntity<Object> welcome() {
        Map<String, String> respMap = new HashMap<>();
        respMap.put("app", "Fargate Demo App");
        respMap.put("version", appVer);
        respMap.put("message", "Welcome to the Cloud!");
        respMap.put("externalParam", externalParam);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }
}
