package com.ecvlearning.javaee;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class Boot {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Boot.class, args);
        Logger logger = LoggerFactory.getLogger(Boot.class);
        logger.info("Review - A Spring Boot project started !");
    }

    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".html");
        return bean;
    }
}

