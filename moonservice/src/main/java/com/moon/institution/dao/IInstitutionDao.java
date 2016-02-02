package com.moon.institution.dao;

import com.moon.institution.dto.InstitutionCondition;
import com.moon.institution.entity.Institution;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository("institutionDao")
public interface IInstitutionDao {

	/**
	 * 查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	//List<Institution> listInstitutionByPage(RowBounds bounds, @Param("condition") InstitutionCondition condition);

	/**
	 * 后台查询区间数据
	 * @param bounds RowBounds对象
	 * @param condition 查询条件类
	 */
	//List<Institution> listInstitutionByPageByadmin(RowBounds bounds, @Param("condition") InstitutionCondition condition);


	/**
	 * 后台查询区间数据条数
	 *
	 * @param condition 查询条件类
	 */
	int listInstitutionByPageByadminCount(@Param("condition") InstitutionCondition condition);

	/**
	 * 查询区间数据
	 * @param condition 查询条件类
	 */
	List<Institution> listInstitutionByshouye(@Param("condition") InstitutionCondition condition);

	/**
	 * 根据服务名称查询数据
	 */
	//List<Institution> listInstitutionByPageService(RowBounds bounds, @Param("condition") InstitutionCondition condition);


	/**
	 * 根据服务名称查询数据条数
	 * @param serviceName 服务名称
	 */
	int listInstitutionByPageServicecount(@Param("condition") InstitutionCondition condition);



	/**
	 * 按照预约人数降序排序
	 * @param condition
	 * @return
	 */
	//List<Institution> listInstitutionByPageYuYue(RowBounds bounds, @Param("condition") InstitutionCondition condition);
	/**
	 * 按照评价降序排序
	 * @param condition
	 * @return
	 */
	//List<Institution> listInstitutionByPageAssess(RowBounds bounds, @Param("condition") InstitutionCondition condition);
	/**
	 * 只查询推荐的
	 * @param condition
	 * @return
	 */
	//List<Institution> listInstitutionByPageRecommend(RowBounds bounds, @Param("condition") InstitutionCondition condition);

	/**
	 * 查询总数
	 * @param condition 查询条件类
	 * @return 总条数
	 */
	int listInstitutionByPageCount(@Param("condition") InstitutionCondition condition);

	/**
	 * 根据Key模糊查询机构
	 * @param key
	 * @return
	 */
	List<Institution> listInstitutionByKey(@Param("key") String key);

	/**
	 * 根据条件查询机构
	 * @return
	 */
	List<Institution> listInstitutionByCondition(@Param("condition") InstitutionCondition condition);





	/**
	 * 获取所有生效启用的机构
	 * @param
	 * @return
	 */
	List<Institution> listInstitutionAllByUsingStatusAndStatus();



	/**
	 * 获取所有生效启用的推荐机构按照推荐度和创建时间排逆序
	 * @param
	 * @return
	 */
	List<Institution> listInstitutionAllByUsingStatusAndStatusAndIsRecommend();

	/**
	 * 根据ID查询
	 * @param id 主键
	 * @return 机构信息
	 */
	Institution getInstitutionById(@Param("id") String id);


	/**
	 * 根据account查询
	 * @param account
	 * @return 机构信息
	 */
	Institution getInstitutionByAccount(@Param("account") String account);

	/**
	 * 根据account和ID查询
	 * @param account
	 * @return 机构信息
	 */
	boolean getInstitutionByAccountExists(@Param("account") String account, @Param("id") String id);


	/**
	 * 根据institutionNo查询
	 * @param
	 * @return 机构信息
	 */
	Institution getInstitutionByInstitutionNo(@Param("institutionNo") String institutionNo);

	/**
	 * 根据account和password查询
	 * @param account password
	 * @return 机构信息
	 */
	Institution getInstitutionByAccountAndPwd(@Param("account") String account, @Param("password") String password);


	/**
	 * 新增
	 * @param item 机构信息
	 */
	void add(Institution item);

	/**
	 * 新增(不生成机构编号)
	 * @param item 机构信息
	 */
	void addNoGeneratorNumber(Institution item);








	/**
	 * 根据ID集合 
	 * @param ids ID集合
	 */
	void updateUsingStatus(@Param("ids") String[] ids, @Param("usingStatus") Integer usingStatus);

	void updateTrialById(@Param("ids") String[] ids, @Param("trial") Integer trial);

