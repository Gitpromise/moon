package com.ly.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.CodingErrorAction;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.ly.sdk.vo.BaseResponseVo;

/**
 * 
 * <p>
 * ClassName: LeyaHttpClientUtils
 * </p>
 * <p>
 * Description: http请求封装类
 * </p>
 * <p>
 * Author: Administrator
 * </p>
 * <p>
 * Date: 2015年7月10日
 * </p>
 */
public class LeyaHttpClientUtils {

    private static PoolingHttpClientConnectionManager connManager = null;
    private static CloseableHttpClient httpclient = null;

    /**
     * 链接超时时间 5min
     */
    public static final int connectTimeout = 1000 * 60 * 5;

    static {
        try {
            SSLContext sslContext = SSLContexts.custom().useTLS().build();
            sslContext.init(null, new TrustManager[] { new X509TrustManager() {

                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws CertificateException {
                    // TODO Auto-generated method stub

                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws CertificateException {
                    // TODO Auto-generated method stub

                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    // TODO Auto-generated method stub
                    return null;
                }
            } }, null);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                    .<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslContext)).build();

            connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            httpclient = HttpClients.custom().setConnectionManager(connManager).build();
            // Create socket configuration
            SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
            connManager.setDefaultSocketConfig(socketConfig);
            // Create message constraints
            MessageConstraints messageConstraints = MessageConstraints.custom().setMaxHeaderCount(200)
                    .setMaxLineLength(2000).build();
            // Create connection configuration
            ConnectionConfig connectionConfig = ConnectionConfig.custom()
                    .setMalformedInputAction(CodingErrorAction.IGNORE)
                    .setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
                    .setMessageConstraints(messageConstraints).build();
            connManager.setDefaultConnectionConfig(connectionConfig);
            connManager.setMaxTotal(200);
            connManager.setDefaultMaxPerRoute(20);
        } catch (KeyManagementException e) {

        } catch (NoSuchAlgorithmException e) {
        }
    }

    /**
     * 
     * <p>Description: TODO</p>
     * @param url
     * @param paramsMap
     * @return
     */
    public static BaseResponseVo sendPost(String url,Map<String, String> paramsMap){
        return sendPost(url, connectTimeout, paramsMap, LeyaConstantUtils.DEFAULT_ENCODING, HeaderContentTypeEnum.NONE);
    }
    
    /**
     * 
     * <p>Description: TODO</p>
     * @param url
     * @param paramsMap
     * @return
     */
    public static BaseResponseVo sendJsonPost(String url,Map<String, String> paramsMap){
        return sendPost(url, connectTimeout, paramsMap, LeyaConstantUtils.DEFAULT_ENCODING, HeaderContentTypeEnum.APPLICATION_JSON);
    }
    /**
     * 
     * <p>Description: 发送post请求</p>
     * @param url 请求的url
     * @param timeout 设置超时时间
     * @param paramsMap 请求的参数
     * @param encoding  设置编码格式 一般不需要设置 使用utf-8
     * @param contentType 设置请求contentType
     * @return 返回响应的 vo 
     */
    public static BaseResponseVo sendPost(String url, int timeout, Map<String, String> paramsMap, String encoding,
            HeaderContentTypeEnum contentType) {
        String responseCode = LeyaConstantUtils.FAILURE_RESPONSE;
        String responseMsg = "";
        HttpPost httpPost = new HttpPost(url);
        try {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout).setExpectContinueEnabled(false).build();
            httpPost.setConfig(requestConfig);
            setHeadContentType(httpPost, contentType);
            //设置请求参数
            setPostParams(httpPost, paramsMap);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();
                try {
                    //获得http请求状态
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (HttpStatus.SC_OK == statusCode) {
                        if (entity != null) {
                            responseMsg = EntityUtils.toString(entity, encoding);
                            responseCode = LeyaConstantUtils.SUCCESS_RESPONSE;
                        } else {
                            responseMsg = "请求返回的内容为空";
                        }
                    } else {
                        httpPost.abort();
                        responseMsg = "请求返回状态码:" + statusCode;
                    }

                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        } catch (Exception e) {
            responseMsg = "请求出错:msg"+e.getMessage();
        } finally {
            httpPost.releaseConnection();
        }
        return new BaseResponseVo(responseCode, responseMsg);
    }

    /**
     * 
     * <p>Description: TODO</p>
     * @param url
     * @return
     */
    public static BaseResponseVo invokeGet(String url){
        return invokeGet(url, null, LeyaConstantUtils.DEFAULT_ENCODING, connectTimeout);
    }
    
    /**
     * 
     * <p>Description: TODO</p>
     * @param url
     *  @param params
     * @return
     */
    public static BaseResponseVo invokeGet(String url,Map<String, String> params){
        return invokeGet(url, params, LeyaConstantUtils.DEFAULT_ENCODING, connectTimeout);
    }
    
    /**
     * 
     * <p>Description: 执行get请求</p>
     * @param url 请求url
     * @param params 请求参数
     * @param encode 编码方式
     * @param connectTimeout 超时时间
     * @return
     */
    public static BaseResponseVo invokeGet(String url, Map<String, String> params, String encode, int connectTimeout) {
        String responseString = "";
        String responseCode = LeyaConstantUtils.FAILURE_RESPONSE;
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(connectTimeout)
                .setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
        //设置参数
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        int i = 0;
        if (null != params) {
            for (Entry<String, String> entry : params.entrySet()) {
                if (i == 0 && !url.contains("?")) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                String value = entry.getValue();
                try {
                    sb.append(URLEncoder.encode(value, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
                i++;
            }
        }
       
        HttpGet getMethod = new HttpGet(sb.toString());
        getMethod.setConfig(requestConfig);
        try {
            CloseableHttpResponse response = httpclient.execute(getMethod);
            try {
                HttpEntity entity = response.getEntity();
                try {
                    if (entity != null) {
                        responseString = EntityUtils.toString(entity, encode);
                        responseCode = LeyaConstantUtils.SUCCESS_RESPONSE;
                    }
                } finally {
                    if (entity != null) {
                        entity.getContent().close();
                    }
                }
            } catch (Exception e) {
                responseString = "请求出错:msg"+e.getMessage();
            } finally {
                if (response != null) {
                    response.close();
                }
            }

        } catch (Exception e) {
            responseString = "请求出错:msg"+e.getMessage();
        } finally {
            getMethod.abort();
            getMethod.releaseConnection();
        }
        return new BaseResponseVo(responseCode,responseString);
    }

    /**
     * 
     * <p>
     * Description: 将放在map中的参数放到post请求中并按照指定UTF-8字符进行编码
     * </p>
     * 
     * @param paramsMap
     * @return
     */
    private static void setPostParams(HttpPost postMethod, Map<String, String> paramsMap) {
        List<NameValuePair> paramList = new ArrayList<NameValuePair>(0);
        if (null != paramsMap && paramsMap.size() > 0) {
            for (Entry<String, String> entry : paramsMap.entrySet()) {
                String paramsValue = entry.getValue();
                String keyValue = entry.getKey();
                if (StringUtils.isNotBlank(paramsValue)) {
                    paramList.add(new BasicNameValuePair(keyValue, paramsValue));
                }
            }
        }
        if (CollectionUtils.isNotEmpty(paramList)) {
            postMethod.setEntity(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
        }
    }

    /**
     * 
     * <p>
     * Description: 对短信内容进行编码
     * </p>
     * 
     * @param smsContent
     * @return
     */
    public static String encoderContent(String smsContent) {

        return encoderContent(smsContent, LeyaConstantUtils.DEFAULT_ENCODING);
    }

    /**
     * 
     * <p>
     * Description: 对短信内容进行编码
     * </p>
     * 
     * @param smsContent
     * @return
     */
    public static String encoderContent(String smsContent, String encoding) {
        String encoderSms;
        String encodingName = StringUtils.isBlank(encoding) ? LeyaConstantUtils.DEFAULT_ENCODING : encoding;
        try {
            encodingName = encodingName.toUpperCase();
            encoderSms = URLEncoder.encode(smsContent, encodingName);
        } catch (UnsupportedEncodingException e) {
            encoderSms = smsContent;
        }
        return encoderSms;
    }

    /**
     * 
     * <p>
     * Description: 对http请求按照指定格式设置contentType
     * </p>
     * 
     * @param httpPost
     * @param contentType
     */
    private static void setHeadContentType(HttpPost httpPost, HeaderContentTypeEnum contentType) {
        switch (contentType) {
        case APPLICATION_JSON:
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.addHeader("Accept", "application/json;charset=UTF-8");
            break;
        case APPLICATION_XML:
            httpPost.addHeader("Content-Type", "application/xml;charset=UTF-8");
            httpPost.addHeader("Accept", "application/xml;charset=UTF-8");
            break;

        case TXT_PLAIN:
            httpPost.addHeader("Content-Type", "text/plain;charset=UTF-8");
            httpPost.addHeader("Accept", "text/plain;charset=UTF-8");
            break;
        case NONE:
            break;
        }
    }
}
