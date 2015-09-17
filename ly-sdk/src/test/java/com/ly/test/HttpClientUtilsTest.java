package com.ly.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ly.sdk.patools.RequestAccessToken;
import com.ly.sdk.utils.LeyaHttpClientUtils;
import com.ly.sdk.vo.BaseResponseVo;

public class HttpClientUtilsTest {

	@Test
	public void testInvokeGetOnlyUrl() {
		String url = "https://www.baidu.com";
		BaseResponseVo vo = LeyaHttpClientUtils.invokeGet(url);
		System.out.println(vo.toString());
	}

	@Test
	public void testInvokeGet() {
		
		  String url = "https://test-api.pingan.com.cn:20443/oauth/oauth2/access_token";
				  
		  Map<String,String> params = new HashMap<String,String>(0);
		  params.put("client_id", "P_LEYACK_YL"); 
		  params.put("grant_type", "client_credentials"); 
		  params.put("client_secret", "jt6Ss47N"); 
		  BaseResponseVo vo = LeyaHttpClientUtils.invokeJsonGet(url, params);
		  System.out.println(vo.toString());
		
	}

	@Test
	public void testPost() {
		/*String url = "http://121.40.156.189:8085/leyaSmsService/demotest/testasync";
		Map<String, String> params = new HashMap<String, String>(0);
		params.put("requestIndex", "1");
		BaseResponseVo vo = LeyaHttpClientUtils.sendPost(url, params);
		System.out.println(vo.toString());*/
		System.out.println(RequestAccessToken.getAccessToken());
	}
}
