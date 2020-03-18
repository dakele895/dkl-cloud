package com.dkl.auth;

import com.dkl.annotation.DklCloudApplication;
import com.dkl.annotation.EnableDklAuthExceptionHandler;
import com.dkl.annotation.EnableDklServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : dalele
 * @Date: 2020/3/17 01:46
 * @Description:
 */
@DklCloudApplication
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.dkl.mapper")
public class DklAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(DklAuthApplication.class, args);
    }
}
