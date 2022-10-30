package com.example.learnandroidapp.utils;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtil {
    public static String getNowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
        return sdf.format(new Date());
    }
}
