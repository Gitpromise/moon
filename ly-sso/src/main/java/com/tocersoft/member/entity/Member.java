package com.tocersoft.member.entity;
import java.util.Date;

import com.tocersoft.base.entity.BaseBusEntity;

/**
 * 会员信息
 *
 * @creator
 * @create-time 2014-12-29 13:35:04
 */
public class Member extends BaseBusEntity {
    /**  */
    private static final long serialVersionUID = 1L;

    /** 会员账号 */
    private String account;
    /** 会员密码 */
    private String password;
    /** 会员密码 */
    private String rePassword;
    /** 会员昵称 */
    private String nickName;
    /** 会员姓名 */
    private String name;
    /** 性别：0-女，1-男 */
    private Integer sex;
    /** 出生日期 */
    private Date birthdate;
    /** 身份证 */
    private String idCard;
    /** 国籍 */
    private String nationality;
    /** 民族 */
    private String nation;
    /** 籍贯 */
    private String nativePlace;
    /** 会员头像 */
    private String photo;
    /** 会员手机号码 */
    private String mobile;
    /** 会员邮箱 */
    private String email;
    /** 会员所在省份ID */
    private String provinceId;
    /** 会员所在省份名称 */
    private String provinceName;
    /** 会员所在城市ID */
    private String cityId;
    /** 会员所在城市名称 */
    private String cityName;
    /** 会员所在区ID */
    private String districtId;
    /** 会员所在区名称 */
    private String districtName;
    /** 居住地（省市区） */
    private String provinceCity;
    /** 邮编 */
    private String postcode;
    /** 通讯地址 */
    private String address;
    /** 会员等级，0-普通会员、1-VIP会员、2-银牌会员、3-金牌会员、4-钻石会员 */
    private Integer level;
    /** 会员状态，0：正常 1：冻结 2：封号 */
    private Integer status;
    /** 经度 */
    private Double lng;
    private Double lat;

    private String groupCompant;
    private String medicalCard;
    private String compant;
    private Integer age;
    private String memberId;
    private String huZhao;

    private String memberCardId;

    private Integer score;

    public String getMemberCardId() {
        return memberCardId;
    }

    public void setMemberCardId(String memberCardId) {
        this.memberCardId = memberCardId;
    }

    /** 会员账号 */
    public String getAccount(){
        return this.account;
    }

    /** 会员账号 */
    public void setAccount(String account){
        this.account = account;
    }
    /** 会员密码 */
    public String getPassword(){
        return this.password;
    }

    /** 会员密码 */
    public void setPassword(String password){
        this.password = password;
    }
    /** 会员昵称 */
    public String getNickName(){
        return this.nickName;
    }

    /** 会员昵称 */
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    /** 会员姓名 */
    public String getName(){
        return this.name;
    }

    /** 会员姓名 */
    public void setName(String name){
        this.name = name;
    }
    /** 性别：0-女，1-男 */
    public Integer getSex(){
        return this.sex;
    }

    /** 性别：0-女，1-男 */
    public void setSex(Integer sex){
        this.sex = sex;
    }
    /** 出生日期 */
    public Date getBirthdate(){
        return this.birthdate;
    }

    /** 出生日期 */
    public void setBirthdate(Date birthdate){
        this.birthdate = birthdate;
    }
    /** 身份证 */
    public String getIdCard(){
        return this.idCard;
    }

    /** 身份证 */
    public void setIdCard(String idCard){
        this.idCard = idCard;
    }
    /** 国籍 */
    public String getNationality(){
        return this.nationality;
    }

    /** 国籍 */
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    /** 民族 */
    public String getNation(){
        return this.nation;
    }

    /** 民族 */
    public void setNation(String nation){
        this.nation = nation;
    }
    /** 籍贯 */
    public String getNativePlace(){
        return this.nativePlace;
    }

    /** 籍贯 */
    public void setNativePlace(String nativePlace){
        this.nativePlace = nativePlace;
    }
    /** 会员头像 */
    public String getPhoto(){
        return this.photo;
    }

    /** 会员头像 */
    public void setPhoto(String photo){
        this.photo = photo;
    }
    /** 会员手机号码 */
    public String getMobile(){
        return this.mobile;
    }

    /** 会员手机号码 */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    /** 会员邮箱 */
    public String getEmail(){
        return this.email;
    }

    /** 会员邮箱 */
    public void setEmail(String email){
        this.email = email;
    }
    /** 会员所在省份ID */
    public String getProvinceId(){
        return this.provinceId;
    }

    /** 会员所在省份ID */
    public void setProvinceId(String provinceId){
        this.provinceId = provinceId;
    }
    /** 会员所在省份名称 */
    public String getProvinceName(){
        return this.provinceName;
    }

    /** 会员所在省份名称 */
    public void setProvinceName(String provinceName){
        this.provinceName = provinceName;
    }
    /** 会员所在城市ID */
    public String getCityId(){
        return this.cityId;
    }

    /** 会员所在城市ID */
    public void setCityId(String cityId){
        this.cityId = cityId;
    }
    /** 会员所在城市名称 */
    public String getCityName(){
        return this.cityName;
    }

    /** 会员所在城市名称 */
    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    /** 会员所在区ID */
    public String getDistrictId(){
        return this.districtId;
    }

    /** 会员所在区ID */
    public void setDistrictId(String districtId){
        this.districtId = districtId;
    }
    /** 会员所在区名称 */
    public String getDistrictName(){
        return this.districtName;
    }

    /** 会员所在区名称 */
    public void setDistrictName(String districtName){
        this.districtName = districtName;
    }
    /** 居住地（省市区） */
    public String getProvinceCity(){
        return this.provinceCity;
    }

    /** 居住地（省市区） */
    public void setProvinceCity(String provinceCity){
        this.provinceCity = provinceCity;
    }
    /** 邮编 */
    public String getPostcode(){
        return this.postcode;
    }

    /** 邮编 */
    public void setPostcode(String postcode){
        this.postcode = postcode;
    }
    /** 通讯地址 */
    public String getAddress(){
        return this.address;
    }

    /** 通讯地址 */
    public void setAddress(String address){
        this.address = address;
    }
    /** 会员等级，0-普通会员、1-VIP会员、2-银牌会员、3-金牌会员、4-钻石会员 */
    public Integer getLevel(){
        return this.level;
    }

    /** 会员等级，0-普通会员、1-VIP会员、2-银牌会员、3-金牌会员、4-钻石会员 */
    public void setLevel(Integer level){
        this.level = level;
    }
    /** 会员状态，0：正常 1：冻结 2：封号 */
    public Integer getStatus(){
        return this.status;
    }

    /** 会员状态，0：正常 1：冻结 2：封号 */
    public void setStatus(Integer status){
        this.status = status;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getGroupCompant() {
        return groupCompant;
    }

    public void setGroupCompant(String groupCompant) {
        this.groupCompant = groupCompant;
    }

    public String getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard;
    }

    public String getCompant() {
        return compant;
    }

    public void setCompant(String compant) {
        this.compant = compant;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getHuZhao() {
        return huZhao;
    }

    public void setHuZhao(String huZhao) {
        this.huZhao = huZhao;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}