	/**
	 * 根据ID修改合约地址
	 * @param id ID
	 */
	void updateHyUrlById(@Param("hyUrl") String hyUrl, @Param("status") Integer status, @Param("id") String id);
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
	 * 设置推荐度
	 * @return
	 */
	void updateName(Institution item);

	/**
	 * xgs 2015年8月11日11:10:31 设置推荐状态
	 * @param item
	 * @return
	 */
	int  updateFinerStatus(Institution item);
	//end

	/**
	 * 修改
	 * @param item 机构信息
	 */
	void update(Institution item);

	/**
	 * 根据ID集合批量推荐
	 * @param ids ID集合
	 */
	void updateIsRecommendByIds(@Param("isRecommend") Integer isRecommend, @Param("ids") String[] ids);


	/**
	 * 根据ID集合批量修改资料状态
	 * @param ids ID集合
	 */
	void updateStatusByIds(@Param("status") Integer status, @Param("ids") String[] ids);

	/**
	 * 根据ID修改认证状态
	 * @param ids ID集合
	 */
	void updateAuthentcationStatusReasonById(@Param("authentcationStatus") Integer authentcationStatus, @Param("reason") String reason, @Param("ids") String[] ids);

	void updateAuthentcationStatusById(@Param("authentcationStatus") Integer authentcationStatus, @Param("id") String id);


	void updateBlStatusById(@Param("blStatus") Integer blStatus, @Param("id") String id);


	void updateMiblStatusById(@Param("miblStatus") Integer miblStatus, @Param("id") String id);
	/**
	 * 根据ID集合批量删除
	 * @param ids ID集合
	 */
	void delByIds(@Param("ids") String[] ids);

	/**
	 * 根据ID集合批量修改为deleteFlag
	 * @param ids ID集合
	 */
	void updateFlagbyIds(@Param("ids") String[] ids, @Param("deleteFlag") Integer deleteFlag);

	/**
	 * 更新认证度
	 * @param institution
	 */
	void updateAuthentcationRate(Institution institution);

	/**
	 * 查询机构关联的城市
	 * @return
	 */
	//List<InstitutionCityVO> listInstitutionCities();


	/**
	 * 分页快速预约查询机构
	 * @param
	 * @param
	 * @return
	 */
	//List<Institution> listFastCheckByPage(RowBounds bounds, @Param("condition") InstitutionCondition condition);

	int  listFastCheckByPageCount(@Param("condition") InstitutionCondition condition);


	/**
	 * 快速预约查询机构
	 * @param cityId
	 * @param appointDate
	 * @return
	 */
	List<Institution> listFastCheck(@Param("cityId") Integer cityId, @Param("appointDate") Date appointDate);

	/**
	 * 手机端分页查询
	 * @param condition
	 * @return
	 */
	//List<Institution> listMobileByPage(RowBounds bounds, @Param("condition") InstitutionCondition condition);

	int listMobileByPageCount(@Param("condition") InstitutionCondition condition);


	int listByConditionCountNum(@Param("condition") InstitutionCondition condition);
	/**
	 * 根据条件查询
	 * @param condition
	 * @return
	 */
	//List<Institution> listByCondition(RowBounds bounds, @Param("condition") InstitutionCondition condition);

	/**
	 * 根据医生ID查询机构
	 * @param expertId
	 * @return
	 */
	List<Institution> listInstitutionByExpertId(@Param("expertId") String expertId);

	/**
	 * 按照距离最近分页查询
	 * @param
	 * @param condition
	 * @return
	 */
	//List<Institution> listDistanceByPage(RowBounds bounds, @Param("condition") InstitutionCondition condition);
	int listDistanceByPageCount(@Param("condition") InstitutionCondition condition);






	/**
	 *分页查询用户收藏门诊
	 * @param
	 * @return
	 */
	int listInstBypageCount(Map map);

	//List<Institution> listInstBypage(RowBounds bounds, Map map);

	/** pb20150722
	 * 查询推荐收藏的门诊
	 * @param item
	 * @return
	 */
	List<Institution> listInstNotNo(List<String> item);


	//List<Institution> listInstBypage(RowBounds bounds, List<String> item);

	/**
	 * weic 20150819
	 * 根据医生id查询医生所在医院
	 * @param id
	 * @return
	 */
	List<Institution> institutionByExpertId(@Param("id") String id);

	/**
	 *查询机构根据机构名称
	 * @param
	 * @edit by maguoqiang 2015-08-17
	 */
	Institution findInsByInsName(@Param("insName") String insName);


}

