package com.ly.test;

import org.junit.Test;

import com.ly.sdk.utils.CipherUtility;

public class CipherUtilityTest {

    @Test
    public void encryTest(){
        //CipherUtility test = new CipherUtility();
        //加密时 请确认env下有key为private的属性
       // System.out.println(CipherUtility.AES.encrypt("jdbc:mysql://127.0.0.1:3306/ly_sms?characterEncoding=UTF-8"));
       System.out.println(CipherUtility.AES.encrypt("leyaftpadmin")+"],pwd:==["+CipherUtility.AES.encrypt("leyatestftp"));
       System.out.println(CipherUtility.AES.decrypt("QWNduSrIhHTWwsG1aPX-bFQ9e85_fjEA7ItN0D1df2xB8GXooKKm3UvBrihOQvLO3Q9MyarnIIWQsYu3xDbANg"));
       System.out.println(CipherUtility.AES.decrypt("QWNduSrIhHTWwsG1aPX-bFQ9e85_fjEA7ItN0D1df2xB8GXooKKm3UvBrihOQvLO3Q9MyarnIIWQsYu3xDbANg"));
    }
}
