package com.dkl.annotation;

import com.dkl.validator.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: dalele
 * @date: 2020/3/19 18:07
 * @description: 手机参数校验注解
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MobileValidator.class)
public @interface IsMobile {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
