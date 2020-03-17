package com.dkl.auth.properties;

import lombok.Data;

/**
 * @author: dalele
 * @date: 2020/3/17 16:31
 * @description:认证参数配置
 */
@Data
public class DklClientsProperties {
    /**
     * client_id
     */
    private String client;
    /**
     * client_secret
     */
    private String secret;
    /**
     * 令牌支持的认证类型
     */
    private String grantType = "password,authorization_code,refresh_token";
    /**
     * 认证范围
     */
    private String scope = "all";
}
