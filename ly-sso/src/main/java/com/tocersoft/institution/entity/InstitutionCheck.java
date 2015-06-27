package com.tocersoft.institution.entity;

import com.tocersoft.base.entity.BaseBusEntity;
import com.tocersoft.institution.aspect.AuthenticationRule;
import com.tocersoft.institution.aspect.annotation.AuthenticationField;

import java.util.Date;

/**
 * 机构信息（审核的信息）
 * 
 * @creator
 * @create-time 2015-02-02 15:56:20
 */
public class InstitutionCheck extends BaseBusEntity {
	/**  */
	private static final long serialVersionUID = 1L;

	/** 机构ID */
	private String institutionNo;
	/** 门诊负责人 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String head;
	/** 门诊负责手机 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String headPhone;
	/** 法人代表 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String legal;
	/** 法人代表手机 */
	private String legalPhone;
	/** 行政负责人 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String executive;
	/** 行政负责手机 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String executivePhone;
	/** 行政负责邮箱 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String email;
	/** 预约网管理员 */
	private String webOfficer;
	/** 预约网管理员手机 */
	private String webOfficerPhone;
	/** 网址 */
	private String url;
	/** 门诊电话 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String linkTel;
	/** 所属公司 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String company;
	/** 注册资金 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Double registeredFund;
	/** 机构成立时间 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Date formed;

	/** 所在省份ID */
	private String provinceId;
	/** 所在省份名称 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String provinceName;
	/** 所在城市ID */
	private String cityId;
	/** 所在城市名称 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String cityName;
	/** 所在区ID */
	private String districtId;
	/** 所在区名称 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String districtName;
	/** 省市区 */
	private String provinceCity;
	/** 联系地址 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String address;
	/** 坐标 */
	private String coord;
	/** 性质：0-公立，1-私立，2-合资，3-外资 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Integer property;
	/**等级*/
	private String classify;
	/** logo */
	private String logo;
	/** 公交 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String bus;
	/** 微信号 */
	private String wechat;
	/** QQ号 */
	private String qq;
	/** 地铁 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String metro;
	/** 独立诊室数量 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Integer independent;
	/** 经营面积 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Double jingymj;
	/** 候诊区面积 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Double waitingArea;
	/** 儿童区面积 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Double childrenArea;
	/** 医生人数 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Integer drNum;
	/** 卫生士人数 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Integer dhNum;
	/** 护士人数 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Integer daNum;
	/** 口腔咨询师 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Integer tcNum;
	/** 前台 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Integer csNum;
	/** 其他人员 */
	@AuthenticationField(rule = AuthenticationRule.NOT_NULL)
	private Integer orNum;
	/** 机构介绍 */
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String introduce;
	/** 审核0-前台不启用 1-前台启用 */
	private Integer status;

	
	/**等级不持久化*/
	private String classifyName;
	
	/**区号*/
	private String areaCode;
	/**电话号码*/
	private String phoneNumber;
	/** 经度值*/
	private Double lng;
	/** 纬度值*/
	private Double lat;
	/**是否连锁 0-不是 1-是*/
	private Integer isChain;
	/**连锁品牌*/
	private String chainBrand;
	/**连锁机构数量*/
	private Integer chainNum;
	/**营业时间*/
	@AuthenticationField(rule = AuthenticationRule.NOT_EMPTY)
	private String businessHour;
	
	/** 机构ID */
	public String getInstitutionNo(){
		return this.institutionNo;
	}

	/** 机构ID */
	public void setInstitutionNo(String institutionNo){
		this.institutionNo = institutionNo;
	}
	/** 门诊负责人 */
	public String getHead(){
		return this.head;
	}

	/** 门诊负责人 */
	public void setHead(String head){
		this.head = head;
	}
	/** 门诊负责手机 */
	public String getHeadPhone(){
		return this.headPhone;
	}

	/** 门诊负责手机 */
	public void setHeadPhone(String headPhone){
		this.headPhone = headPhone;
	}
	/** 法人代表 */
	public String getLegal(){
		return this.legal;
	}

