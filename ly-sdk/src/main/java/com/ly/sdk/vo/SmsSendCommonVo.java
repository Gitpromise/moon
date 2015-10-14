package com.ly.sdk.vo;

/**
 * 
 * <p>ClassName: SmsSendCommonVo</p>
 * <p>Description: 调用短信接口参数</p>
 * <p>Author: Administrator</p>
 * <p>Date: 2015年10月14日</p>
 */
public class SmsSendCommonVo implements java.io.Serializable {

    /**
     * <p>
     * Field serialVersionUID: TODO
     * </p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 内容
     */
    private String content;

    /**
     * 优先级别
     */
    private Integer timeLineLevel;
    
    private String uniquelyId;

    
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTimeLineLevel() {
        return timeLineLevel;
    }

    public void setTimeLineLevel(Integer timeLineLevel) {
        this.timeLineLevel = timeLineLevel;
    }

    public String getUniquelyId() {
        return uniquelyId;
    }

    public void setUniquelyId(String uniquelyId) {
        this.uniquelyId = uniquelyId;
    }

}
