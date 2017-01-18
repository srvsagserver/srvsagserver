package com.srvcforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.srvcforme.controllers"})
public class MainController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }
}
