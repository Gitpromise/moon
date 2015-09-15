package com.ly.test;

import org.junit.Assert;
import org.junit.Test;

import com.ly.sdk.utils.CipherUtility;
import com.ly.sdk.utils.PaAesTools;

public class CipherUtilityTest {

    @Test
    public void encryTest() {
        //CipherUtility test = new CipherUtility();
        //加密时 请确认env下有key为private的属性
        // System.out.println(CipherUtility.AES.encrypt("jdbc:mysql://127.0.0.1:3306/ly_sms?characterEncoding=UTF-8"));
        Assert.assertEquals(CipherUtility.AES.encrypt("leyaftpadmin"), "_X2iVCvx-jMc0TlK74qODw");
        Assert.assertEquals(CipherUtility.AES.encrypt("leyatestftp"), "vpb97KM2D5X_wO_BxlBMcw");
        //Assert.assertEquals(CipherUtility.AES.encrypt("leyatestftp"),"error");
    }

    /**
     * 
     * <p>
     * Description: 测试平安加解密
     * </p>
     */
    @Test
    public void paEncryTest() {
        String str = "abc";
        String paStr = "9TGDf5G+OOIxyX2wEDkjMQ==";
        // System.out.println(decryptString("9TGDf5G+OOIxyX2wEDkjMQ=="));
        Assert.assertEquals(PaAesTools.encryptString(str), paStr);
    }

}
