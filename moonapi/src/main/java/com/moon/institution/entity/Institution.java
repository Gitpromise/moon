package com.moon.institution.entity;

import com.moon.base.entity.BaseBusEntity;

import java.util.Date;

/**
 * 机构信息
 * 
 * @creator
 * @create-time 2015-01-16 11:31:14
 */

public class Institution extends BaseBusEntity implements Comparable<Institution>{
	/**  */
	private static final long serialVersionUID = 1L;

	/** 机构编号，（J+注册年月日+4个编号） */
	private String institutionNo;
	/** 机构名称 */
	//@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String name;
	/** 机构账号 */
	//@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String account;
	/** 机构密码 */
	//@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String password;
	
	/** 是否推荐，0-否，1-是 */
	private Integer isRecommend;
	/** 推荐度 */
	private Integer recommend;
	/**状态：状态：0-注册完成，1-资料已完善（100%）/资质审核中*/
	private Integer status;
	/** 打回原因 */
	private String reason;
	/** 启用状态0：启用；1：禁用 */
	private Integer usingStatus;
	/** 合约路径*/
	private String hyUrl;

	/**不持久化的变量*/
	/**预约人数*/
	private Integer appointOrderNum;
	/** 机构所参加的活动图标 */
	//private List<Card> activityIconList = new ArrayList<Card>();
	
	private Integer isHoldCard;

	public Integer getIsHoldCard() {
		return isHoldCard;
	}

	public void setIsHoldCard(Integer isHoldCard) {
		this.isHoldCard = isHoldCard;
	}

	/** 机构信息（审核的信息）*/
	//private InstitutionCheck institutionCheck=new InstitutionCheck();
	
	/**首图*/
	//private SysUploadFile firstPhoto;
	/** （机构评价）总评价 */
	private Double assess=50D;
	/**好评 */
	private Double good=0D;
	/**中评 */
	private Double average=0D;
	/**差评 */
	private Double bad=0D;
	/** （机构评价）技术水平 */
	private Double technical=5D;
	/** （机构评价）就诊环境 */
	private Double setting=5D;
	/** （机构评价）服务态度 */
	private Double attitude=5D;
	/** （机构评价）等候时间 */
	private Double waiting=5D;
	

	
	/** 预约人数 */
	private Integer appointCount;
	
	/** 公告 活动  的内容标题*/
	private String articleName;
	private String articleDesc;
	
	/** 行政负责手机 */
	private String mobile;
	/** 头像  */
	private String photo;
	
	/** 距离*/
	private double distance;
	
	/** 认证度 */
	private Integer authentcationRate;
	/** 认证状态：0-未认证 ， 1-认证申请中 ，2-资料已审核，复审中，3-已认证，4-认证不通过*/
	private Integer authentcationStatus;
	/** 注册审核：0-未审核 1-已审核 */
	private Integer trial;
	/** 营业执照上传状态：0-未上传 1-已上传 */
	private Integer blStatus;
	/** 医疗机构经营许可证上传状态：0-未上传 1-已上传 */
	private Integer miblStatus;
	/** 是否支持社保:0-支持 1-不支持 */
	private Integer supportSocialSecurity;
	/** 被收藏数 */
	private int collectCount;

	public int getFinerStatus() {
		return finerStatus;
	}

	public void setFinerStatus(int finerStatus) {
		this.finerStatus = finerStatus;
	}

	/**xgs 2015年8月11日10:43:37 */
	//推荐状态

	private int finerStatus;


	public Date getFinerStick() {
		return finerStick;
	}

	public void setFinerStick(Date finerStick) {
		this.finerStick = finerStick;
	}

	private Date finerStick;

	/**xgs end */
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/** 机构编号，（J+注册年月日+4个编号） */
	public String getInstitutionNo(){
		return this.institutionNo;
	}

	public Integer getAppointCount() {
		return appointCount;
	}

	public void setAppointCount(Integer appointCount) {
		this.appointCount = appointCount;
	}

	/** 机构编号，（J+注册年月日+4个编号） */
	public void setInstitutionNo(String institutionNo){
		this.institutionNo = institutionNo;
	}
	/** 机构账号 */
	public String getAccount(){
		return this.account;
	}

	/** 机构账号 */
	public void setAccount(String account){
		this.account = account;
	}
	/** 机构密码 */
	public String getPassword(){
		return this.password;
	}

