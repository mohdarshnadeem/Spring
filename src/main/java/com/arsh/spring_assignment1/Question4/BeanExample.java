package com.arsh.spring_assignment1.Question4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanExample.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BeanExample.class);
        MyBean myBean = applicationContext.getBean(MyBean.class);
        myBean.setId(23);
        myBean.setName("Arsh");
        LOGGER.info("Bean Name: {}",myBean.getName());
        LOGGER.info("Bean id: {}",myBean.getId());

    }
}
