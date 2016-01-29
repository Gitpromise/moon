package com.ly.test;

import org.junit.Test;

import com.ly.sdk.env.FtpProperties;

public class PropertiesTest {

    @Test
    public void testFtpClient(){
        System.out.println(FtpProperties.getString("ftp.password"));
    }
}
