package com.arsh.restfullWebServices.restfullWebServices2.Question1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
@RestController
public class InternationalizationExample {
    @Autowired
    MessageSource messageSource;
    @GetMapping("/hi-internationalized1")
    public String messageInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default message",locale);
    }
}
