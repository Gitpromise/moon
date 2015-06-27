package com.tocersoft.card.entity;

import com.tocersoft.base.entity.BaseBusEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 卡信息
 * 
 * @creator
 * @create-time 2015-01-07 09:43:08
 */
public class Card extends BaseBusEntity {
	private static final long serialVersionUID = 1L;

	/** 卡名称 */
	private String name;
	/** 申请开始时间 */
	private Date applyBeginDate;
	/** 申请截止时间 */
	private Date applyEndDate;
	/** 起始有效期 */
	private Date startDate;
	/** 截止有效期 */
	private Date endDate;
	/** 卡内容 */
	private String content;
	/** 卡类型ID */
	private String cardTypeId;
	/** 卡图标URL */
	private String icon;
	/** 参与数量限制 */
	private Integer participationNum;
	/** 状态：0-未发布，1-已发布 */
	private Integer status;

	/** 卡类型名称,不持久化到数据库 */
	private String cardTypeName;
	
	private Integer institutionStatus;

	private List<CardTypeService> cardTypeServiceList=new ArrayList<CardTypeService>();
	/** 卡名称 */
	public String getName() {
		return this.name;
	}

	/** 卡名称 */
	public void setName(String name) {
		this.name = name;
	}

	/** 申请开始时间 */
	public Date getApplyBeginDate() {
		return this.applyBeginDate;
	}

	/** 申请开始时间 */
	public void setApplyBeginDate(Date applyBeginDate) {
		this.applyBeginDate = applyBeginDate;
	}

	/** 申请截止时间 */
	public Date getApplyEndDate() {
		return this.applyEndDate;
	}

	/** 申请截止时间 */
	public void setApplyEndDate(Date applyEndDate) {
		this.applyEndDate = applyEndDate;
	}

	/** 起始有效期 */
	public Date getStartDate() {
		return this.startDate;
	}

	/** 起始有效期 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/** 截止有效期 */
	public Date getEndDate() {
		return this.endDate;
	}

	/** 截止有效期 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/** 卡内容 */
	public String getContent() {
		return this.content;
	}

	/** 卡内容 */
	public void setContent(String content) {
		this.content = content;
	}

	/** 卡类型ID */
	public String getCardTypeId() {
		return this.cardTypeId;
	}

	/** 卡类型ID */
	public void setCardTypeId(String cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	/** 卡图标URL */
	public String getIcon() {
		return this.icon;
	}

	/** 卡图标URL */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/** 参与数量限制 */
	public Integer getParticipationNum() {
		return this.participationNum;
	}

	/** 参与数量限制 */
	public void setParticipationNum(Integer participationNum) {
		this.participationNum = participationNum;
	}

	/** 状态：0-未发布，1-已发布 */
	public Integer getStatus() {
		return this.status;
	}

	/** 状态：0-未发布，1-已发布 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/** 卡类型名称,不持久化到数据库 */
	public String getCardTypeName() {
		return cardTypeName;
	}

	/** 卡类型名称,不持久化到数据库 */
	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}

	public List<CardTypeService> getCardTypeServiceList() {
		return cardTypeServiceList;
	}

	public void setCardTypeServiceList(List<CardTypeService> cardTypeServiceList) {
		this.cardTypeServiceList = cardTypeServiceList;
	}

	public Integer getInstitutionStatus() {
		return institutionStatus;
	}

	public void setInstitutionStatus(Integer institutionStatus) {
		this.institutionStatus = institutionStatus;
	}

}