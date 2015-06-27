package com.tocersoft.system.entity;

import com.tocersoft.base.entity.BaseBusEntity;

/**
 * 文件图片表
 * 
 * @creator
 * @create-time 2014-05-28 23:07:44
 */
public class SysUploadFile extends BaseBusEntity {
	/**  */
	private static final long serialVersionUID = 1L;

	/** 文件名称-用户自定义 */
	private String name;
	/** 文件名称 */
	private String fileName;
	/** 物理存放路径 */
	private String path;
	/** 物理存放路径（多个逗号分开） */
	private String paths;
	/** 文件下载URL */
	private String url;
	/** 文件扩展名 */
	private String extend;
	/** 文件类型：0-图片，1-文件，2-音频，3-视频，4-Flash */
	private Integer type;
	/** 文件说明1 用于存储编号 */
	private String desc1;
	/** 文件说明 2*/
	private String desc2;
	/** 文件说明 3*/
	private String desc3;
	/** 超链接 */
	private String link;
	/** 相关联的对象ID */
	private String objectId;
	/** 相关联的对象类型 */
	private String objectType;
	/** 排序字段，数字越小排序越靠前 */
	private Integer sort;

	/** 文件名称 */
	public String getFileName(){
		return this.fileName;
	}

	/** 文件名称 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	/** 物理存放路径 */
	public String getPath(){
		return this.path;
	}

	/** 物理存放路径 */
	public void setPath(String path){
		this.path = path;
	}
	/** 文件下载URL */
	public String getUrl(){
		return this.url;
	}

	/** 文件下载URL */
	public void setUrl(String url){
		this.url = url;
	}
	/** 文件扩展名 */
	public String getExtend(){
		return this.extend;
	}

	/** 文件扩展名 */
	public void setExtend(String extend){
		this.extend = extend;
	}
	/** 文件类型：0-图片，1-文件，2-音频，3-视频，4-Flash */
	public Integer getType(){
		return this.type;
	}

	/** 文件类型：0-图片，1-文件，2-音频，3-视频，4-Flash */
	public void setType(Integer type){
		this.type = type;
	}
 
	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public String getDesc3() {
		return desc3;
	}

	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}

	/** 超链接 */
	public String getLink(){
		return this.link;
	}

	/** 超链接 */
	public void setLink(String link){
		this.link = link;
	}
	/** 相关联的对象ID */
	public String getObjectId(){
		return this.objectId;
	}

	/** 相关联的对象ID */
	public void setObjectId(String objectId){
		this.objectId = objectId;
	}
	/** 相关联的对象类型 */
	public String getObjectType(){
		return this.objectType;
	}

	/** 相关联的对象类型 */
	public void setObjectType(String objectType){
		this.objectType = objectType;
	}
	/** 排序字段，数字越小排序越靠前 */
	public Integer getSort(){
		return this.sort;
	}

	/** 排序字段，数字越小排序越靠前 */
	public void setSort(Integer sort){
		this.sort = sort;
	}

	public String getPaths() {
		return paths;
	}

	public void setPaths(String paths) {
		this.paths = paths;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}