package com.ly.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ly.sdk.patools.RequestAccessToken;
import com.ly.sdk.utils.LeyaDateUtils;
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
	 
	@Test
	public void testDate(){
	   
	    String dateStr = "2015-05-15";
	    Date date = LeyaDateUtils.parseDateStr(dateStr,LeyaDateUtils.YYYY_MM_DD);
	    String dateEffect = "2015-05-15 23:45:12";
	    System.out.println(isEqualDate(date,dateEffect));
	}
	
	private int isEqualDate(Date appointDate,String paDateStr){
	    String[] dateFormateStr = new String[]{LeyaDateUtils.YYYY_MM_DDHHMMSS,LeyaDateUtils.YYYYMMDDHHMMSSSDECOLLATOR};
        Date paDate = LeyaDateUtils.parseDateStr(paDateStr,dateFormateStr);
        String compareDateStr = LeyaDateUtils.format(paDate, LeyaDateUtils.YYYY_MM_DD);
        Date compareDate = LeyaDateUtils.parseDateStr(compareDateStr,LeyaDateUtils.YYYY_MM_DD);
        return  appointDate.compareTo(compareDate);
    }
}
