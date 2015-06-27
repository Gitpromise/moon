package com.leya.sso.institution;

import com.leya.sso.member.SSOMemberUtil;
import com.leya.sso.util.SSOConstant;
import com.tocersoft.institution.entity.Institution;
import com.tocersoft.member.entity.Member;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanshuai on 15/5/3.
 */
public class InstitutionCheckIsLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object o) throws Exception {
        Institution loginInstitution = SSOInsitutionUtil.getInstitutionLoginInfoToCache(req);
        if(loginInstitution==null){
            res.sendRedirect(SSOConstant.institutionLoginUrl);
            return false;
        }
        SSOInsitutionUtil.setLoginInstitution(loginInstitution);
        return true;
    }



    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        SSOInsitutionUtil.removeLoginInstitution();
    }


}
