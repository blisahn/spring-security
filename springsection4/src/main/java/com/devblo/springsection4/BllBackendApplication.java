package com.devblo.springsection4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan("com.devblo.springsection4")
//@EnableJpaRepositories("com.devblo.springsection4.repository")
public class BllBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BllBackendApplication.class, args);
    }

}
