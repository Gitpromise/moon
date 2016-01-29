package com.leya.sso.util;

import javax.servlet.http.Cookie;
import java.util.Random;

/**
 * Created by fanshuai on 15/5/11.
 */
public class CookieUtil {

    public static  Cookie getCookie(String cookieName,Cookie[] cookies){
        if(cookieName==null){
            return null;
        }
        if (cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie:cookies){
            if(cookieName.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }

    public static String getMemberLoginCookieValue(String ip,String userId){

        return ip+"_m_"+userId+"_"+(new Random().nextInt(999999));
    }
    public static String getMemberLoginMemcacheKey(String ip,String cookieValue){

        return ip+"_m_"+cookieValue;
    }

    public static String getInstitutionLoginCookieValue(String ip,String userId){

        return ip+"_m_"+userId+"_"+(new Random().nextInt(999999));
    }
    public static String getInstitutionLoginMemcacheKey(String ip,String cookieValue){

        return ip+"_i_"+cookieValue;
    }
}
