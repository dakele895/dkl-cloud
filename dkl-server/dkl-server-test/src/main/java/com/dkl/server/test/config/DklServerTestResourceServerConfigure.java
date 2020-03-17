package com.dkl.server.test.config;

import com.dkl.handler.DklAccessDeniedHandler;
import com.dkl.handler.DklAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author: dalele
 * @date: 2020/3/17 16:07
 * @description: 测试服务配置类
 */
@Configuration
@EnableResourceServer
public class DklServerTestResourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Autowired
    private DklAccessDeniedHandler     accessDeniedHandler;
    @Autowired
    private DklAuthExceptionEntryPoint exceptionEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
