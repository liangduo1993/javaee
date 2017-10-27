package com.ecvlearning.javaee;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class Boot {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Boot.class, args);
        Logger logger = LoggerFactory.getLogger(Boot.class);
        logger.info("ECVLearning - A Spring Boot project started !");
    }
}

