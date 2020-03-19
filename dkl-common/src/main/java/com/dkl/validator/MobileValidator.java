package com.dkl.validator;

import com.dkl.annotation.IsMobile;
import com.dkl.constant.RegexpConstant;
import com.dkl.util.DklUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: dalele
 * @date: 2020/3/19 18:08
 * @description:手机参数校验
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

	@Override
	public void initialize(IsMobile isMobile) {
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		try {
			if (StringUtils.isBlank(s)) {
				return true;
			} else {
				String regex = RegexpConstant.MOBILE_REG;
				return DklUtil.match(regex, s);
			}
		} catch (Exception e) {
			return false;
		}
	}
}

