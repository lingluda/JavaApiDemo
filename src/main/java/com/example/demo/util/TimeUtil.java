package com.example.demo.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Administrator on 2017/8/23.
 */
public class TimeUtil {

    public static void main(String[] args) throws ParseException {
        //System.out.print(getDaysOfMonth(DateUtils.parseDate("2016-02", "yyyy-MM")));
        //System.out.print(getFirstDayOfMonth(2017, 03));
    }

    /**
     * 获取此日期月的第一天  如传入2017 08  返回2017-08-01
     *
     * @param year
     * @param month
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 获取此日期月的第一天  如传入2017 08  返回2017-08-31
     *
     * @param year
     * @param month
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 获取此日期月的第一天  如传入2017-08  返回2017-08-01
     *
     * @param date
     */
    public static String getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
    }

    /**
     * 获取此日期月的第一天  如传入2017-08  返回2017-08-31
     *
     * @param date
     */
    public static String getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
    }

    /**
     * 返回此日期月的真实最大天数
     *
     * @param date
     */
    public static int getDaysOfMonth(Date date) {
        int day = 0;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        return day;
    }

    /**
     * 获取时间的天数部分
     *
     * @param date
     * @author fww
     */
    public static int getDay(Date date) {
        int day = 0;
        if (date != null) {
            Calendar birthCal = Calendar.getInstance();
            birthCal.setTime(date);
            day = birthCal.get(Calendar.DAY_OF_MONTH);
        }
        return day;
    }

    /**
     * 获取时间的小时部分
     *
     * @param date
     * @author fww
     */
    public static int getHour(Date date) {
        int hour = 0;
        if (date != null) {
            Calendar birthCal = Calendar.getInstance();
            birthCal.setTime(date);
            hour = birthCal.get(Calendar.HOUR_OF_DAY);
        }
        return hour;
    }

    /**
     * 获取时间的分钟部分
     *
     * @param date
     * @author fww
     */
    public static int getMinute(Date date) {
        int minute = 0;
        if (date != null) {
            Calendar birthCal = Calendar.getInstance();
            birthCal.setTime(date);
            minute = birthCal.get(Calendar.MINUTE);
        }
        return minute;
    }

    /**
     * 获取日期相隔天数
     *
     * @param dt1
     * @param dt2
     * @return
     */
    public static int getDiffDays(Date dt1, Date dt2) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date tmp1 = sdf.parse(sdf.format(dt1));
        Date tmp2 = sdf.parse(sdf.format(dt2));
        long diff = Math.abs(tmp1.getTime() - tmp2.getTime());
        long days = (diff / (1000 * 60 * 60 * 24));
        return (int) days;
    }

    /**
     * 给日期添加天
     *
     * @param dt
     * @param days
     * @return
     */
    public static Date addDays(Date dt, Integer days) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(dt);
        ca.add(Calendar.DAY_OF_MONTH, days);
        return ca.getTime();
    }

    /**
     * unix时间戳（秒）转时间
     *
     * @param times
     * @return
     */
    public static Date getDateFromSecond(long times) {
        return new Date(times * 1000);
    }

    /**
     * unix时间戳（毫秒）
     *
     * @param times
     * @return
     */
    public static Date getDateFromMillionSecond(long times) {
        return new Date(times);
    }

    /**
     * 时间格式化字符串
     *
     * @param dt
     * @param formate
     * @return
     */
    public static String dateFormate(Date dt, String formate) {
        if (dt == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(dt);
    }

    /**
     * 从导入Excel获取日期
     *
     * @param dt
     * @return
     */
    public static Date getDateFromExcelString(String dt) {
        Integer days = Integer.parseInt(dt);
        Calendar c = new GregorianCalendar(1900, 0, -1);
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTime();
    }

    /**
     * 从格式化后的字符串解析时间
     *
     * @param dt      格式化时间字符串
     * @param formate 时间格式
     * @return
     */
    public static Date getDateFromFormateString(String dt, String formate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formate);
            return sdf.parse(dt);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 间隔天数
     *
     * @param begin
     * @param end
     * @author fww
     */
    public static int differentDays(String begin, String end) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = format.parse(begin);
            endDate = format.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getDiffDay(beginDate, endDate);
    }

    public static int getDiffDay(Date beginDate, Date endDate) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(beginDate);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endDate);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {
            return day2 - day1;
        }
    }

    //由出生日期获得年龄
    public static int getAge(Date birthDay) {
        try {
            Calendar cal = Calendar.getInstance();
            if (cal.before(birthDay)) {
                throw new IllegalArgumentException(
                        "The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);
            int monthNow = cal.get(Calendar.MONTH);
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
            cal.setTime(birthDay);
            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH);
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
            int age = yearNow - yearBirth;
            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) age--;
                } else {
                    age--;
                }
            }
            return age;
        } catch (Exception ex) {
        }
        return 1;
    }

    /**
     * 从数据库获取时间字符串
     *
     * @param dtdb
     * @param formate
     * @return
     */
    public static String getDtFromDbDate(Object dtdb, String formate) {
        if (dtdb == null) return "";
        if(formate==null){
            formate="yyyy-MM-dd HH:mm";
        }
        Date dt = TimeUtil.getDateFromFormateString(dtdb + "", formate);
        return new SimpleDateFormat(formate).format(dt);
    }

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    public static int getDiffSecond(Date dt1, Date dt2) {
        long diff = Math.abs(dt1.getTime() - dt2.getTime());
        long seconds = diff / 1000;
        return (int) seconds;
    }
}
