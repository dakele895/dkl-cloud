package com.dkl.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: dalele
 * @date: 2020/3/17 16:33
 * @description:
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:dkl-auth.properties"})
@ConfigurationProperties(prefix = "dkl.auth")
public class DklAuthProperties {
    private DklClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;


	/**
	 * 免认证路径
	 */
	private String anonUrl;

	/**
	 * 验证码配置类
	 */
	private DklValidateCodeProperties code = new DklValidateCodeProperties();
}
