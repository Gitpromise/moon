package com.moon.auth.service;


import com.moon.auth.entity.Depart;

public interface IDepartService {


	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 部门表
	 */
	Depart getDepartById(String id);

	/**
	 * 根据上级ID查询部门列表
	 * @param
	 * @param value 上级ID
	 *//*
	List<Depart> listDepartByPid(String value);

	*//**
	 * 新增
	 * @param item 部门表
	 *//*
	void add(Depart item);

	*//**
	 * 修改
	 * @param item 部门表
	 *//*
	void update(Depart item);

	*//**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 *//*
	void delByIds(String[] ids);

	*//**
	 * 添加部门
	 * @param parentId
	 * @param name
	 * @param sort
	 *//*
	void doAddDepart(String parentId, String name, Integer sort, String note, int isParent);

	*//**
	 * 添加类别属性
	 *//*
	void doAddDepartNew(String parentId, String name, int sort, String codeNum, int level, String note);

	*//**
	 * 根据给定的code值生成下一个code，规则是
	 *
	 * <pre>
	 * 0001 生成 0002
	 * 0000-2222 生成 0000-2223
	 * 0001-9999-9998 生成 0001-9999-9999
	 * 第一段取值：0-999
	 * 其他段取值：0-9999
	 * </pre>
	 *
	 * @param code
	 * @return
	 *//*
	String createCodeNum(String code);

	*//**
	 * 新增生成编号
	 *
	 * @return
	 *//*
	String createCodeNumByAdd(String parentId) ;

	*//**
	 * 修改 部门
	 * @param
	 *//*
	void doUpdateDepart(String nodeId, String name, Integer sort, String note);*/

}

