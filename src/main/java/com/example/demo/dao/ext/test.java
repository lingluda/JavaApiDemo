package com.example.demo.dao.ext;

import com.example.demo.util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static String ints(int i) {
        String code = null;
        if (i <= 499) {
            code = "0-499";
        } else if (i > 499 & i <= 999) {
            code = "499-999";
        } else if (i > 999 & i <= 1999) {
            code = "999-1999";
        } else if (i > 2000) {
            code = "2000";
        }
        return code;
    }

    public static String str(String l) {
        return l;
    }

    public static String date(String d) {
        Date f = null;
        String dfg = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            f = sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            dfg = String.valueOf(TimeUtil.getDiffDays(f, new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dfg;
    }

    public static void main(String[] args) {
        System.out.println(date("2018-06-02"));
    }
}
