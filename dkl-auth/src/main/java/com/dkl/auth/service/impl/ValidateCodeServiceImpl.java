package com.dkl.auth.service.impl;

import com.dkl.auth.properties.DklAuthProperties;
import com.dkl.auth.properties.DklValidateCodeProperties;
import com.dkl.auth.service.ValidateCodeService;
import com.dkl.constant.DklConstant;
import com.dkl.exception.ValidateCodeException;
import com.dkl.service.RedisService;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dalele
 * @date: 2020/3/19 01:59
 * @description:
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

	@Autowired
	private RedisService redisService;
	@Autowired
	private DklAuthProperties properties;

	/**
	 * 生成验证码
	 *
	 * @param request  HttpServletRequest
	 * @param response HttpServletResponse
	 */
	@Override
	public void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
		String key = request.getParameter("key");
		if (StringUtils.isBlank(key)) {
			throw new ValidateCodeException("验证码key不能为空");
		}
		DklValidateCodeProperties code = properties.getCode();
		setHeader(response, code.getType());

		Captcha captcha = createCaptcha(code);
		redisService.set(DklConstant.CODE_PREFIX + key, StringUtils.lowerCase(captcha.text()), code.getTime());
		captcha.out(response.getOutputStream());
	}

	/**
	 * 校验验证码
	 *
	 * @param key   前端上送 key
	 * @param value 前端上送待校验值
	 */
	@Override
	public void check(String key, String value) throws ValidateCodeException {
		Object codeInRedis = redisService.get(DklConstant.CODE_PREFIX + key);
		if (StringUtils.isBlank(value)) {
			throw new ValidateCodeException("请输入验证码");
		}
		if (codeInRedis == null) {
			throw new ValidateCodeException("验证码已过期");
		}
		if (!StringUtils.equalsIgnoreCase(value, String.valueOf(codeInRedis))) {
			throw new ValidateCodeException("验证码不正确");
		}
	}

	private Captcha createCaptcha(DklValidateCodeProperties code) {
		Captcha captcha = null;
		if (StringUtils.equalsIgnoreCase(code.getType(), DklConstant.GIF)) {
			captcha = new GifCaptcha(code.getWidth(), code.getHeight(), code.getLength());
		} else {
			captcha = new SpecCaptcha(code.getWidth(), code.getHeight(), code.getLength());
		}
		captcha.setCharType(code.getCharType());
		return captcha;
	}

	private void setHeader(HttpServletResponse response, String type) {
		if (StringUtils.equalsIgnoreCase(type, DklConstant.GIF)) {
			response.setContentType(MediaType.IMAGE_GIF_VALUE);
		} else {
			response.setContentType(MediaType.IMAGE_PNG_VALUE);
		}
		response.setHeader(HttpHeaders.PRAGMA, "No-cache");
		response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
		response.setDateHeader(HttpHeaders.EXPIRES, 0L);
	}
}
