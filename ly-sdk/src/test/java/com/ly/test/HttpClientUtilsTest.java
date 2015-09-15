package com.ly.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.ly.sdk.utils.LeyaHttpClientUtils;
import com.ly.sdk.vo.BaseResponseVo;

public class HttpClientUtilsTest {

    @Test
    public void testInvokeGetOnlyUrl(){
        String url = "https://www.baidu.com";
        BaseResponseVo vo =  LeyaHttpClientUtils.invokeGet(url);
        System.out.println(vo.toString());
    }
    
    @Test
    public void testInvokeGet(){
        String url = "http://ir.baidu.com/phoenix.zhtml?c=188488";
        Map<String,String> params = new  HashMap<String,String>(0);
        params.put("p", "irol-homeprofile");
        BaseResponseVo vo =  LeyaHttpClientUtils.invokeGet(url,params);
        System.out.println(vo.toString());
    }
    
    @Test
    public void testPost(){
        String url = "http://121.40.156.189:8085/leyaSmsService/demotest/testasync";
        Map<String,String> params = new  HashMap<String,String>(0);
        params.put("requestIndex", "1");
        BaseResponseVo vo =  LeyaHttpClientUtils.sendPost(url, params);
        System.out.println(vo.toString());
    }
}
