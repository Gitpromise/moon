package com.leya.sso.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leya.dto_V2.LoginUserDto;
import com.leya.enitys.member.Member;
import com.leya.sso.util.CookieUtil;
import com.leya.sso.util.EnvProperties;
import com.leya.sso.util.SSOConstant;
import com.leya.util.memcache.client.CacheClient;

/**
 * Created by fanshuai on 15/5/12.
 */
public class SSOMemberUtil {
    private static final ThreadLocal<LoginUserDto> loginMember= new ThreadLocal<LoginUserDto>();

    public static void setMemberLoginInfoToCache(HttpServletRequest req,HttpServletResponse res,LoginUserDto loginUser){
        try {
            Cookie cookie = CookieUtil.getCookie(SSOConstant.MEMBER_LOGIN_COOKIE_NAME, req.getCookies());
            if(cookie==null){
                cookie = new Cookie(SSOConstant.MEMBER_LOGIN_COOKIE_NAME,"");
            }
            String remoteIp = req.getRemoteAddr();
            String memberLoginCookieValue = CookieUtil.getMemberLoginCookieValue(remoteIp,loginUser.getLoginUserMasterId());
            cookie.setValue(memberLoginCookieValue);
            cookie.setMaxAge(60*60);
            cookie.setDomain(EnvProperties.get("ssoDomain"));
            cookie.setPath("/");
            res.addCookie(cookie);
            CacheClient.put(CookieUtil.getMemberLoginMemcacheKey(remoteIp,memberLoginCookieValue), loginUser, 1800);
            loginMember.set(loginUser);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static LoginUserDto getMemberLoginInfoToCache(HttpServletRequest req){
        try {
            Cookie cookie = CookieUtil.getCookie(SSOConstant.MEMBER_LOGIN_COOKIE_NAME, req.getCookies());
            if(cookie==null){
                return null;
            }
            String remoteIp = req.getRemoteAddr();
            String memberLoginCookieValue = cookie.getValue();
            LoginUserDto member = (LoginUserDto)CacheClient.get(CookieUtil.getMemberLoginMemcacheKey(remoteIp, memberLoginCookieValue));
            return member;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void remoteMemberLoginInfoToCache(HttpServletRequest req){
        try {
            Cookie cookie = CookieUtil.getCookie(SSOConstant.MEMBER_LOGIN_COOKIE_NAME, req.getCookies());
            if(cookie==null){
                return ;
            }
            String remoteIp = req.getRemoteAddr();
            String memberLoginCookieValue = cookie.getValue();
            CacheClient.remove(CookieUtil.getMemberLoginMemcacheKey(remoteIp, memberLoginCookieValue));
            loginMember.remove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static LoginUserDto getLoginMember(){
        return loginMember.get();
    }
    public static void setLoginMember(LoginUserDto member){
        loginMember.set(member);
    }
    public static void removeLoginMember(){
        loginMember.remove();
    }
}
