package com.dkl.gateway;

import com.dkl.annotation.EnableDklServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 15:39
 * @Description: 服务网关
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class DklGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DklGatewayApplication.class, args);
    }
}
