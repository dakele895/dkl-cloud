package com.dkl.server.test;

import com.dkl.annotation.DklCloudApplication;
import com.dkl.annotation.EnableDklAuthExceptionHandler;
import com.dkl.annotation.EnableDklOauth2FeignClient;
import com.dkl.annotation.EnableDklServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 16:05
 * @Description:
 */
@DklCloudApplication
@EnableFeignClients
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DklServerTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DklServerTestApplication.class, args);
    }
}
