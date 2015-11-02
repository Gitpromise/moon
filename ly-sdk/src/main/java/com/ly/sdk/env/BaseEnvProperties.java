package com.ly.sdk.env;

import java.util.Properties;

public class BaseEnvProperties {
    protected static Properties prop = new Properties();
    
    public static String get(String key) {
        return (String) prop.get(key);
    }

    public static String getString(String key) {
        return prop.getProperty(key);
    }
}