	/** 法人代表 */
	public void setLegal(String legal){
		this.legal = legal;
	}
	/** 法人代表手机 */
	public String getLegalPhone(){
		return this.legalPhone;
	}

	/** 法人代表手机 */
	public void setLegalPhone(String legalPhone){
		this.legalPhone = legalPhone;
	}
	/** 行政负责人 */
	public String getExecutive(){
		return this.executive;
	}

	/** 行政负责人 */
	public void setExecutive(String executive){
		this.executive = executive;
	}
	/** 行政负责手机 */
	public String getExecutivePhone(){
		return this.executivePhone;
	}

	/** 行政负责手机 */
	public void setExecutivePhone(String executivePhone){
		this.executivePhone = executivePhone;
	}
	/** 行政负责邮箱 */
	public String getEmail(){
		return this.email;
	}

	/** 行政负责邮箱 */
	public void setEmail(String email){
		this.email = email;
	}
	/** 网址 */
	public String getUrl(){
		return this.url;
	}

	/** 网址 */
	public void setUrl(String url){
		this.url = url;
	}
	/** 门诊电话 */
	public String getLinkTel(){
		return this.linkTel;
	}

	/** 门诊电话 */
	public void setLinkTel(String linkTel){
		this.linkTel = linkTel;
	}
	/** 所属公司 */
	public String getCompany(){
		return this.company;
	}

	/** 所属公司 */
	public void setCompany(String company){
		this.company = company;
	}
	/** 注册资金 */
	public Double getRegisteredFund(){
		return this.registeredFund;
	}

	/** 注册资金 */
	public void setRegisteredFund(Double registeredFund){
		this.registeredFund = registeredFund;
	}
	/** 机构成立时间 */
	public Date getFormed(){
		return this.formed;
	}

	/** 机构成立时间 */
	public void setFormed(Date formed){
		this.formed = formed;
	}
	
	/** 所在省份ID */
	public String getProvinceId(){
		return this.provinceId;
	}

	/** 所在省份ID */
	public void setProvinceId(String provinceId){
		this.provinceId = provinceId;
	}
	/** 所在省份名称 */
	public String getProvinceName(){
		return this.provinceName;
	}

