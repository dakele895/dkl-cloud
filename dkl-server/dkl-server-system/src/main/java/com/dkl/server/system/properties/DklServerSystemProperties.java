package com.dkl.server.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: dalele
 * @date: 2020/3/19 18:57
 * @description:
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:dkl-server-system.properties"})
@ConfigurationProperties(prefix = "dkl.server.system")
public class DklServerSystemProperties {

	/**
	 * 免认证 URI，多个值的话以逗号分隔
	 */
	private String anonUrl;
	/**
	 * swagger配置
	 */
	private DklSwaggerProperties swagger = new DklSwaggerProperties();
}
