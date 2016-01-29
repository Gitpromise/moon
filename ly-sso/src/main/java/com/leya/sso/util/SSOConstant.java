package com.leya.sso.util;

/**
 * Created by fanshuai on 15/5/11.
 */
public class SSOConstant {

    public final static String Leya920Doamin=EnvProperties.get("leya920-domain");
    public final static String StaticDomain=EnvProperties.get("static-domain");
    public final static String MEMBER_LOGIN_COOKIE_NAME="ASFDAFAFA";
    public final static String INSTITUTION_LOGIN_COOKIE_NAME="IASFDAFAFA";
    public final  static String memberLoginUrl = "http://"+EnvProperties.get("leya920-domain")+"/login/index.htm";
    public final  static String institutionLoginUrl = "http://"+EnvProperties.get("leya920-domain")+"/front/institution/login/index.htm";
}
