package com.dkl.annotation;

import com.dkl.config.DklServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: dalele
 * @date: 2020/3/17 22:42
 * @description: 开启微服务防护，避免客户端绕过网关直接请求微服务
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DklServerProtectConfigure.class)
public @interface EnableDklServerProtect {
}
