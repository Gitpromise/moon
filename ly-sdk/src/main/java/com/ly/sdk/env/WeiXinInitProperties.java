package com.ly.sdk.env;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * <p>
 * ClassName: WeiXinInitProperties
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author: Administrator
 * </p>
 * <p>
 * Date: 2015年11月5日
 * </p>
 */
public class WeiXinInitProperties {

    private static String WEI_XIN_FILE = "/data/env/weixin_remind.properties";
    protected static Properties prop = new Properties();

    public static String get(String key) {
        return (String) prop.get(key);
    }

    public static String getString(String key) {
        return prop.getProperty(key);
    }

    static {
        InputStream in = null;
        try {
            File file = new File(WEI_XIN_FILE);
            if (file.exists() && !file.isDirectory()) {
                in = new FileInputStream(file);
                if (in != null) {
                    prop.load(in);

                }
            } else {
                throw new RuntimeException("not found weixin properties file :" + file.getAbsolutePath());
            }
        } catch (Exception e) {
            throw new RuntimeException("init weixin properties error :" + e.getMessage());
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
