package com.ly.sdk.patools;

import java.util.HashMap;
import java.util.Map;

import com.ly.sdk.env.PinganEnvProperties;
import com.ly.sdk.utils.LeyaConstantUtils;
import com.ly.sdk.utils.LeyaHttpClientUtils;
import com.ly.sdk.vo.BaseResponseVo;

public class RequestAccessToken {

	/**
	 * 获取 平安token 获取失败返回 ""
	 * 成功返回如下
	 * {"ret":"0","data":{"expires_in":"1216","openid":"P_LEYACK_YL00","access_token":"6102CB254AB842A188F03BF513ECAA6E"},"msg":""}
	 * @return
	 */
	public static String getAccessToken(){
	   String tokenUrl  = PinganEnvProperties.getString(LeyaConstantUtils.PINGAN_ACCESS_TOKEN_RUL);
	   String clientId = PinganEnvProperties.getString(LeyaConstantUtils.PINGAN_CLIENT_ID);
	   String clientSecret = PinganEnvProperties.getString(LeyaConstantUtils.PINGAN_CLIENT_SECRET);
	   String grantType = PinganEnvProperties.getString(LeyaConstantUtils.PINGAN_GRANT_TYPE);
	   Map<String,String> params = new HashMap<String,String>(0);
	   params.put(LeyaConstantUtils.PINGAN_CLIENT_ID, clientId);
	   params.put(LeyaConstantUtils.PINGAN_CLIENT_SECRET, clientSecret);
	   params.put(LeyaConstantUtils.PINGAN_GRANT_TYPE, grantType);
	   BaseResponseVo vo = LeyaHttpClientUtils.invokeJsonGet(tokenUrl, params);
	   if (LeyaConstantUtils.SUCCESS_RESPONSE.equalsIgnoreCase(vo.getResponseCode())) {
		   return vo.getResponseMsg();
	   }
	   return "";
	}
}
