package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeUtils
 * @Description TODO
 * @Author liying
 * @Date 2020/4/4 6:08 PM
 * @Version 1.0
 **/
public class TimeUtils {
    public static final String formatYYmmDDHMSStr = "yyyy-MM-dd HH:mm:ss";
    public static String dateToString(Date date,String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(date);
    }

    public static Date stringToDate(String s,String formatStr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        Date date = simpleDateFormat.parse(s);
        return date;
    }

    public static final String formatHHmmStr = "HH:mm";

}
