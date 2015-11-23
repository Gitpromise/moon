package com.ly.sdk.env;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ZhongAnEnvProperties {

    private static final String FILE_NAME ="prop/za.properties";
    private static Properties prop = new Properties();
    
    public static String getString(String key) {
        if(prop.isEmpty()){
            initPropertiesFile();
        }
        return prop.getProperty(key);
    }
    private static void initPropertiesFile(){
        if(prop.isEmpty()){
            synchronized (ZhongAnEnvProperties.class) {
                if (prop.isEmpty()) {
                    InputStream in = ZhongAnEnvProperties.class.getClassLoader().getResourceAsStream(FILE_NAME);
                    try {
                        prop.load(in);
                    } catch (IOException e) {
                       
                    }finally{
                        try {
                            if(null !=in){
                                in.close(); 
                            }
                        } catch (IOException e) {
                        }
                    } 
                }
            }
        }
        
    }
    
}
