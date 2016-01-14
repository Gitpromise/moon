package com.ly.sdk.env;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SmsEnvProperties  {
    private static String smsFilePath = "/data/env/sms_msg.properties";
    private static Properties prop = new Properties();
    static {
        InputStream in = null;
        try {
            File file = new File(smsFilePath);
            if (file.exists() && !file.isDirectory()) {
                in = new FileInputStream(file);
                if (in != null) {
                    prop.load(in);
                    
                }
            } else {
                throw new RuntimeException("not found sms properties file :"
                        + file.getAbsolutePath());
            }
        } catch (Exception e) {
            throw new RuntimeException("init sms properties error :"
                    + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                in = null;
            }
        }
    }
    public static String getString(String key) {
        return prop.getProperty(key);
    }
    public static String get(String key) {
        return (String) prop.get(key);
    }
}
