package com.ly.sdk.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class LeyaDateUtils extends DateFormatUtils {

    private static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";

    private static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMMDDHHMMSSSDECOLLATOR = "yyyy/MM/dd HH:mm:ss";

    public static String getYYYYMMddStr() {

        return format(new Date(), YYYYMMDD);
    }

    public static String getYYYYMMDDHHMMSSStr() {

        return format(new Date(), YYYYMMDDHHMMSS);
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

    public static void main(String[] args) {
        System.out.println(LeyaDateUtils.parseDateStr("2015/8/4 18:35:35", new String[] { YYYY_MM_DDHHMMSS,
                YYYYMMDDHHMMSSSDECOLLATOR }));
    }
}
