package com.dkl.annotation;

import com.dkl.config.DklOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: dalele
 * @date: 2020/3/17 17:53
 * @description:自定义feign获取令牌注解类
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DklOAuth2FeignConfigure.class)
public  @interface EnableDklOauth2FeignClient {
}
