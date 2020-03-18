package com.dkl.annotation;

import com.dkl.config.DklLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: dalele
 * @date: 2020/3/19 01:49
 * @description: 缓存注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DklLettuceRedisConfigure.class)
public @interface EnableDklLettuceRedis {
}
