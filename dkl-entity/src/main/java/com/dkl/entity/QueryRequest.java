package com.dkl.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author: dalele
 * @date: 2020/3/19 02:44
 * @description:
 */
@Data
@ToString
public class QueryRequest {


	private static final long serialVersionUID = -4869594085374385813L;
	/**
	 * 当前页面数据量
	 */
	private int pageSize = 10;
	/**
	 * 当前页码
	 */
	private int pageNum = 1;
	/**
	 * 排序字段
	 */
	private String field;
	/**
	 * 排序规则，asc升序，desc降序
	 */
	private String order;
}
