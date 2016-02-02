package com.moon.institution.service;

import com.moon.base.page.PageResult;
import com.moon.institution.dto.InstitutionCondition;
import com.moon.institution.entity.Institution;

import java.util.Date;
import java.util.List;

public interface IInstitutionService {



	/**
	 * 根据服务名称查询数据
	 * @param condition 条件
	 */
	void listInstitutionByPageService(PageResult<Institution> pageResult, InstitutionCondition condition);

	/**
	 * 按照预约人数降序排序
	 * @param condition
	 * @return
	 */
	void listInstitutionByPageYuYue(PageResult<Institution> pageResult, InstitutionCondition condition);
	/**
	 * 按照评价降序排序
	 * @param condition
	 * @return
	 */
	void listInstitutionByPageAssess(PageResult<Institution> pageResult, InstitutionCondition condition);


	/**
	 * 只查询推荐的
	 * @param condition
	 * @return
	 */
	void listInstitutionByPageRecommend(PageResult<Institution> pageResult, InstitutionCondition condition);
	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listInstitutionByPage(PageResult<Institution> pageResult, InstitutionCondition condition);

	/**
	 * 后天分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listInstitutionByPageByadmin(PageResult<Institution> pageResult, InstitutionCondition condition);


	/**
	 * 分页查询
	 * @param pageResult 分页对象
	 * @param condition 查询条件类
	 */
	void listInstitutionByshouye(PageResult<Institution> pageResult, InstitutionCondition condition);


	/**
	 * 根据Key模糊查询机构
	 * @param key
	 * @return
	 */
	List<Institution> listInstitutionByKey(String key);

	/**
	 * 获取所有生效启用的机构
	 * @param 
	 * @return
	 */
	List<Institution> listInstitutionAllByUsingStatusAndStatus();
	
	/**
	 * 根据条件查询机构
	 * @return
	 */
	List<Institution> listInstitutionByCondition(InstitutionCondition condition);
	
	/**
	 * 获取所有生效启用的推荐机构按照推荐度和创建时间排逆序
	 * @param 
	 * @return
	 */
	List<Institution> listInstitutionAllByUsingStatusAndStatusAndIsRecommend();
	
	/**
	 * 根据医生ID查询机构
	 * @param expertId
	 * @return
	 */
	List<Institution> listInstitutionByExpertId(String expertId);
	
	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 机构信息
	 */
	Institution getInstitutionById(String id);
	
	/**
	 * 查询机构评价
	 * @param item 主键
	 * @return 机构信息
	 */
	Institution getInstitutionByItem(Institution item);
	
	/**
	 * 根据account和password查询
	 * @param account password
	 * @return 机构信息
	 */
	Institution getInstitutionByAccountAndPwd(String account, String password);
	
	/**
	 * 根据account和ID查询
	 * @param account
	 * @return 机构信息
	 */
	boolean getInstitutionByAccountExists(String account, String id);

	/**
	 * 新增
	 * @param item 机构信息
	 */
	void add(Institution item);

	//void addBoth(Institution item, InstitutionCheck institutionCheck);
	/**
	 * 修改
	 * @param item 机构信息
	 */
	void update(Institution item);
	
	//void updateBoth(Institution item, InstitutionCheck institutionCheck);
	
	/**
	 * 修改机构的登录账号
	 * @param
	 */
	void updateAccount(String institutionId, String newAccount);
	
	

	
	
	
	
	
	void updateUsingStatus(String[] ids, Integer usingStatus);
	/**
	 * 根据ID集合批量推荐
	 * @param ids ID集合
	 */
	void updateIsRecommendByIds(Integer isRecommend, String[] ids);
	
	
	/**
	 * 根据ID集合批量修改状态
	 * @param ids ID集合
	 */
	void updateStatusByIds(Integer status, String[] ids);
	
	void updateAuthentcationStatusReasonById(Integer authentcationStatus, String reason, String[] ids);
	
	/**
	 * 根据ID修改合约地址
	 * @param id ID
	 */
	void updateHyUrlById(String hyUrl, Integer status, String id);
	
	/**
	 * 机构重置密码
	 * @return
	 */
	void resetPwd(Institution item);
	
	/**
	 * 设置推荐度
	 * @return
	 */
	void updateRecommend(Institution item);
	/**
	 * 修改名称
	 * @return
	 */
	void updateName(Institution item);
	
	boolean alreadyExists(String account);
	
	/**
	 * 根据account查询
	 * @param account
	 * @return 机构信息
	 */
	Institution getInstitutionByAccount(String account);
	
	Institution getInstitutionByInstitutionNo(String institutionNo);
	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(String[] ids);

	
	/**
	 * 根据ID集合批量修改为deleteFlag
	 * @param ids ID集合
	 */
	void updateFlagbyIds(String[] ids, Integer deleteFlag);
	
	/**
	 * 更新认证度
	 * @param institution
	 */
	void updateAuthentcationRate(Institution institution);
	
	void updateTrialById(String[] ids, Integer trial);

	//xgs 2015年8月11日11:11:28 设置推荐度状态
	void  updateFinerStatus(Institution item);
	//xgs end

	void updateocStatusById(String[] ids, Integer ocStatus);
	/**
	 * 分页快速预约查询机构
	 * @param
	 * @param
	 * @return
	 */
	void listFastCheckbByPage(PageResult<Institution> pageResult, InstitutionCondition condition);
	
	
	/**
	 * 快速预约查询机构
	 * @param cityId
	 * @param appointDate
	 * @return
	 */
	List<Institution> listFastCheck(Integer cityId, Date appointDate);

	/**
	 * 查询机构所关联的城市数据
	 * @return
	 */
	//List<InstitutionCityVO> listInstitutionCities();
	/**
	 * 机构信息导出
	 * @author hys
	 * @param condition
	 * @return
	 */
	String doExport(InstitutionCondition condition);
	
	//List<InstitutionImportData> batchImport(String filePath, String currentOperatorUserAccount);
	
	void updateAuthentcationStatusById(Integer authentcationStatus, String id);
	
	
	
	void updateBlStatusById(Integer blStatus, String id);
	
	
	void updateMiblStatusById(Integer miblStatus, String id);
	/**
	 * 手机端分页
	 * @param pageResult
	 * @param condition
	 */
	void listMobileByPage(PageResult<Institution> pageResult, InstitutionCondition condition);
	
	/**
	 * 根据条件查询
	 * @param condition
	 * @return
	 */
	List<Institution> listByCondition(PageResult<Institution> pageResult, InstitutionCondition condition)throws Exception;
	
	/**
	 * 按照距离分页查询
	 * @param pageResult
	 * @param condition
	 * @return
	 */
	void listDistanceByPage(PageResult<Institution> pageResult, InstitutionCondition condition);
	
	/**
	 * 计算认证度
	 * @param id
	 */
	Institution calcCertification(String id);

	void listInstBypage(PageResult<Institution> pageResult, List<String> item, String name);

	List<Institution> listInstNotNo(List<String> item);

	void listMobileByDistance(PageResult<Institution> pageResult, InstitutionCondition condition);
}



