package com.dkl.auth.service;

import com.dkl.auth.properties.DklValidateCodeProperties;
import com.dkl.exception.ValidateCodeException;
import com.wf.captcha.base.Captcha;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dalele
 * @date: 2020/3/19 01:57
 * @description:
 */
public interface ValidateCodeService {

	/**
	 * 生成验证码
	 *
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 */
	 void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException;


	/**
	 * 校验验证码
	 *
	 * @param key   前端上送 key
	 * @param value 前端上送待校验值
	 */
	 void check(String key, String value) throws ValidateCodeException ;




}
