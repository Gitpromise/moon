package com.leya.sso.institution;

import com.leya.sso.util.CookieUtil;
import com.leya.sso.util.EnvProperties;
import com.leya.sso.util.SSOConstant;
import com.leya.util.memcache.client.CacheClient;
import com.tocersoft.institution.entity.Institution;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanshuai on 15/5/23.
 */
public class SSOInsitutionUtil {
    private static final ThreadLocal<Institution> loginInstitution = new ThreadLocal();

    public static void setInstitutionLoginInfoToCache(HttpServletRequest req,HttpServletResponse res,Institution institution){
        try {
            Cookie cookie = CookieUtil.getCookie(SSOConstant.INSTITUTION_LOGIN_COOKIE_NAME, req.getCookies());
            if(cookie==null){
                cookie = new Cookie(SSOConstant.INSTITUTION_LOGIN_COOKIE_NAME,"");
            }
            String remoteIp = req.getRemoteAddr();
            String memberLoginCookieValue = CookieUtil.getInstitutionLoginCookieValue(remoteIp, institution.getId());
            cookie.setValue(memberLoginCookieValue);
            cookie.setMaxAge(60*60);
            cookie.setDomain(EnvProperties.get("ssoDomain"));
            cookie.setPath("/");
            res.addCookie(cookie);
            CacheClient.put(CookieUtil.getInstitutionLoginMemcacheKey(remoteIp, memberLoginCookieValue), institution, 1800);
            setLoginInstitution(institution);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Institution getInstitutionLoginInfoToCache(HttpServletRequest req){
        try {
            Cookie cookie = CookieUtil.getCookie(SSOConstant.INSTITUTION_LOGIN_COOKIE_NAME, req.getCookies());
            if(cookie==null){
                return null;
            }
            String remoteIp = req.getRemoteAddr();
            String memberLoginCookieValue = cookie.getValue();
            Institution institution = (Institution)CacheClient.get(CookieUtil.getInstitutionLoginMemcacheKey(remoteIp, memberLoginCookieValue));
            return institution;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void remoteInstitutionLoginInfoToCache(HttpServletRequest req){
        try {
            Cookie cookie = CookieUtil.getCookie(SSOConstant.INSTITUTION_LOGIN_COOKIE_NAME, req.getCookies());
            if(cookie==null){
                return ;
            }
            String remoteIp = req.getRemoteAddr();
            String memberLoginCookieValue = cookie.getValue();
            CacheClient.remove(CookieUtil.getInstitutionLoginMemcacheKey(remoteIp, memberLoginCookieValue));
            removeLoginInstitution();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Institution getLoginInstitution(){
        return loginInstitution.get();
    }
    public static void setLoginInstitution(Institution Institution){
        loginInstitution.set(Institution);
    }
    public static void removeLoginInstitution(){
        loginInstitution.remove();
    }
}
