package com.example.tgid.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@RequestMapping("/hello")
@OpenAPIDefinition(info = @Info(
        title = "TGID - Teste Java Developer",
        description = "",
        version = "1.0.0"))

public class HelloController {
    @GetMapping
    public String olaMundo(){
        return "Hello world spring!";
    }
}