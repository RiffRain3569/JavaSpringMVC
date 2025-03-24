package com.tom.mvc.web.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientWebUserController {
    @GetMapping
    public String healthCheck() {
        return "ok";
    }
}
