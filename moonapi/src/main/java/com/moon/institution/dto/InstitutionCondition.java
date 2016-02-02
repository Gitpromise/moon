package com.moon.institution.dto;


import com.moon.base.dto.BaseCondition;

import java.util.Date;

public class InstitutionCondition extends BaseCondition {
	/** 机构编号，（J+注册年月日+4个编号） */
	private String institutionNo;
	/** 机构账号 */
	private String account;
	/** 机构密码 */
	private String password;
	/** 门诊负责人 */
	private String head;
	/** 门诊负责手机 */
	private String headPhone;
	/** 法人代表 */
	private String legal;
	/** 法人代表手机 */
	private String legalPhone;
	/** 行政负责人 */
	private String executive;
	/** 行政负责手机 */
	private String executivePhone;
	/** 行政负责邮箱 */
	private String email;
	/** 网址 */
	private String url;
	/** 门诊电话 */
	private String linkTel;
	/** 所属公司 */
	private String company;
	/** 注册资金 */
	private Double registeredFund;
	/** 机构成立时间 */
	private Date formed;
	/** 机构名称 */
	private String name;
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
	/** 联系地址 */
	private String address;
	/** 公交 */
	private String bus;
	/** 地铁*/
	private String metro;
	/** sheet页签 */
	private String sheetSel;
	
	/** 坐标 */
	private String coord;
	/** 性质：0-公立，1-私立 */
	private Integer property;
	private String  classify;
	/** 是否推荐，0-否，1-是 */
	private Integer isRecommend;
	/** 推荐度 */
	private Integer recommend;
	/** 状态：0-注册完成，1-资料已完善（100%）/资质审核中 */
	private Integer status;
	/** 打回原因 */
	private String reason;
	private String weChat;
	/** 启用状态0：启用；1：禁用 */
	private Integer usingStatus;
	/** 启用状态0：前台不启用；1：前台启用 */
	private Integer ocStatus;
	/** 独立诊室数量 */
	private Integer independent;
	/** 经营面积 */
	private Integer jingymj;
	/** 候诊区面积 */
	private Integer waitingArea;
	/** 儿童区面积 */
	private Integer childrenArea;
	/** 医生人数 */
	private Integer drNum;
	/** 卫生士人数 */
	private Integer dhNum;
	/** 护士人数 */
	private Integer daNum;
	/** 口腔咨询师 */
	private Integer tcNum;
	/** 前台 */
	private Integer csNum;
	/** 其他人员 */
	private Integer orNum;
	/** 机构介绍 */
	private String introduce;
	
	/** 预约单状态 */
	private String[] institutionState;
	
	//服务项ID
	private String serverItemId;
	//活动ID
	private String cardId;
	
	
	//排序
	private Integer order;
	
	private Double lng;
	
	private Double lat;
	private Date appointDate;
	
	/** 认证状态：0-未认证 ， 1-认证申请中 ，2-资料已审核，复审中，3-已认证，4-认证不通过*/
	private Integer authentcationStatus;
	/** 注册完成审核：0-未审核 1-已审核 */
	private Integer trial;
	/** 营业执照上传状态：0-未上传 1-已上传 */
	private Integer blStatus;
	/** 医疗机构经营许可证上传状态：0-未上传 1-已上传 */
	private Integer miblStatus;
	/** 是否支持社保:0-支持 1-不支持 */
	private Integer supportSocialSecurity;
	
	private Integer authentcationRate;

	private String serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	public String getInstitutionNo() {
		return institutionNo;
	}
	public void setInstitutionNo(String institutionNo) {
		this.institutionNo = institutionNo;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getHeadPhone() {
		return headPhone;
	}
	public void setHeadPhone(String headPhone) {
		this.headPhone = headPhone;
	}
	public String getLegal() {
		return legal;
	}
	public void setLegal(String legal) {
		this.legal = legal;
	}
	public String getLegalPhone() {
		return legalPhone;
	}
	public void setLegalPhone(String legalPhone) {
		this.legalPhone = legalPhone;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLinkTel() {
		return linkTel;
	}
	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCoord() {
		return coord;
	}
	public void setCoord(String coord) {
		this.coord = coord;
	}
	public Integer getProperty() {
		return property;
	}
	public void setProperty(Integer property) {
		this.property = property;
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
	public Integer getIndependent() {
		return independent;
	}
	public void setIndependent(Integer independent) {
		this.independent = independent;
	}
	public Integer getJingymj() {
		return jingymj;
	}
	public void setJingymj(Integer jingymj) {
		this.jingymj = jingymj;
	}
	public Integer getWaitingArea() {
		return waitingArea;
	}
	public void setWaitingArea(Integer waitingArea) {
		this.waitingArea = waitingArea;
	}
	public Integer getChildrenArea() {
		return childrenArea;
	}
	public void setChildrenArea(Integer childrenArea) {
		this.childrenArea = childrenArea;
	}
	public Integer getDrNum() {
		return drNum;
	}
	public void setDrNum(Integer drNum) {
		this.drNum = drNum;
	}
	public Integer getDhNum() {
		return dhNum;
	}
	public void setDhNum(Integer dhNum) {
		this.dhNum = dhNum;
	}
	public Integer getDaNum() {
		return daNum;
	}
	public void setDaNum(Integer daNum) {
		this.daNum = daNum;
	}
	public Integer getTcNum() {
		return tcNum;
	}
	public void setTcNum(Integer tcNum) {
		this.tcNum = tcNum;
	}
	public Integer getCsNum() {
		return csNum;
	}
	public void setCsNum(Integer csNum) {
		this.csNum = csNum;
	}
	public Integer getOrNum() {
		return orNum;
	}
	public void setOrNum(Integer orNum) {
		this.orNum = orNum;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getFormed() {
		return formed;
	}
	public void setFormed(Date formed) {
		this.formed = formed;
	}
	public Double getRegisteredFund() {
		return registeredFund;
	}
	public void setRegisteredFund(Double registeredFund) {
		this.registeredFund = registeredFund;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	public String getMetro() {
		return metro;
	}
	public void setMetro(String metro) {
		this.metro = metro;
	}
	public String getWeChat() {
		return weChat;
	}
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	public Integer getOcStatus() {
		return ocStatus;
	}
	public void setOcStatus(Integer ocStatus) {
		this.ocStatus = ocStatus;
	}
	public String getServerItemId() {
		return serverItemId;
	}
	public void setServerItemId(String serverItemId) {
		this.serverItemId = serverItemId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}

	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getSheetSel() {
		return sheetSel;
	}
	public void setSheetSel(String sheetSel) {
		this.sheetSel = sheetSel;
	}
	public String[] getInstitutionState() {
		return institutionState;
	}
	public void setInstitutionState(String[] institutionState) {
		this.institutionState = institutionState;
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
	public Integer getAuthentcationRate() {
		return authentcationRate;
	}
	public void setAuthentcationRate(Integer authentcationRate) {
		this.authentcationRate = authentcationRate;
	}
	
}
