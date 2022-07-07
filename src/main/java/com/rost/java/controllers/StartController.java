package com.rost.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping()
    public String helloPage() {
        return "start/hello_page";
    }
}