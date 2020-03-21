package com.dkl.router;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: dalele
 * @date: 2020/3/21 21:12
 * @description:
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouterMeta implements Serializable {

	private static final long serialVersionUID = 5499925008927195914L;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 图标
	 */
	private String icon;
}
