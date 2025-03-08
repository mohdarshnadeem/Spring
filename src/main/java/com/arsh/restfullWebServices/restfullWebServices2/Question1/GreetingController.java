package com.arsh.restfullWebServices.restfullWebServices2.Question1;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
@RestController
public class GreetingController {

    MessageSource messageSource;

    public GreetingController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @GetMapping("/greet")
    public String greeetUser(@RequestParam String username, @RequestHeader(name="Accept-Language",required = false)Locale locale){
        String message = messageSource.getMessage("greeting.message",new Object[]{username},locale);
        return message;
    }
}
