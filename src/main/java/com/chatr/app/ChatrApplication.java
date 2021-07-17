package com.chatr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.chatr", exclude = SecurityAutoConfiguration.class)
public class ChatrApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatrApplication.class, args);
    }

}
