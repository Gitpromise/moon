package com.leya.sso.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.leya.enitys.member.Member;
import com.leya.sso.util.SSOConstant;

/**
 * Created by fanshuai on 15/5/3.
 */
public class MemberCheckIsLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        Member loginMember = SSOMemberUtil.getMemberLoginInfoToCache(req);
        if(loginMember==null){
            res.sendRedirect(SSOConstant.memberLoginUrl);
            return false;
        }
        SSOMemberUtil.setLoginMember(loginMember);
        return true;
    }



    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        SSOMemberUtil.removeLoginMember();
    }


}