	/** 所在省份名称 */
	public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	}
	/** 所在城市ID */
	public String getCityId(){
		return this.cityId;
	}

	/** 所在城市ID */
	public void setCityId(String cityId){
		this.cityId = cityId;
	}
	/** 所在城市名称 */
	public String getCityName(){
		return this.cityName;
	}

	/** 所在城市名称 */
	public void setCityName(String cityName){
		this.cityName = cityName;
	}
	/** 所在区ID */
	public String getDistrictId(){
		return this.districtId;
	}

	/** 所在区ID */
	public void setDistrictId(String districtId){
		this.districtId = districtId;
	}
	/** 所在区名称 */
	public String getDistrictName(){
		return this.districtName;
	}

	/** 所在区名称 */
	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}
	/** 省市区 */
	public String getProvinceCity(){
		return this.provinceCity;
	}

	/** 省市区 */
	public void setProvinceCity(String provinceCity){
		this.provinceCity = provinceCity;
	}
	/** 联系地址 */
	public String getAddress(){
		return this.address;
	}

	/** 联系地址 */
	public void setAddress(String address){
		this.address = address;
	}
	/** 坐标 */
	public String getCoord(){
		return this.coord;
	}

	/** 坐标 */
	public void setCoord(String coord){
		this.coord = coord;
	}
	/** 性质：0-公立，1-私立 */
	public Integer getProperty(){
		return this.property;
	}

	/** 性质：0-公立，1-私立 */
	public void setProperty(Integer property){
		this.property = property;
	}
	/** 分类 */
	public String getClassify(){
		return this.classify;
	}

	/** 分类 */
	public void setClassify(String classify){
		this.classify = classify;
	}
	/** logo */
	public String getLogo(){
		return this.logo;
	}

	/** logo */
	public void setLogo(String logo){
		this.logo = logo;
	}
	/** 公交 */
	public String getBus(){
		return this.bus;
	}

	/** 公交 */
	public void setBus(String bus){
		this.bus = bus;
	}
	/** 微信号 */
	public String getWechat(){
		return this.wechat;
	}

	/** 微信号 */
	public void setWechat(String wechat){
		this.wechat = wechat;
	}
	/** 地铁 */
	public String getMetro(){
		return this.metro;
	}

	/** 地铁 */
	public void setMetro(String metro){
		this.metro = metro;
	}
	/** 独立诊室数量 */
	public Integer getIndependent(){
		return this.independent;
	}

	/** 独立诊室数量 */
	public void setIndependent(Integer independent){
		this.independent = independent;
	}
	/** 经营面积 */
	public Double getJingymj(){
		return this.jingymj;
	}

	/** 经营面积 */
	public void setJingymj(Double jingymj){
		this.jingymj = jingymj;
	}
	/** 候诊区面积 */
	public Double getWaitingArea(){
		return this.waitingArea;
	}

	/** 候诊区面积 */
	public void setWaitingArea(Double waitingArea){
		this.waitingArea = waitingArea;
	}
	/** 儿童区面积 */
	public Double getChildrenArea(){
		return this.childrenArea;
	}

	/** 儿童区面积 */
	public void setChildrenArea(Double childrenArea){
		this.childrenArea = childrenArea;
	}
	/** 医生人数 */
	public Integer getDrNum(){
		return this.drNum;
	}

	/** 医生人数 */
	public void setDrNum(Integer drNum){
		this.drNum = drNum;
	}
	/** 卫生士人数 */
	public Integer getDhNum(){
		return this.dhNum;
	}

	/** 卫生士人数 */
	public void setDhNum(Integer dhNum){
		this.dhNum = dhNum;
	}
	/** 护士人数 */
	public Integer getDaNum(){
		return this.daNum;
	}

	/** 护士人数 */
	public void setDaNum(Integer daNum){
		this.daNum = daNum;
	}
	/** 口腔咨询师 */
	public Integer getTcNum(){
		return this.tcNum;
	}

	/** 口腔咨询师 */
	public void setTcNum(Integer tcNum){
		this.tcNum = tcNum;
	}
	/** 前台 */
	public Integer getCsNum(){
		return this.csNum;
	}

	/** 前台 */
	public void setCsNum(Integer csNum){
		this.csNum = csNum;
	}
	/** 其他人员 */
	public Integer getOrNum(){
		return this.orNum;
	}

	/** 其他人员 */
	public void setOrNum(Integer orNum){
		this.orNum = orNum;
	}
	/** 机构介绍 */
	public String getIntroduce(){
		return this.introduce;
	}

	/** 机构介绍 */
	public void setIntroduce(String introduce){
		this.introduce = introduce;
	}
	/** 审核0-前台启用 1-前台不启用 */
	public Integer getStatus(){
		return this.status;
	}

	/** 审核0-前台启用 1-前台不启用 */
	public void setStatus(Integer status){
		this.status = status;
	}

	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebOfficer() {
		return webOfficer;
	}

	public void setWebOfficer(String webOfficer) {
		this.webOfficer = webOfficer;
	}

	public String getWebOfficerPhone() {
		return webOfficerPhone;
	}

	public void setWebOfficerPhone(String webOfficerPhone) {
		this.webOfficerPhone = webOfficerPhone;
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

	public Integer getIsChain() {
		return isChain;
	}

	public void setIsChain(Integer isChain) {
		this.isChain = isChain;
	}

	public String getChainBrand() {
		return chainBrand;
	}

	public void setChainBrand(String chainBrand) {
		this.chainBrand = chainBrand;
	}

	public Integer getChainNum() {
		return chainNum;
	}

	public void setChainNum(Integer chainNum) {
		this.chainNum = chainNum;
	}

	public String getBusinessHour() {
		return businessHour;
	}

	public void setBusinessHour(String businessHour) {
		this.businessHour = businessHour;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

}