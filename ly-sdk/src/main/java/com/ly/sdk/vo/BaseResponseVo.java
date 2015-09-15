package com.ly.sdk.vo;

/**
 * 
 * <p>ClassName: BaseResponseVo</p>
 * <p>Description: http请求返回统一的封装类</p>
 * <p>Author: Administrator</p>
 * <p>Date: 2015年9月15日</p>
 */
public class BaseResponseVo implements java.io.Serializable {

    /**
     * <p>Field serialVersionUID: TODO</p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * http请求是否成功
     */
    private String responseCode;
    
    /**
     * http请求返回结果
     */
    private String responseMsg;

    public BaseResponseVo() {
        super();
    }

    public BaseResponseVo(String responseCode, String responseMsg) {
        super();
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    /**
     * <p>Description: TODO</p>
     * @return the responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * <p>Description: TODO</p>
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * <p>Description: TODO</p>
     * @return the responseMsg
     */
    public String getResponseMsg() {
        return responseMsg;
    }

    /**
     * <p>Description: TODO</p>
     * @param responseMsg the responseMsg to set
     */
    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    /* (non-Javadoc)
     * <p>Title: toString</p>
     * <p>Description: </p>
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        
        return "responseCode="+this.responseCode+",responseMsg="+this.responseMsg;
    }
    
    
}
