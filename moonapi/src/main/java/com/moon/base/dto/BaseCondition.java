package com.moon.base.dto;

/**
 * 查询条件类 基类 所有查询类都应该继承该类
 * @author lenovo
 *
 */
public class BaseCondition {

	/**
	 * 是否包含转移符
	 * 如果查询条件中 包含like，这需要将此值设为true，否则false
	 */
	private boolean escapeSymbol = false;
	
	/** 排序列 */
	private String orderBy;
	/** 排序类型 */
	private String sort;

	public boolean isEscapeSymbol() {
		return escapeSymbol;
	}

	public void setEscapeSymbol(boolean escapeSymbol) {
		this.escapeSymbol = escapeSymbol;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
}
