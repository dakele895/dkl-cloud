package com.dkl.server.system;

import com.dkl.annotation.DklCloudApplication;
import com.dkl.annotation.EnableDklAuthExceptionHandler;
import com.dkl.annotation.EnableDklOauth2FeignClient;
import com.dkl.annotation.EnableDklServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 15:57
 * @Description:
 */

@DklCloudApplication
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DklServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DklServerSystemApplication.class, args);
    }
}
