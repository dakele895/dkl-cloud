package com.dkl.server.system;

import com.dkl.annotation.DklCloudApplication;
import com.dkl.annotation.EnableDklAuthExceptionHandler;
import com.dkl.annotation.EnableDklOauth2FeignClient;
import com.dkl.annotation.EnableDklServerProtect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 15:57
 * @Description:
 */
@EnableTransactionManagement
@DklCloudApplication
@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@MapperScan("com.dkl.mapper")
//@ComponentScan(basePackages = {"com.dkl.dao","com.dkl.service"})
public class DklServerSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DklServerSystemApplication.class, args);
    }
}
