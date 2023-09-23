package com.sii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationStarter {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationStarter.class, args);
    }
}

