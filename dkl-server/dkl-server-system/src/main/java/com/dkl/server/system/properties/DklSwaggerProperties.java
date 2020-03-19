package com.dkl.server.system.properties;

import lombok.Data;

/**
 * @author: dalele
 * @date: 2020/3/19 18:54
 * @description:
 */
@Data
public class DklSwaggerProperties {

	private String basePackage;
	private String title;
	private String description;
	private String version;
	private String author;
	private String url;
	private String email;
	private String license;
	private String licenseUrl;

	private String grantUrl;
	private String name;
	private String scope;
}
