package com.develop.manual.question02;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 小写y和大写Y对比
 */
public class SimpleDateFormatDemo {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY");
        String format = sdf1.format(sdf.parse("2021-12-25"));
        String format1 = sdf1.format(sdf.parse("2021-12-36"));
        // WeekYear 2021
        System.out.println(format);
        // 2022
        System.out.println(format1);

        // 美国纽约时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        String date = simpleDateFormat.format(Calendar.getInstance().getTime());
        System.out.println(date);

        // 使用DateTimeFormatter解析日期
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("YYYY");
        System.out.println(dtf1.format(dtf.parse("2021-12-29")));
    }
}
