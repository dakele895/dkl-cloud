package com.dkl.server.system.config;

import com.dkl.handler.DklAccessDeniedHandler;
import com.dkl.handler.DklAuthExceptionEntryPoint;
import com.dkl.server.system.properties.DklServerSystemProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Auther: dalele
 * @Date: 2020/3/17 15:58
 * @Description:
 */
@Configuration
@EnableResourceServer
public class DklServerSystemResourceServerConfigure extends ResourceServerConfigurerAdapter {

	@Autowired
	private DklServerSystemProperties properties;

    @Autowired
    private DklAccessDeniedHandler     accessDeniedHandler;
    @Autowired
    private DklAuthExceptionEntryPoint exceptionEntryPoint;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		String[] anonUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnonUrl(), ",");

		http.csrf().disable()
				.requestMatchers().antMatchers("/**")
				.and()
				.authorizeRequests()
				.antMatchers(anonUrls).permitAll()
				.antMatchers("/**").authenticated();
	}


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}
