package com.dkl.annotation;

import com.dkl.selector.DklCloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: dalele
 * @date: 2020/3/17 23:45
 * @description: 功能整合注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DklCloudApplicationSelector.class)
public @interface DklCloudApplication {
}
