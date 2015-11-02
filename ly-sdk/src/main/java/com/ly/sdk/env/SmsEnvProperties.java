package com.ly.sdk.env;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SmsEnvProperties extends BaseEnvProperties {
    private static String smsFilePath = "/data/env/sms_msg.properties";

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

}
