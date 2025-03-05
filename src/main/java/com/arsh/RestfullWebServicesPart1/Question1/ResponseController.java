package com.arsh.RestfullWebServicesPart1.Question1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    @PostMapping("/response")
    public String response(){
        return "Welcome to Spring boot";
    }
}
