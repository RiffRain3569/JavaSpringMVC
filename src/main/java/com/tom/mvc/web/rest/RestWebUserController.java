package com.tom.mvc.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class RestWebUserController {

    @GetMapping
    public String healthCheck() {
        System.out.println("healthCheck");
        return "ok";
    }
}
