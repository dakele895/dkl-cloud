package com.dkl.config;

import com.dkl.handler.DklAccessDeniedHandler;
import com.dkl.handler.DklAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author: dalele
 * @date: 2020/3/17 17:01
 * @description:认证异常相关配置类
 */
public class DklAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public DklAccessDeniedHandler accessDeniedHandler() {
        return new DklAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public DklAuthExceptionEntryPoint authenticationEntryPoint() {
        return new DklAuthExceptionEntryPoint();
    }
}
