package com.dkl.constant;

/**
 * @author: dalele
 * @date: 2020/3/17 22:35
 * @description:
 */
public class DklConstant {

    /**
     * Zuul请求头TOKEN名称（不要有空格）
     */
    public static final String ZUUL_TOKEN_HEADER = "ZuulToken";
    /**
     * Zuul请求头TOKEN值
     */
    public static final String ZUUL_TOKEN_VALUE = "dkl:zuul:123456";

	/**
	 * gif类型
	 */
	public static final String GIF = "gif";
	/**
	 * png类型
	 */
	public static final String PNG = "png";

	/**
	 * 验证码 key前缀
	 */
	public static final String CODE_PREFIX = "febs.captcha.";

	// 用户状态：有效
	public static final String STATUS_VALID = "1";
	// 用户状态：锁定
	public static final String STATUS_LOCK = "0";
	// 默认头像
	public static final String DEFAULT_AVATAR = "default.jpg";
	// 默认密码
	public static final String DEFAULT_PASSWORD = "1234qwer";
	// 性别男
	public static final String SEX_MALE = "0";
	// 性别女
	public static final String SEX_FEMALE = "1";
	// 性别保密
	public static final String SEX_UNKNOW = "2";

}
