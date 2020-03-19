package com.dkl.server.system.config;

import com.dkl.server.system.properties.DklServerSystemProperties;
import com.dkl.server.system.properties.DklSwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;
import java.util.Collections;


/**
 * @author: dalele
 * @date: 2020/3/19 02:28
 * @description: mybatis分页
 */
@Configuration
@EnableSwagger2
public class DklWebConfigure {

	@Autowired
	private DklServerSystemProperties properties;

	@Bean
	public Docket swaggerApi() {
		DklSwaggerProperties swagger = properties.getSwagger();
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(swagger.getBasePackage()))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo(swagger))
				.securitySchemes(Collections.singletonList(securityScheme(swagger)))
				.securityContexts(Collections.singletonList(securityContext(swagger)));
	}

	private ApiInfo apiInfo(DklSwaggerProperties swagger) {
		return new ApiInfo(
				swagger.getTitle(),
				swagger.getDescription(),
				swagger.getVersion(),
				null,
				new Contact(swagger.getAuthor(), swagger.getUrl(), swagger.getEmail()),
				swagger.getLicense(), swagger.getLicenseUrl(), Collections.emptyList());
	}

	private SecurityScheme securityScheme(DklSwaggerProperties swagger) {
		GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(swagger.getGrantUrl());

		return new OAuthBuilder()
				.name(swagger.getName())
				.grantTypes(Collections.singletonList(grantType))
				.scopes(Arrays.asList(scopes(swagger)))
				.build();
	}

	private SecurityContext securityContext(DklSwaggerProperties swagger) {
		return SecurityContext.builder()
				.securityReferences(Collections.singletonList(new SecurityReference(swagger.getName(), scopes(swagger))))
				.forPaths(PathSelectors.any())
				.build();
	}

	private AuthorizationScope[] scopes(DklSwaggerProperties swagger) {
		return new AuthorizationScope[]{
				new AuthorizationScope(swagger.getScope(), "")
		};
	}

}
