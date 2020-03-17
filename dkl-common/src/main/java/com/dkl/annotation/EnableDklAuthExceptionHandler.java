package com.dkl.annotation;

import com.dkl.config.DklAuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: dalele
 * @date: 2020/3/17 17:04
 * @description:驱动该配置类注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DklAuthExceptionConfigure.class)
public @interface EnableDklAuthExceptionHandler {
}
