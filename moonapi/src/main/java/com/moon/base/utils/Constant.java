package com.moon.base.utils;

/**
 * 系统中的常量
 * 
 * @author tocersoft
 * 
 */
public interface Constant {
	
	/**
	 * 后台管理系统admin账号
	 */
	public static final String ADMIN_USER="admin";
	/**
	 * 网站基准路径
	 */
	public static final String BASE_PATH = "BASE_PATH";
	/**
	 * 后台 当前在线员工
	 */
	public static final String CURRENT_OPERATOR = "CURRENT_OPERATOR";
	/**
	 * 当前在线的教师
	 */
	public static final String CURRENT_TEACHER="CURRENT_TEACHER";
	/**
	 * 当前在线的学生
	 */
	public static final String CURRENT_STUDENT="CURRENT_STUDENT";
	/**
	 * 操作系统名称
	 */
	public static final String OS_NAME = "OS_NAME";
	/**
	 * 前台登录用户session key
	 */
	public static final String FRONT_USER = "user";
	
	/**
	 * 前台登录会员用户session key
	 */
	public static final String FRONT_MEMER = "member";
	
	/**
	 * 前台登录专家用户session key
	 */
	public static final String FRONT_EXPERT = "expertSession";
	/**
	 * 前台登录患者用户session key
	 */
	public static final String FRONT_PATIENT = "patient";
	
	/** 前台在线机构 */
	public static final String FRONT_INSTITUTION = "INSTITUTION";
	
	/**
	 * cpu信息
	 */
	public static final String CPU_INFO = "CPU_INFO";
	/**
	 * 操作系统版本
	 */
	public static final String OS_VERSION = "OS_VERSION";
	/**
	 * jvm版本
	 */
	public static final String JAVA_VM_VERSION = "JAVA_VM_VERSION";
	/**
	 * jdk版本
	 */
	public static final String JAVA_VERSION = "JAVA_VERSION";
	/**
	 * servlet版本
	 */
	public static final String SERVLET_VERSION = "SERVLET_VERSION";
	/** 国际化 */
	public static final String WW_TRANS_I18N_LOCALE = "WW_TRANS_I18N_LOCALE";
	
	/** 数据的状态 正常*/
	public static final Integer STATE_ENABLED=1;
	
	/** 数据的状态 禁用*/
	public static final Integer STATE_DISABLED=0;

	/**
	 * 显示栏目列表排列图案
	 */
	public static final String CHANNEL_LEVEL_PIC = "|- ";

	/**
	 * HTML空白符
	 */
	public static final String HTML_BLANK = "&nbsp;";

	/**
	 * 连接符号
	 */
	public static final String SYMBOL_JOIN = "-";
	
	/**
	 * 创建人默认值
	 */
	public static final String CREATE_BY_DEFAULT = "系统创建";
	/**
	 * 更新人默认值
	 */
	public static final String UPDATE_BY_DEFAULT = "系统更新";
	
	/**
	 * 管理员ID 
	 */
	public static final String MANAGER_ADMIN_ID = "dd00e9479ed34a199281abc043003f9b";
	
	/**
	 * 网站版本号
	 */
	public static final String SYS_VERSION = "sysVersion";
	
	/**
	 * 前台登录用户session key
	 */
//	public static final String FRONT_USER = "user";
	
	/** 正序 */
	public static final String SYS_SORTY_ASC = "ASC";
	/** 倒序 */
	public static final String SYS_SORTY_DESC = "DESC";
	
	/** 
	 * 用于表示一个请求是否是ajax请求 
	 */
	public static final String XMLHTTPREQUEST = "XMLHttpRequest";
	
	/** 验证码session key* */
	public static final String CAPTCHA_CODE = "captcha_code";
	public static final String JAPTCHACODE = "JAPTCHACODE";
	/**微信验证码*/
	public static final  String JWEIXINCAPTACHA="JWEIXINCAPTACHA";
	/**后台登录账号*/
	public static final  String JWEIXINLOGINNAME="JWEIXINLOGINNAME";
	// 患者验证码
	public static final String PJAPTCHACODE = "PJAPTCHACODE";
	// 医生验证码
	public static final String EJAPTCHACODE = "EJAPTCHACODE";
	// 会员注册验证码  WWH 2015-06-25 添加
	public static final String USERREGISTERHACODE = "USERREGISTERHACODE";
	/** 手机验证码 */
	public static final String MOBILE_CAPTCHA = "MOBILE_CAPTCHA";
	/** 接收手机验证码的手机 */
	public static final String MOBILE = "MOBILE";
	/** 默认密码 */
	public static final String DEFAULTPASSWORD = "123456";
	/** 会员卡类型 */ 
	public static final String SYS_MEMBER_CARD_TYPE = "11";
	/** 和我的关系 */ 
	public static final String SYS_RELATION_AND_ME = "1";
	
