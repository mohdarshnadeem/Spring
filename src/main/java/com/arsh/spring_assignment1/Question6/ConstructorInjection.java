package com.arsh.spring_assignment1.Question6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConstructorInjection {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ConstructorInjection.class);
        BinarySearch binarySearch = applicationContext.getBean(BinarySearch.class);
        System.out.println(binarySearch.binarySearch(new int[]{1,3,2,45,6,5}));
    }
}