	/** 机构密码 */
	public void setPassword(String password){
		this.password = password;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getUsingStatus() {
		return usingStatus;
	}

	public void setUsingStatus(Integer usingStatus) {
		this.usingStatus = usingStatus;
	}

	public Integer getAppointOrderNum() {
		return appointOrderNum;
	}

	public void setAppointOrderNum(Integer appointOrderNum) {
		this.appointOrderNum = appointOrderNum;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	/*public SysUploadFile getFirstPhoto() {
		return firstPhoto;
	}

	public void setFirstPhoto(SysUploadFile firstPhoto) {
		this.firstPhoto = firstPhoto;
	}

	public InstitutionCheck getInstitutionCheck() {
		return institutionCheck;
	}

	public void setInstitutionCheck(InstitutionCheck institutionCheck) {
		this.institutionCheck = institutionCheck;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAssess() {
		return assess;
	}

	public void setAssess(Double assess) {
		this.assess = assess;
	}

	public Double getGood() {
		return good;
	}

	public void setGood(Double good) {
		this.good = good;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getBad() {
		return bad;
	}

	public void setBad(Double bad) {
		this.bad = bad;
	}

	public Double getTechnical() {
		return technical;
	}

	public void setTechnical(Double technical) {
		this.technical = technical;
	}

	public Double getSetting() {
		return setting;
	}

	public void setSetting(Double setting) {
		this.setting = setting;
	}

	public Double getAttitude() {
		return attitude;
	}

	public void setAttitude(Double attitude) {
		this.attitude = attitude;
	}

	public Double getWaiting() {
		return waiting;
	}

	public void setWaiting(Double waiting) {
		this.waiting = waiting;
	}



	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Integer getAuthentcationRate() {
		return authentcationRate;
	}

	public void setAuthentcationRate(Integer authentcationRate) {
		this.authentcationRate = authentcationRate;
	}

	/*public List<Card> getActivityIconList() {
		return activityIconList;
	}

	public void setActivityIconList(List<Card> activityIconList) {
		this.activityIconList = activityIconList;
	}*/

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleDesc() {
		return articleDesc;
	}

	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}

	public String getHyUrl() {
		return hyUrl;
	}

	public void setHyUrl(String hyUrl) {
		this.hyUrl = hyUrl;
	}

	public int compareTo(Institution o) {
		int result = o.getDistance() < this.distance?1:o.getDistance() == this.distance?0:-1;
		return result;
	}

	public Integer getAuthentcationStatus() {
		return authentcationStatus;
	}

	public void setAuthentcationStatus(Integer authentcationStatus) {
		this.authentcationStatus = authentcationStatus;
	}

	public Integer getTrial() {
		return trial;
	}

	public void setTrial(Integer trial) {
		this.trial = trial;
	}

	public Integer getBlStatus() {
		return blStatus;
	}

	public void setBlStatus(Integer blStatus) {
		this.blStatus = blStatus;
	}

	public Integer getMiblStatus() {
		return miblStatus;
	}

	public void setMiblStatus(Integer miblStatus) {
		this.miblStatus = miblStatus;
	}

	public Integer getSupportSocialSecurity() {
		return supportSocialSecurity;
	}

	public void setSupportSocialSecurity(Integer supportSocialSecurity) {
		this.supportSocialSecurity = supportSocialSecurity;
	}

	//xgs 2015年8月6日11:20:04

	/**等级不持久化*/
	private String classifyName;

	/** 审核0-前台不启用 1-前台启用 */
	private Integer checkStatus;

	/** 行政负责人 */

	private String executive;

	/** 行政负责手机 */

	private String executivePhone;

	/** 门诊电话 */

	private String linkTel;

	/** 行政负责邮箱 */

	private String email;

	/** 所在省份ID */
	private String provinceId;
	/** 所在省份名称 */

	private String provinceName;
	/** 所在城市ID */
	private String cityId;
	/** 所在城市名称 */

	private String cityName;
	/** 所在区ID */
	private String districtId;
	/** 所在区名称 */

	private String districtName;
	/** 省市区 */
	private String provinceCity;

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public Integer getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getExecutive() {
		return executive;
	}

	public void setExecutive(String executive) {
		this.executive = executive;
	}

	public String getExecutivePhone() {
		return executivePhone;
	}

	public void setExecutivePhone(String executivePhone) {
		this.executivePhone = executivePhone;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getProvinceCity() {
		return provinceCity;
	}

	public void setProvinceCity(String provinceCity) {
		this.provinceCity = provinceCity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/** 联系地址 */

	private String address;
}