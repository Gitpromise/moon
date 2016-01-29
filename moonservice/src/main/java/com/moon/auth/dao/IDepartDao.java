package com.moon.auth.dao;


import com.moon.auth.entity.Depart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository(value = "departDao")
public interface IDepartDao {

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 部门表
	 */
	Depart getDepartById(@Param("id") String id);


	/**
	 * 根据上级ID查询部门列表
	 * @param
	 * @param
	 *//*
	List<Depart> listDepartByPid(@Param("value") String value);

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
	 * 添加类别
	 *
	 * @param map
	 *//*
	void doAddDepartNew(Map<String, Object> map);

	*//**
	 * 获取一级部门最大codeNum
	 *
	 * @param
	 * @return
	 *//*
	String getMaxCodeNum(String parentId);
	*//**
	 * 获取上级部门的codeNum
	 * @param parentId
	 * @return
	 *//*
	String getCodeNum(String parentId);

	*//**
	 * 根据部门ID更新部门是否为父节点
	 * @param id		部门ID
	 * @param isParent	0-非父节点 1-是父节点
	 * @param isDelete	0-不可删除 1-可删除
	 *//*
	void updateIsParentDeleteById(@Param("id") String id, @Param("isParent") Integer isParent, @Param("isDelete") Integer isDelete);

	*//**
	 * 修改 部门
	 * @param map
	 *//*
	void doUpdateDepart(Map<String, Object> map);

	*//**
	 * 根据id删除部门
	 * @param nodeId
	 *//*
	int delDepartById(String nodeId);

	*//**
	 * 批量设置用户主管设置
	 * @param
	 *//*
	public void doManagerContr(@Param("manageId") String manageId, @Param("sel") String sel);

	*//**
	 * 批量取消用户主管设置
	 * @param
	 *//*
	public void doManagerNoContr(@Param("manageId") String manageId, @Param("sel") String sel);*/

}

