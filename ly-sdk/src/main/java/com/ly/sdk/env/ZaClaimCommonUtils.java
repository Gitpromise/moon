package com.ly.sdk.env;

public class ZaClaimCommonUtils {
    
    private static String key="";
    static {
        // key = ZhongAnEnvProperties.get("privateKey");
    }

    public static void main(String[] args){
        System.out.println(key);
    }
}
