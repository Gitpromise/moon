package com.tocersoft.institution.aspect.annotation;

import com.tocersoft.institution.aspect.AuthenticationRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 认证字段标注
 * 所有需要认证的字段都应该添加此标注
 * @author      miaoshuai
 * @email       miaoshuai@tocersfot.com
 * @company		www.tocersoft.com
 * @create-time 2015年3月24日 上午10:55:11
 * @version     1.0
 */
@Target(value = ElementType.FIELD)			// 限制注解类型只能作用于方法
@Retention(RetentionPolicy.RUNTIME)			// 注解声明周期:SOURCE-源文件有效 CLASS-class文件有效 RUNTIME-运行时有效
public @interface AuthenticationField {
	
	/**
	 * 认证类型
	 * @return
	 */
	AuthenticationRule rule();
}
