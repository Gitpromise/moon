package com.ly.sdk.utils;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.ly.sdk.env.LySdkCommonRegexConfig;

/**
 * Created by Administrator on 2015/8/17.
 * 常用的后台校验正则
 */
public class CommonRegexUtils {

    /**
     * 校验是否是指定格式后缀的邮箱
     * @param emailStr 校验的字符串
     * @return true 是的 false 不是
     */
    public static Boolean isSpecialEmail(String emailStr){
        Boolean flag = false;
        try{
            //先校验是否满足邮箱格式
            Boolean isEmail = isEmail(emailStr);
            if (!isEmail){
                return Boolean.FALSE;
            }
            String emailCheckReq = LySdkCommonRegexConfig.getEmailCheckReq();
            //获取配置为空的情况下 使用 默认的邮件进行校验
            if (StringUtils.isBlank(emailCheckReq)) {
                return isEmail;
            } else {
                //校验邮箱为指定格式
                Set<String> emailSuffixSet = LySdkCommonRegexConfig.getEmailSuffixSet();
                //邮箱格式为 service@leya920.com
                int index = emailStr.lastIndexOf("@");
                //emailSuffix 形如:service  emailPrefix 形如:leya920.com
                String emailSuffix = emailStr.substring(index+1);
                String emailPrefix = emailStr.substring(0,index);
                Boolean isContaint = emailSuffixSet.contains(emailSuffix);
                if (!isContaint) {
                    return Boolean.FALSE;
                } else {
                    flag = regexStr(emailPrefix,LySdkCommonRegexConfig.getValue(LeyaConstantUtils.EMAIL_PREFIX));
                }
            }
        }catch(Exception e){
            flag = false;
        }

        return flag;
    }
    /**
     * 验证手机号码
     * @param mobileStr
     * @return  [0-9]{5,9}
     */
    public static Boolean isMobileNO(String mobileStr){
        Boolean flag = regexStr(mobileStr,LySdkCommonRegexConfig.getValue("mobile_check"));
        return flag;
    }

    /**
     * 一般的邮箱规则校验
     * @param emailStr
     * @return
     */
    public static Boolean isEmail(String emailStr){
        Boolean flag = regexStr(emailStr,LySdkCommonRegexConfig.getValue(LeyaConstantUtils.DEFAULT_EMAIL_CHECK));
        return flag;
    }

    /**
     *
     * @param regexStr 待校验的内容
     * @param regularExpression 正则表达式
     * @return
     */
    public static Boolean regexStr(String regexStr,String regularExpression){
        Boolean flag = false;
        if (StringUtils.isBlank(regexStr)||StringUtils.isBlank(regularExpression)) {
            return flag;
        }
        try{
            Pattern regex = Pattern.compile(regularExpression);
            Matcher matcher = regex.matcher(regexStr);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     *
     * @param inputValue 要校验的值
     * @param regularExpressionKey 校验正则key值
     * @return
     */
    public static Boolean checkInputValue(String inputValue,String regularExpressionKey){
        String regularExpression = LySdkCommonRegexConfig.getValue(regularExpressionKey);
        return regexStr(inputValue,regularExpression);
    }
    public static void main(String[] args){
       // System.out.println(isMobileNO("18903836972"));
       /* String emailStr = "service@leya920.com";
        int index = emailStr.lastIndexOf("@");
        String emailSuffix = emailStr.substring(index+1);
        String emailPrefix = emailStr.substring(0,index);
        System.out.println("emailSuffix="+emailSuffix+"\nemailPrefix="+emailPrefix);
        System.out.println(isSpecialEmail(emailStr));*/
       /* String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(emailStr);
        Boolean flag = matcher.matches();
        System.out.println(flag);*/
        String email = "service@leya920.com";
        System.out.println(isEmail(email));
    }
}

