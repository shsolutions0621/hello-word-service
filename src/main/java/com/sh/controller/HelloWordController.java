package com.sh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class HelloWordController {
    @GetMapping("/hello/{name}")
    public String getHelloWord(@PathVariable String name){
        return "Hello, "+ name;
    }

}
