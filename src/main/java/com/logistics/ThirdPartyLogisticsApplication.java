package com.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ThirdPartyLogisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyLogisticsApplication.class, args);
    }

}
