package com.ly.sdk.patools;

import java.security.MessageDigest;

import com.ly.sdk.utils.LeyaConstantUtils;

public class PaMd5Tools {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return resultString;
    }
    /**
     * 
     * <p>Description: 使用UTF-8进行编码MD5加密(平安MD5加密请使用此方法)</p>
     * @param origin 加密的字符串
     * @return 返回加密后的字符串
     */
    public static String MD5EncodeUtf8(String origin){
        return MD5Encode(origin,LeyaConstantUtils.DEFAULT_ENCODING);
    }
    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

}
