package com.dkl.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 01:30
 * @Description:
 */
@EnableEurekaServer
@SpringBootApplication
public class DklRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DklRegisterApplication.class, args);
    }
}