	/** acess page */
	public static final String ACCESS_PAGE_URL = "ACCESS_PAGE_URL";
	
	/**机构图片位置*/
	/**二维码*/
	public static final String QR_CODE = "QR_CODE";
	/**营业执照*/
	public static final String BUSINESS_LICENSE = "BUSINESS_LICENSE";
	/**医疗机构经营许可证*/
	public static final String MEDICAL_INSTITUTIONS_BUSINESS_LICENSES = "MEDICAL_INSTITUTIONS_BUSINESS_LICENSES";
	
	/**组织机构代码证*/
	public static final String ORGANIZATION_CODE_CERTIFICATE = "ORGANIZATION_CODE_CERTIFICATE";
	
	/**税务登记证*/
	public static final String TAX_REGISTRATION_CERTIFICATE = "TAX_REGISTRATION_CERTIFICATE";
	/**社保资格证*/
	public static final String SOCIAL_SECURITY="SOCIAL_SECURITY";
	
	
	/**诊所门面*/
	public static final String CLINIC_APPEARANCE = "CLINIC_APPEARANCE";
	
	/** 前台*/
	public static final String RECEPTION = "RECEPTION";
	
	/**诊室*/
	public static final String CONSULTING_ROOM = "CONSULTING_ROOM";
	
	/**候诊区*/
	public static final String WAITING_AREA = "WAITING_AREA";
	/**放射室*/
	public static final String RADIOLOGY_ROOM = "RADIOLOGY_ROOM";
	/**综合治疗台*/
	public static final String DENTAL_UNIT = "DENTAL_UNIT";
	/**消毒室*/
	public static final String DISINFECTION_ROOM = "DISINFECTION_ROOM";
	/**其他*/
	public static final String OTHER_PHOTO = "OTHER_PHOTO";
	
	/**病情电子文档*/
	public static final String ILLNESS_WORD="ILLNESS_WORD";
	
	/**CT全景照片*/
	public static final String CT_PHOTO="CT_PHOTO";

	/**收费清单**/
	public static final String  LIST_OF_CHARGES="LIST_OF_CHARGES";

	/**发票**/
	public static final String BILL="BILL";

	/**口腔实景照片**/

	public static final String MOUTH_PIC="MOUTH_PIC";


	public static final String INSURANCE_BINDER ="INSURANCE_BINDER";
	
	/** 当前选中城市*/
	public static final String CURRENT_CITY = "CURRENT_CITY";
	/** 最近访问的城市 */
	public static final String RECENT_ACCESS_CITY_LIST = "RECENT_ACCESS_CITY_LIST";
	

	/** 微信jssdk签名*/
	public static final String JS_API_SGIN = "JS_API_SGIN";

	/**ftp基础路径 ex：http://s.f.leyatest.com***/
	public static final String FTP_BASE_PATH ="FTP_BASE_PATH";

	/**ftp基础路径 ex：http://s.f.leyatest.com***/
	public static final String MAIN_WEB_BASEPATH ="mainWeb_domain";
	/**ftp基础路径 ex：UPLOAD***/
	public static final String FTP_UPLOAD_DIR ="FTP_UPLOAD_DIR";
	/**ftp基础路径 ex：ATTACHMENTS***/
	public static final String FTP_ATTACHE_DIR ="FTP_ATTACHE_DIR";


	public static final String WEB_INF_DIR = "WEB-INF";

	public static final String IS_SUCCESS = "isSuccess";

	public static final String PIC_URL ="picUrl";

	public static final String FILESPEARATOR = "/";

	public static final String INSTITUTION_UPLLOAD = "uploadinstitution";

	public static final String USER_TEMPLANT_KEY = "USER_TEMPLANT_KEY";

	public static final String INSTITUTION_TEMPLANT_KEY = "INSTITUTION_TEMPLANT_KEY";

	public static final String IS_TEST_ENV = "is_test_environment";

	public static final String IS_SKIP_VERIFY_CODE ="is_skip_verify_code";

    String VERSION_NUMBER = "VERSION_NUMBER";
//	微信校验码 时间 常量
    String WEIXINVERIFTIME = "WEIXINVERIFTIME";

}
