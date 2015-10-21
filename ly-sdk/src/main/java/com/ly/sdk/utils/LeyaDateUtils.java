package com.ly.sdk.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class LeyaDateUtils extends DateFormatUtils {

    private static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    private static final String YYYYMMDD = "yyyyMMdd";
    
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    
    public static final String YYYYMMDDSDECOLLATOR = "yyyy/MM/dd";

    public static final String YYYYMMDDHHMMSSSDECOLLATOR = "yyyy/MM/dd HH:mm:ss";
    //返回样例 2015-10-21 星期三 下午 3:30
    public static final String CHINESE_PATTERN = "yyyy-MM-dd E a h:mm";

    public static String getYYYYMMddStr() {

        return format(new Date(), YYYYMMDD);
    }

    public static String getYYYYMMDDHHMMSSStr() {

        return format(new Date(), YYYYMMDDHHMMSS);
    }
    
    /**
     * 
     * <p>Description: 返回时间格式样例</p>
     * @param pointDate 传人时间 
     * @return 返回样例 2015-10-21 星期三 下午 3:30
     */
    public static String getChinesePattern(Date pointDate) {

        return format(pointDate,CHINESE_PATTERN, Locale.CHINESE);
    }

    public static Date parseDateStr(String timeStr, String[] otherFormateStr) {
        if (StringUtils.isNotBlank(timeStr)) {
            try {
                return DateUtils.parseDate(timeStr, otherFormateStr);
            } catch (ParseException e) {
            }
        }
        return null;
    }

    public static Date parseDateStr(String timeStr, String formmateStr) {
        return parseDateStr(timeStr, new String[] { formmateStr });
    }

    public static Date parseYYYYMMDDHHMMSSStr(String timeStr) {
        return parseDateStr(timeStr, YYYYMMDDHHMMSS);
    }

    public static Date parseYYYY_MM_DDHHMMSSStr(String timeStr) {
        return parseDateStr(timeStr, YYYY_MM_DDHHMMSS);
    }

    public static Date parsePointDate(Date originDate,String hour,String minute){
        String dateStr = format(originDate, YYYY_MM_DD);
        dateStr += " "+hour+":"+minute;
        return parseDateStr(dateStr,new String[]{"yyyy-MM-dd HH:mm"});
    }
    
    
    /**
     * 
     * <p>Description: 返回当前系统时间值</p>
     * @return
     */
    public static long getCurrentSystemTime() {
        return System.nanoTime();
    }

    public static void main(String[] args) {
        Date sms = parsePointDate(new Date(),"12","01");
        System.out.println(sms);
    }
}
