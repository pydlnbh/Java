package com.se.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/26
 * @Description: com.java.se.common.Date
 */
public class TestDate {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("y-M-d H:m:s");
        // 将Date类按照上面规范转换为字符串格式
        String format = sdf.format(date);
        String format1 = sdf1.format(date);
        System.out.println(format);
        System.out.println(format1);

        // 将字符串转换成对应的Date
        try {
            Date d = sdf.parse("2020-11-10 12:12:30");
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        System.out.println(c);
    }
}
