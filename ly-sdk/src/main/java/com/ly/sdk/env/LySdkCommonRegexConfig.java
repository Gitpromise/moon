package com.ly.sdk.env;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2015/8/17.
 */
public class LySdkCommonRegexConfig {
    private static String mobileCheckReg = "";
    private static String emailCheckReq = "";
    private static String configFilePath = "/data/env/common_config.properties";

    private static Set<String> emailSuffixSet = new HashSet<String>(0);

    private static Properties prop = new Properties();
    static {
        InputStream in = null;
        try {
           in = new FileInputStream(new File(configFilePath));
            //in = LyServiceConfig.class.getClassLoader().getResourceAsStream(configFilePath);
            if(in!=null){
                prop.load(in);
                mobileCheckReg = prop.getProperty("mobile_check");
                emailCheckReq = prop.getProperty("email_check");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getMobileCheckReg(){
        return mobileCheckReg;
    }
    public static String getEmailCheckReq(){
        return emailCheckReq;
    }

    public static Set<String> getEmailSuffixSet() {
        if(StringUtils.isNotBlank(emailCheckReq)) {
            String[] suffixs = emailCheckReq.split(",");
            for (String suffix : suffixs) {
                emailSuffixSet.add(suffix);
            }
        }
        return emailSuffixSet;
    }

    public static String getValue(String key){
        return prop.getProperty(key,"");
    }
    public static void main(String[] args){
        LySdkCommonRegexConfig.getMobileCheckReg();
    }
}

