package com.ly.sdk.utils;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 生成随机数字或字符串
 * 
 * @author Administrator
 *
 */
public class LeyaRandomUtils {
    private static final String baseNum[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    private static final String baseString[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
            "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z" };

    /**
     * 
     * <p>
     * Description: 获取随机数
     * </p>
     * 
     * @param num 想要获得的位数
     * @return 指定位数的随机数
     */
    public static int getRandomNum(int num) {
        if (num > 9) {
            throw new RuntimeException("可能会超出Integer最大值:" + Integer.MAX_VALUE);
        }
        String numStr = "";
        Boolean isZeroRepeat = Boolean.FALSE;
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                isZeroRepeat = Boolean.TRUE;
            } else {
                isZeroRepeat = Boolean.FALSE;
            }
            numStr += getOneRandomStr(baseNum, isZeroRepeat);
        }
        return Integer.parseInt(numStr);
    }

    /**
     * 
     * <p>Description: 获取随机字符串</p>
     * @param num 指定的位数
     * @return 返回随机串
     */
    public static String getRandomStr(int num) {
        String numStr = "";
        for (int i = 0; i < num; i++) {
            numStr += getOneRandomStr(baseString, Boolean.FALSE);
        }
        return numStr;
    }

    private static String getOneRandomStr(String[] baseStr, Boolean isZeroRepeat) {
        int baseNumLen = baseStr.length;
        String randomStr = baseStr[RandomUtils.nextInt(baseNumLen)];
        if (isZeroRepeat && "0".equals(randomStr)) {
            return getOneRandomStr(baseStr, isZeroRepeat);
        }
        return randomStr;
    }
    public static void main(String[] args) {
        System.out.println(getRandomNum(8));
    }
}
