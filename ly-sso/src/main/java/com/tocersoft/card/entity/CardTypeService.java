package com.tocersoft.card.entity;

import com.tocersoft.base.entity.BaseBusEntity;

/**
 * 卡类型与服务项目关联表
 * 
 * @creator
 * @create-time 2015-01-07 14:58:35
 */
public class CardTypeService extends BaseBusEntity {
	private static final long serialVersionUID = 1L;

	/** 类型ID */
	private String cardTypeId;
	/** 服务项目ID */
	private String serviceItemId;
	/** 治疗项目,不持久化到数据库 */
	private String treatmentProject;
	/** 症状名称,不持久化到数据库 */
	private String symptomName;
	/** 描述,不持久化到数据库 */
	private String description;

	/** 类型ID */
	public String getCardTypeId() {
		return this.cardTypeId;
	}

	/** 类型ID */
	public void setCardTypeId(String cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	/** 服务项目ID */
	public String getServiceItemId() {
		return this.serviceItemId;
	}

	/** 服务项目ID */
	public void setServiceItemId(String serviceItemId) {
		this.serviceItemId = serviceItemId;
	}

	/** 治疗项目,不持久化到数据库 */
	public String getTreatmentProject() {
		return treatmentProject;
	}

	/** 治疗项目,不持久化到数据库 */
	public void setTreatmentProject(String treatmentProject) {
		this.treatmentProject = treatmentProject;
	}

	/** 症状名称,不持久化到数据库 */
	public String getSymptomName() {
		return symptomName;
	}

	/** 症状名称,不持久化到数据库 */
	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	/** 描述,不持久化到数据库 */
	public String getDescription() {
		return description;
	}

	/** 描述,不持久化到数据库 */
	public void setDescription(String description) {
		this.description = description;
	}
}