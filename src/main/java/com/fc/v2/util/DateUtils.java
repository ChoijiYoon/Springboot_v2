package com.fc.v2.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.NumberUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;

/**
 * 日期工具类
 *
 * @author healy
 */
public class DateUtils {
    /**
     * yyyy
     */
    public static final String E_YEAR = "yyyy";
    /**
     * MM
     */
    public static final String E_ONLY_MONTH = "MM";
    /**
     * dd
     */
    public static final String E_ONLY_DATE = "dd";
    /**
     * yyyy-MM
     */
    public static final String E_MONTH = "yyyy-MM";
    /**
     * yyyy-MM-dd
     */
    public static final String E_DATE = "yyyy-MM-dd";
    /**
     * yyyy/MM/dd
     */
    public static final String E_SLASH_DATE = "yyyy/MM/dd";

    /**
     * yyyy/MM/dd HH:mm:ss
     */
    public static final String E_SLASH_DATE_TIME = "yyyy/MM/dd HH:mm:ss";

    public static final String ADMIN_E_DATE = "MM/dd/yyyy";
    /**
     * yyyy.MM.dd
     */
    public static final String APP_E_DATE = "yyyy.MM.dd";

    /**
     * yyyy-MM-ddHH:mm:ss
     */
    public static final String E_DATE_TIME_SEC_NO_SPACE = "yyyy-MM-ddHH:mm:ss";

    public static final String ADMIN_E_DATE_SEC = "MM/dd/yyyy HH:mm:ss";
    /**
     * yyyy-MM-dd a hh:mm:ss
     */
    public static final String E_DATE_A_TIME_SEC = "yyyy-MM-dd a hh:mm:ss";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String E_DATE_TIME = "yyyy-MM-dd HH:mm";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String E_DATE_TIME_H = "yyyy-MM-dd HH";
    /**
     * 今天 HH:mm
     */
    public static final String TODAY_TIME = "今天 HH:mm";
    /**
     * 明天 HH:mm
     */
    public static final String TOMORROW_TIME = "明天 HH:mm";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String APP_E_DATE_TIME = "yyyy.MM.dd HH:mm";
    /**
     * HH:mm
     */
    public static final String E_TIME = "HH:mm";
    /**
     * HH:mm:ss
     */
    public static final String E_TIME_SEC = "HH:mm:ss";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String E_DATE_TIME_SEC = "yyyy-MM-dd HH:mm:ss";
    /**
     * yyyy-MM-ddHH:mm:ss
     */
    public static final String E_DATE_YMD = "yyyy.MM.dd";
    /**
     * yyyy.MM.dd HH:mm:ss
     */
    public static final String APP_E_DATE_TIME_SEC = "yyyy.MM.dd HH:mm:ss";
    /**
     * yyyy年MM月dd日
     */
    public static final String C_DATE = "yyyy年MM月dd日";
    /**
     * yyyy年MM月dd日
     */
    public static final String C_DATE_MONTH = "yyyy年MM月";
    /**
     * yyyy年MM月dd日
     */
    public static final String C_DATE_DATE = "dd日";
    /**
     * MM月dd日
     */
    public static final String C_MONTH_DATE = "MM月dd日";
    /**
     * MM月dd日 HH:mm:ss
     */
    public static final String C_MONTH_DATE_TIME = "MM月dd日 HH:mm:ss";

    /**
     * MM月dd日 HH:mm:ss
     */
    public static final String C_YEAR_MONTH_DATE_TIME = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * MM月dd日 HH:mm
     */
    public static final String C_MONTH_DATE_TIME_TO_MINUTE = "MM月dd日 HH:mm";
    /**
     * yyyy年MM月dd日 HH时mm分
     */
    public static final String C_DATE_TIME = "yyyy年MM月dd日 HH时mm分";
    /**
     * yyyy年MM月dd日 HH时mm分ss秒
     */
    public static final String C_DATE_TIME_SEC = "yyyy年MM月dd日 HH时mm分ss秒";
    /**
     * yyyyMMddHHmmss
     */
    public static final String DATE_TIME_SEC = "yyyyMMddHHmmss";
    /**
     * yyyyMMdd
     */
    public static final String DATE_TIME = "yyyyMMdd";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String E_DATE_TIME_MIN = "yyyy-MM-dd HH:mm";
    /**
     * MM-dd HH:mm
     */
    public static final String E_DATE_MIN = "MM-dd HH:mm";
    /**
     * MM.dd HH:mm
     */
    public static final String APP_E_DATE_MIN = "MM.dd HH:mm";
    /**
     * MM.dd
     */
    public static final String E_DATE_MM_DD = "MM.dd";
    /**
     * yyyy-MM-dd HH:mm:ss
     */
    public static final String EC_DATE_TIME_SEC = "yyyy-MM-dd HH:mm:ss";

    public static final String E_SHORT_DATE = "MM/dd";

    public static final String DATE_SHORT_TIME = "MM-dd";

    /**
     * 格式化, 如 9/3 12:00
     */
    public static final String E_SHORT_DATE_TIME = "M/d HH:mm";
    /**
     * gitlab -api时间格式
     */
    public static final String GIT_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    /**
     * 中文数字
     */
    private static final String[] CN_NUMBER_NAME = {"〇", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    private static final String E_DATE_TIME_MILL = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * yyyy/MM/dd HH:mm:ss.SSS
     */
    private static final String E_SLASH_DATE_TIME_MILL = "yyyy/MM/dd HH:mm:ss.SSS";
    /**
     * yyyy.MM.dd HH:mm:ss.SSS
     */
    private static final String APP_E_DATE_TIME_MILL = "yyyy.MM.dd HH:mm:ss.SSS";
    /**
     * yyyyMMdd HH:mm:ss.SSS
     */
    private static final String DATE_TIME_MILL = "yyyyMMdd HH:mm:ss.SSS";
    /**
     * excel导入支持的时间格式
     */
    public static final String[] EXCEL_DATE_FORMAT = {E_DATE, E_SLASH_DATE, APP_E_DATE, DATE_TIME,
            E_DATE_TIME_MILL, E_SLASH_DATE_TIME_MILL, APP_E_DATE_TIME_MILL, DATE_TIME_MILL};
    /**
     * excel导入时用户自定义格式的需要特殊处理
     */
    private static final List<String> EXCEL_DATE_FORMAT_SPECIAL = new ArrayList<>(4);
    static {
        EXCEL_DATE_FORMAT_SPECIAL.add(E_DATE_TIME_MILL);
        EXCEL_DATE_FORMAT_SPECIAL.add(E_SLASH_DATE_TIME_MILL);
        EXCEL_DATE_FORMAT_SPECIAL.add(APP_E_DATE_TIME_MILL);
        EXCEL_DATE_FORMAT_SPECIAL.add(DATE_TIME_MILL);
    }

    private static final ThreadLocal<Map<String, DateFormat>> THREAD_LOCAL = new ThreadLocal<>();

    public static DateFormat getDateFormat(String format) {
        Map<String, DateFormat> df = THREAD_LOCAL.get();
        if (df == null) {
            df = new HashMap<>();
        }
        DateFormat dateFormat = df.get(format);
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat(format);
            df.put(format, dateFormat);
            THREAD_LOCAL.set(df);
        }
        return dateFormat;
    }

    /**
     * 格式化日期：采用"yyyy-MM-dd"格式
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, null);
    }

    /**
     * 格式化日期：如果format为空，默认采用"yyyy-MM-dd"格式
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (StringUtils.isBlank(format)) {
            format = E_DATE;
        }

        if (date != null) {
            return getDateFormat(format).format(date);
        } else {
            return null;
        }
    }

    public static String format(Long date, String format) {
        if (StringUtils.isBlank(format)) {
            format = E_DATE;
        }

        if (date != null && date > 0) {
            return getDateFormat(format).format(getTenLengthDate(date));
        } else {
            return "";
        }
    }

    /***
     * 获取几天前或者一定天数范围内的日期
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar no = Calendar.getInstance();
        no.setTime(d);
        no.set(Calendar.DATE, no.get(Calendar.DATE) - day);
        return no.getTime();
    }

    /***
     * 获取几年前
     * @param d
     * @param year
     * @return
     */
    public static Date getYearBefore(Date d, int year) {
        Calendar no = Calendar.getInstance();
        no.setTime(d);
        no.set(Calendar.YEAR, no.get(Calendar.YEAR) - year);
        return no.getTime();
    }

    /**
     * 获取一定时间单位 前 的时间
     *
     * @param unit    单位 年、月、日、时、分、秒
     * @param d       当前时间
     * @param timeNum 时间跨度
     * @return
     */
    public static Date getTimeBefore(int unit, Date d, int timeNum) {
        Calendar no = Calendar.getInstance();
        no.setTime(d);
        no.set(unit, no.get(unit) - timeNum);
        return no.getTime();
    }

    /***
     * 获取几天后或者一定天数范围内的日期
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar no = Calendar.getInstance();
        no.setTime(d);
        no.set(Calendar.DATE, no.get(Calendar.DATE) + day);
        return no.getTime();
    }

    public static String monthFormat(Date date, String format) {
        if (StringUtils.isBlank(format)) {
            format = E_DATE;
        }

        if (date != null) {
            return getDateFormat(format).format(date);
        } else {
            return null;
        }
    }

    /**
     * 格式化当前日期:如果format为空，默认采用"yyyy-MM-dd"格式
     *
     * @param format
     * @return
     */
    public static String formatCurrDate(String format) {
        return format(new Date(), format);
    }

    /**
     * 将日期字符串转换成日期对象
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String date) {
        return parseDate(date, E_DATE);
    }

    public static Date parseDate(String date, String format) {
        if (StringUtils.isBlank(format)) {
            format = E_DATE;
        }
        try {
            if (StringUtils.isBlank(date) || "null".equalsIgnoreCase(date) || "undefined".equalsIgnoreCase(date)) {
                return null;
            }
            return getDateFormat(format).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获得当前日期起始时间  2014-12-31 00:00:00 000
     *
     * @param date
     * @return
     */
    public static Date getDateStart(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获得当前日期末尾结束时间  2014-12-31 23:59:59 499
     *
     * @param date
     * @return
     */
    public static Date getDateEnd(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 499);
        return calendar.getTime();
    }

    /**
     * 在指定日期上增加小时
     *
     * @param date
     * @param hour
     * @return
     */
    public static Date addHours(Date date, int hour) {
        return addCalendars(date, hour, Calendar.HOUR);
    }

    /**
     * 在指定日期上增加分
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinute(Date date, int minute) {
        return addCalendars(date, minute, Calendar.MINUTE);
    }

    /**
     * 在指定日期上增加月
     * 1.31+1=3.03
     *
     * @param date
     * @param month
     * @return
     */
    public static Date addMonths(Date date, int month) {
        return addCalendars(date, month, Calendar.MONTH);
    }

    /**
     * @param date
     * @param month
     * @return
     * @throws
     * @Description: 在指定日期上增加月
     * 1.31+1=2.28
     * @author xiang
     * @date 2018年5月17日 上午10:57:11
     */
    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }


    /**
     * @param date
     * @param year
     * @return
     * @throws
     * @Description: 在指定日期上增加年
     * 1.31+1=2.28
     * @author xiang
     * @date 2018年5月17日 上午10:57:11
     */
    public static Date addYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * @param date         计算的时间
     * @param count        需要处理的数量
     * @param calendarType 计算的日期的类型，如：Calendar.MONTH， Calendar.HOUR
     * @return
     * @throws
     * @Description: 计算日期
     * @author zgjs
     * @date 2015年10月10日 下午2:11:00
     */
    public static Date addCalendars(Date date, int count, int calendarType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendarType, calendar.get(calendarType) + count);
        return calendar.getTime();
    }

    /**
     * @Description 获取当前时间的字符--精确到分 用于记录日志
     * @Return java.lang.String
     * @Author
     * @Date 2020/4/9 22:42
     */
    public static String getNowStr() {
        return DateUtils.format(new Date(), DateUtils.E_DATE_TIME_MIN);
    }

    /**
     * 在指定日期上增加天数
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDays(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date addWorkDays(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 499);
        if (day > 0) {
            for (int i = 0; i < day; i++) {
                //把源日期加一天
                cal.add(Calendar.DAY_OF_MONTH, 1);
                //检查是否是周六周日
                if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    i--;
                }
            }
        } else {
            for (int i = 0; i > day; i--) {
                //把源日期加一天
                cal.add(Calendar.DAY_OF_MONTH, -1);
                //检查是否是周六周日
                if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    i++;
                }
            }
        }
        return cal.getTime();
    }

    /**
     * 获取当前日期是星期几
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        if (date == null) {
            return null;
        }
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }

        return weekDays[w];
    }

    public static String getWeekOfDate2(Date date) {
        if (date == null) {
            return null;
        }
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }

        return weekDays[w];
    }

    /**
     * @param date
     * @throws
     * @Description: 获取当前时间在该周的第几天
     * @author xiang
     * @date 2023/2/17 13:57
     */
    private static Integer getDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return w;
    }

    /**
     * @return
     * @throws
     * @Description: 获取本周几的日期
     * @author jinwp
     * @date 2016年9月12日 下午1:59:49
     */
    public static Date getWeekDay(int week) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, week);
        return cal.getTime();
    }

    /**
     * @return
     * @throws
     * @Description: 获取本月第一天的日期
     * @author jinwp
     * @date 2016年9月12日 下午2:02:55
     */
    public static Date getStartMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * @return
     * @throws
     * @Description: 获取本月最后一天的日期
     * @author jinwp
     * @date 2016年9月12日 下午2:03:45
     */
    public static Date getEndMonthDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * @param date
     * @return
     * @throws
     * @Description: 获取某天的当月开始第一天
     * @author xiang
     * @date 2016年10月18日 下午5:30:51
     */
    public static Date getStartMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * @param date
     * @return
     * @throws
     * @Description: 获取某天的当月最后一天
     * @author xiang
     * @date 2016年10月18日 下午5:30:51
     */
    public static Date getEndMonthDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * @param date
     * @return
     * @throws
     * @Description: 获取当前周的第一天
     * @author xiang
     * @date 2016年10月11日 上午10:46:43
     */
    public static String getStartWeekDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        if (getWeekOfDate(date) == "星期日") {
            cal.add(Calendar.WEEK_OF_YEAR, -1);
        }
        return format(cal.getTime(), E_DATE);
    }

    /**
     * @param date
     * @return
     * @throws
     * @Description: 获取当前周的第一天
     * @author xiang
     * @date 2016年10月11日 上午10:46:43
     */
    public static Date getWeekStartDateOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        if (getWeekOfDate(date) == "星期日") {
            cal.add(Calendar.WEEK_OF_YEAR, -1);
        }
        return cal.getTime();
    }

    /**
     * 获取当前时间是第几周
     *
     * @return
     */
    public static Integer getWeek() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * @param date
     * @return
     * @throws
     * @Description: 获取当前周的最后一天
     * @author xiang
     * @date 2016年10月11日 上午10:46:43
     */
    public static String getEndWeekDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        if (getWeekOfDate(date) != "星期日") {
            cal.add(Calendar.WEEK_OF_YEAR, 1);
        }
        return format(cal.getTime(), E_DATE);
    }

    /**
     * @param date
     * @return
     * @throws
     * @Description: 获取当前周的最后一天
     * @author xiang
     * @date 2016年10月11日 上午10:46:43
     */
    public static Date getWeekEndDateOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        if (getWeekOfDate(date) != "星期日") {
            cal.add(Calendar.WEEK_OF_YEAR, 1);
        }
        return cal.getTime();
    }

    /**
     * @param date
     * @param format
     * @return
     * @throws
     * @Description: 获取当前周的第一天
     * @author xiang
     * @date 2016年10月11日 上午10:46:43
     */
    public static String getStartWeekDate(Date date, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        if (getWeekOfDate(date) == "星期日") {
            cal.add(Calendar.WEEK_OF_YEAR, -1);
        }
        if (format == null) {
            format = E_DATE;
        }
        return format(cal.getTime(), format);
    }

    /**
     * @param date
     * @param format
     * @return
     * @throws
     * @Description: 获取当前周的最后一天
     * @author xiang
     * @date 2016年10月11日 上午10:46:43
     */
    public static String getEndWeekDate(Date date, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        if (getWeekOfDate(date) != "星期日") {
            cal.add(Calendar.WEEK_OF_YEAR, 1);
        }
        if (format == null) {
            format = E_DATE;
        }
        return format(cal.getTime(), format);
    }

    /**
     * @param dates
     * @param isMax
     * @return
     * @throws
     * @Description: 获取最大时间或最小时间
     * @author jinwp
     * @date 2016年12月18日 上午10:26:42
     */
    public static Date getDate(List<Date> dates, boolean isMax) {
        if (CollectionUtils.isEmpty(dates)) {
            return null;
        }
        Date returnDate = null;
        for (Date date : dates) {
            if (returnDate == null) {
                returnDate = date;
            } else {
                if (isMax) {
                    if (returnDate.before(date)) {
                        returnDate = date;
                    }
                } else {
                    if (returnDate.after(date)) {
                        returnDate = date;
                    }
                }
            }
        }
        return returnDate;
    }

    /**
     * @param date1
     * @param date2
     * @return
     * @throws
     * @Description: 获得2个日期的天数差，忽略时分秒
     * @author zgjs
     * @date 2018年1月10日 下午2:03:54
     */
    public static long getDaySpace(Date date1, Date date2) {
        long result = 0;
        if (date1 != null && date2 != null) {
            date1 = getDateStart(date1);
            date2 = getDateStart(date2);

            long time1 = date1.getTime();
            long time2 = date2.getTime();

            result = Math.abs((time2 - time1) / (1000 * 3600 * 24));
        }
        return result;
    }

    /**
     * @param startDate
     * @param endDate
     * @return
     * @throws
     * @Description: 获得2个日期的天数差，忽略时分秒
     * @author zgjs
     * @date 2018年1月10日 下午2:03:54
     */
    public static long getSpaceDays(Date startDate, Date endDate) {
        long result = 0;
        if (startDate != null && endDate != null) {
            startDate = getDateStart(startDate);
            endDate = getDateStart(endDate);

            long time1 = startDate.getTime();
            long time2 = endDate.getTime();

            result = (time2 - time1) / (1000 * 3600 * 24);
        }

        return result + 1;

    }


    /**
     * @param date
     * @throws
     * @Description: 获取当前时间戳（10位）
     * @author xiang
     * @date 2019/7/5 13:56
     */
    public static Long getTenLengthTime(Date date) {
        if (date == null) {
            return System.currentTimeMillis() / 1000;
        }
        return date.getTime() / 1000;
    }

    public static Long getLengthTime(Date date) {
        if (date == null) {
            return System.currentTimeMillis();
        }
        return date.getTime();
    }

    /**
     * @Description 获取当前的10位时间戳，使用频率较高
     * 单独重载方法，批量替换 getTenLengthTime(null)
     * @Return java.lang.Long
     * @Author
     * @Date 2020/2/29 11:30
     */
    public static Long getTenLengthTime() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * @Description 获取当前的13位时间戳
     * 单独重载方法，批量替换 getLengthTime(null)
     * @Return java.lang.Long
     */
    public static Long getLengthTime() {
        return System.currentTimeMillis();
    }


    public static Long getTenLengthZeroTime(Date date, int addDay) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
        } else {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, addDay);
        return calendar.getTime().getTime() / 1000;
    }

    public static Long getTenLengthEndTime(Date date, int addDay) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
        } else {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.add(Calendar.DATE, addDay);
        return calendar.getTime().getTime() / 1000;
    }


    /**
     * @param dateTime
     * @throws
     * @Description: 时间戳（10位）转日期
     * @author xiang
     * @date 2019/7/5 18:52
     */
    public static Date getTenLengthDate(Long dateTime) {
        if (dateTime == null || dateTime == 0) {
            return null;
        }
        Date date = new Date(dateTime * 1000);
        return date;
    }

    /**
     * 获取周几 2 周一 5 周四
     *
     * @return
     */
    public static int getNowWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * @param dateTime
     * @throws
     * @Description: 时间戳（13位）转日期
     * @author whg
     * @date 2022/05/28 18:52
     */
    public static Date getTenLengthMillDate(Long dateTime) {
        if (dateTime == null || dateTime == 0) {
            return null;
        }
        return new Date(dateTime);
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    /**
     * @param date1
     * @param date2
     * @return
     * @throws
     * @Description: 获得2个时间的月份差
     * @author zgjs
     * @date 2017年6月13日 下午8:11:08
     */
    public static int getMonthSpace(Date date1, Date date2) {
        Temporal temporal1 = LocalDate.parse(DateUtils.format(date1));
        Temporal temporal2 = LocalDate.parse(DateUtils.format(date2));
        // 方法返回为相差月份
        long result = ChronoUnit.MONTHS.between(temporal1, temporal2);
        int r = (int) Math.abs(result);
        return r;
    }

    /**
     * @return
     * @Description: 日期字符串是否是给定的日期格式
     * @author jinwp
     * @date 2017年11月24日 上午9:01:36
     * 获取特定的天数,day+n
     */
    public static Date getDate(int dayNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, dayNum);
        return calendar.getTime();
    }

    /**
     * @param date
     * @param format
     * @return
     * @throws
     * @Description: 日期字符串是否是给定的日期格式
     * @author jinwp
     * @date 2017年11月24日 上午9:01:36
     */
    public static Boolean isRightFormat(String date, String format) {
        if (StringUtils.isBlank(date)) {
            return false;
        }
        if (StringUtils.isBlank(format)) {
            format = E_DATE;
        }
        String formatDate = null;
        try {
            formatDate = new SimpleDateFormat(format).format(DateUtils.parseDate(date, format));
        } catch (Exception e) {
        }
        return date.equals(formatDate);
    }

    /*public static Integer getDays(List<Date[]> dates) {
        Integer days = 0;
        if(CollectionUtils.isEmpty(dates)) {
            return days;
        }
        Date min;
        Date max;
        for(Date[] tmp : dates) {
            if(tmp.length != 2 || tmp[0].after(tmp[1])) {
                continue;
            }
            if(min == null || min.)
            min = tmp[0];

        }
    }*/


    /**
     * @param list
     * @return
     * @throws
     * @Description: 获取去重天数
     * @author zgjs
     * @date 2018年1月10日 下午2:13:59
     */
    public static int getDeDuplicationDays(List<DateBean> list) {
        int days = 0;

        if (CollectionUtils.isNotEmpty(list)) {
            /* 将传递过来的列表时间进行处理*/
            for (DateBean bean : list) {
                if (bean.getStartDate() != null && bean.getEndDate() != null) {
                    bean.setStartDate(getDateStart(bean.getStartDate()));
                    bean.setEndDate(getDateStart(bean.getEndDate()));
                }
            }

            if (list.size() == 1) {
                DateBean bean = list.get(0);
                if (bean.getStartDate() != null && bean.getEndDate() != null) {
                    days += getDaySpace(bean.getStartDate(), bean.getEndDate()) + 1;
                }
            } else {
                /* 将传递过来的列表进行排序 */
                sortDateBeanList(list);

                /* 获取去重后的时间段*/
                List<DateBean> saveBeanList = getDeDuplicationDateList(list);

                /** 将去重后的日期进行计算，单位：天 */
                if (CollectionUtils.isNotEmpty(saveBeanList)) {
                    for (DateBean bean : saveBeanList) {
                        //需要包含当天日期，所以需要+1
                        days += getDaySpace(bean.getStartDate(), bean.getEndDate()) + 1;
                    }
                }
            }
        }

        return days;
    }

    /**
     * @return
     * @throws
     * @Description: 获得去重后的时间段列表
     * @author zgjs
     * @date 2018年1月10日 下午2:20:20
     */
    private static List<DateBean> getDeDuplicationDateList(List<DateBean> list) {
        //用于存储去重后的时间段
        List<DateBean> saveBeanList = new ArrayList<>();
        if (CollectionUtils.isEmpty(list)) {
            return saveBeanList;
        }

        //用于进行比较存储的时间段
        Date startDate = null, endDate = null;
        //用于比较的时间段
        Date newStartDate = null, newEndDate = null;
        DateBean dto = null;
        DateBean saveBean = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            dto = list.get(i);
            if (dto != null) {
                newStartDate = dto.getStartDate();
                newEndDate = dto.getEndDate();

                if (newStartDate != null && newEndDate != null) {
                    if (startDate == null || endDate == null) {
                        startDate = newStartDate;
                        endDate = newEndDate;
                    } else {
                        //新的时间大于第一个时间段的结束时间时，保存下第一段时间，并重新赋值
                        if (newStartDate.compareTo(endDate) == 1) {
                            saveBean = new DateBean();
                            saveBean.setStartDate(startDate);
                            saveBean.setEndDate(endDate);
                            saveBeanList.add(saveBean);

                            startDate = newStartDate;
                            endDate = newEndDate;
                        } else if (newEndDate.compareTo(endDate) == 1) {
                            endDate = newEndDate;
                        }
                    }

                    if (i + 1 >= size) {
                        saveBean = new DateBean();
                        saveBean.setStartDate(startDate);
                        saveBean.setEndDate(endDate);
                        saveBeanList.add(saveBean);
                    }
                }
            }
        }

        return saveBeanList;
    }

    /**
     * @param list
     * @throws
     * @Description: 对datebean进行排序
     * @author zgjs
     * @date 2018年1月10日 下午2:15:36
     */
    private static void sortDateBeanList(List<DateBean> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }

        /* 将传递过来的列表进行排序 */
        Collections.sort(list, new Comparator<DateBean>() {
            @Override
            public int compare(DateBean obj1, DateBean obj2) {
                if (obj1 == null) {
                    return -1;
                } else {
                    int flag = obj1.getStartDate().compareTo(obj2.getStartDate());
                    if (flag == 0) {
                        return obj1.getEndDate().compareTo(obj2.getEndDate());
                    } else {
                        return flag;
                    }
                }
            }
        });
    }

    /**
     * @author zgjs
     * @Description: 日期bean
     * @date 2018年1月10日 下午1:27:06
     */
    public static class DateBean {
        String name;
        Date startDate;
        Date endDate;

        public DateBean() {
        }

        public DateBean(Date startDate, Date endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //由出生日期获得年龄
    public static Integer getAge(Date birthDay) {
        if (birthDay == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            return null;
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
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    /**
     * @param commitTime
     * @throws
     * @Description: 预实习报告显示提交时间
     * @author xiang
     * @date 2022/11/8 9:22
     */
    public static String showPreReportTime(Date commitTime) {
        Date nowDate = DateUtils.getDateStart(new Date());
        Date commitTimeDate = DateUtils.getDateStart(commitTime);
        if (commitTimeDate.compareTo(nowDate) == 0) {//当天
            long minSecond = Math.abs(nowDate.getTime() - commitTime.getTime());
            long minitue = new BigDecimal(Math.ceil(minSecond / 1000.00 / 60.00)).longValue();
            if (minitue > 60) {
                return DateUtils.format(commitTime, DateUtils.E_DATE_TIME);
            } else {
                return minitue + "分钟前";
            }
        } else if (DateUtils.addDays(commitTimeDate, 1).compareTo(nowDate) == 0) {//一天前
            String formatDate = DateUtils.format(commitTime, DateUtils.E_DATE_TIME);
            return "昨天" + formatDate.substring(10, formatDate.length());
        } else if (DateUtils.addDays(commitTimeDate, 1).compareTo(nowDate) == -1) {//两天前或更久
            return DateUtils.format(commitTime, DateUtils.E_DATE_TIME);
        }
        return DateUtils.format(commitTime, DateUtils.E_DATE_TIME);
    }


    public static String showMsgTime(Date createTime) {
        Date nowDate = DateUtils.getDateStart(new Date());
        Date createTimeDate = DateUtils.getDateStart(createTime);
        //当天
        if (createTimeDate.compareTo(nowDate) == 0) {
            return DateUtils.format(createTime, DateUtils.E_TIME);
        }
        //一天前
        if (DateUtils.addDays(createTimeDate, 1).compareTo(nowDate) == 0) {
            return DateUtils.format(createTime, DateUtils.C_MONTH_DATE);
        }
        return DateUtils.format(createTime, DateUtils.E_DATE_TIME);
    }

    /**
     * 秒转换为指定格式的日期
     *
     * @param second 毫秒
     * @return
     */
    public static String secondToDate(long second, String patten) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(second);
        return format(calendar.getTime(), patten);

    }


    public static String getAdminDateStr(Date date1) {
        if (date1.getYear() != new Date().getYear()) {
            return secondToDate(date1.getTime(), "yyyy-MM-dd");
        } else {
            return secondToDate(date1.getTime(), "MM-dd HH:mm");
        }
    }

    public static String getDateStr(Date date1, Date date2) {
        String str;

        int i = differentDays(date1, date2);
        if (i == 0) {
            str = "今天";
        } else if (i == 1) {
            str = "昨天";
        } else if (i > 1 && i < 7) {
            str = i + "天前";
        } else if (date1.getYear() != date2.getYear()) {
            str = secondToDate(date1.getTime(), "yyyy-MM-dd");
        } else {
            str = secondToDate(date1.getTime(), "MM-dd");
        }
        return str;
    }

    public static String getImDateStr(Date date1, Date date2) {
        String str;
        int i = differentDays(date1, date2);
        if (i == 0) {
            str = secondToDate(date1.getTime(), "HH:mm");
        } else if (i == 1) {
            str = "昨天";
        } else if (i > 1 && i < 7) {
            str = i + "天前";
        } else {
            str = secondToDate(date1.getTime(), "MM-dd");
        }
        return str;
    }


    /**
     * 获取两个日期相差的天数
     *
     * @param date1
     * @param date2 date2 > date1
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                //闰年
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else {//不是闰年
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else {
            //不同年
            return day2 - day1;
        }
    }

    /**
     * 计算两个时间相差多少小时 date2>date1
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentHours(Date date1, Date date2) {
        Long d1 = getTenLengthTime(date1);
        Long d2 = getTenLengthTime(date2);
        return (d2.intValue() - d1.intValue()) / 3600;
    }

    /**
     * 计算两个时间相差多少小时 date2>date1
     *
     * @param d1
     * @param d2
     * @return
     */
    public static int differentTimeHours(Long d1, Long d2) {
        return (d2.intValue() - d1.intValue()) / 3600;
    }

    /**
     * 计算两个时间相差多少秒 date2>date1
     *
     * @param d1
     * @param d2
     * @return
     */
    public static int differentSec(Long d1, Long d2) {
        return d2.intValue() - d1.intValue();
    }


    /**
     * @description: 获取2个时间的差， 精确到秒
     * @author: jinwp
     * @param: startTime
     * @param: endTimne
     * @date: 2018年08月29日 09:13:50
     * @return: java.lang.String
     */
    public static String getTimeSpace(Date startTime, Date endTimne) {
        if (startTime == null || endTimne == null) {
            return "";
        }
        long between = endTimne.getTime() - startTime.getTime();
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        if (day > 0) {
            return day + "天" + hour + "小时" + min + "分" + s + "秒";
        } else if (hour > 0) {
            return hour + "小时" + min + "分" + s + "秒";
        } else if (min > 0) {
            return min + "分" + s + "秒";
        } else if (s > 0) {
            return s + "秒";
        }
        return "0秒";
    }

    /**
     * @description: 获取2个时间的差， 精确到秒
     * @author: jinwp
     * @param: startTime
     * @param: endTimne
     * @date: 2018年08月29日 09:13:50
     * @return: java.lang.String
     */
    public static String getTimeSpace(Long startTime, Long endTimne) {
        if (startTime == null || endTimne == null) {
            return "";
        }
        long between = endTimne - startTime;
        long day = between / (24 * 60 * 60 * 1000);

        long hour = (between / (60 * 60 * 1000) - day * 24);

        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);

        long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

        if (day > 0) {
            return day + "天" + hour + "小时" + min + "分" + s + "秒";
        } else if (hour > 0) {
            return hour + "小时" + min + "分" + s + "秒";
        } else if (min > 0) {
            return min + "分" + s + "秒";
        } else if (s > 0) {
            return s + "秒";
        }
        return between + "毫秒";
    }

    /**
     * @param startDate
     * @param endDate
     * @throws
     * @Description: 获取环比时间
     * @author xiang
     * @date 2019/10/10 9:16
     */
    public static Date[] getChainRatioDate(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return null;
        }
        //相差天数
        Integer differentDays = differentDays(startDate, endDate);
        //环比结束时间
        Date newEndDate = DateUtils.addDays(startDate, -1);
        //环比开始时间
        Date newStartDate = DateUtils.addDays(newEndDate, -differentDays);
        return new Date[]{newStartDate, newEndDate};
    }

    /**
     * 初始化指定日期 年月日的十位时间戳
     *
     * @param date
     * @return
     * @author jinwp
     */
    public static Long initDateLong(Date date) {
        if (date == null) {
            return 0L;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return getTenLengthTime(calendar.getTime());
    }

    /**
     * 初始化指定日期 年月日的十位时间戳
     *
     * @param time : 支持10位/13位时间戳
     * @return
     * @author jinwp
     */
    public static Long initDateLong(Long time) {
        if (time == null) {
            return 0L;
        }
        String timeStr = String.valueOf(time);
        if (timeStr.length() == 10) {
            time = time * 1000;
        } else if (timeStr.length() == 13) {

        } else {
            return 0L;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return getTenLengthTime(calendar.getTime());
    }

    /**
     * 获取指定日期0点时间戳
     */
    public static Long getZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取昨日24点时间戳
     */
    public static Long getTwentyFourTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1, 23, 59, 59);
        return calendar.getTime().getTime() / 1000;
    }

    /**
     * 获取第二天0点时间戳
     */
    public static Long getNextDayZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) + 2, 0, 0, 0);
        return getTenLengthTime(calendar.getTime());
    }

    /**
     * 获取第二天0点时间戳
     */
    public static Long getTomorrowZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) + 1, 0, 0, 0);
        return getTenLengthTime(calendar.getTime());
    }

    /**
     * 获取年份
     */
    public static int getYear(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     */
    public static int getMonth(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 2016-11-08 14:39:38
     * pattern yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String showDate(Date date, String pattern) {
        String dateStr = format(date, pattern);
        String year = dateStr.substring(0, 4);
        Long yearNum = Long.parseLong(year);
        int month = Integer.parseInt(dateStr.substring(5, 7));
        int day = Integer.parseInt(dateStr.substring(8, 10));
        String hour = dateStr.substring(11, 13);
        String minute = dateStr.substring(14, 16);

        long addtime = date.getTime();
        long today = System.currentTimeMillis();//当前时间的毫秒数
        Date now = new Date(today);
        String nowStr = format(now, pattern);
        int nowDay = Integer.parseInt(nowStr.substring(8, 10));
        String result = "";
        long l = today - addtime;//当前时间与给定时间差的毫秒数
        long days = l / (24 * 60 * 60 * 1000);//这个时间相差的天数整数，大于1天为前天的时间了，小于24小时则为昨天和今天的时间
        long hours = (l / (60 * 60 * 1000) - days * 24);//这个时间相差的减去天数的小时数
        long min = ((l / (60 * 1000)) - days * 24 * 60 - hours * 60);//
        long s = (l / 1000 - days * 24 * 60 * 60 - hours * 60 * 60 - min * 60);
        if (days > 0) {
            if (days > 0 && days < 2) {
                result = "前天" + hour + "点" + minute + "分";
            } else {
                result = yearNum % 100 + "年" + month + "月 " + day + "日" + hour + "点" + minute + "分";
            }
        } else if (hours > 0) {
            if (day != nowDay) {
                result = "昨天" + hour + "点" + minute + "分";
            } else {
                result = hours + "小时 前";
            }
        } else if (min > 0) {
            if (min > 0 && min < 15) {
                result = "刚刚";
            } else {
                result = min + "分 前";
            }
        } else {
            result = s + "秒 前";
        }
        return result;
    }

    /**
     * @param startDate
     * @param endDate
     * @throws
     * @Description: 获取周次
     * @author xiang
     * @date 2022/6/23 9:09
     */
    public static List<DateBean> listWeekTimeDate(Date startDate, Date endDate) {
        List<DateBean> beanList = new ArrayList<>();
        if (startDate == null || endDate == null) {
            return beanList;
        }
        //获取开始时间是否为周一，如果不是周一的话需要获取下一周的周一作为开始时间
        Date weekStartDate = getWeekStartDate(startDate);
        //结束时间所在周的最后一天
        Date weekEndDate = parseDate(getEndWeekDate(endDate));
        //循环的起始时间
        Date date = weekStartDate;
        while (date.before(weekEndDate)) {
            //date对应所在周的结束时间
            Date weekDate = parseDate(getEndWeekDate(date));
            DateBean dateBean = new DateBean(date, weekDate);
            beanList.add(dateBean);
            //加7天，到第二周
            date = addDays(date, 7);
        }
        return beanList;
    }

    /**
     * @param startDate 开始周的周一
     * @param endDate   结束周的周日
     * @throws
     * @Description: 获取周次数（学期起始周已设置的情况的周次数）
     * @author xiang
     * @date 2022/6/23 9:23
     */
    public static long getWeekTimeSize(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        //两个时间相差的天数
        long daySize = getSpaceDays(startDate, endDate);
        return daySize / 7;
    }

    /**
     * @param date
     * @throws
     * @Description: 获取时间所在周的第一天
     * 开始时间的第一个周一
     * @author xiang
     * @date 2022/6/23 15:14
     */
    public static Date getWeekStartDate(Date date) {
        if (date == null) {
            return null;
        }
        //周一
        Date weekStartDate = parseDate(getStartWeekDate(date));
        //获取开始时间是否为周一，如果不是周一的话需要获取下一周的周一作为开始时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w != 1) {
            weekStartDate = addDays(date, 7 - w + 1);
        }
        return weekStartDate;
    }

    /**
     * @param date
     * @throws
     * @Description: 获取别名（寒，暑假）
     * @author xiang
     * @date 2022/6/23 15:58
     */
    public static String getPartName(Date date) {
        if (date == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //时间所在月份
        Integer month = calendar.get(Calendar.MONTH) + 1;
        //12-3月为寒假
        if (month >= 12 || month <= 3) {
            return "寒假";
        }
        //6-10月为暑假
        if (month >= 6 && month <= 10) {
            return "暑假";
        }
        return "";
    }

    /**
     * 初始化当前时间所在的学年（9.1 - 8.31）
     *
     * @author: jinwp
     * @date: 2022年09月22日 14:14:26
     * @return: java.lang.Long
     */
    public static Long getCurrentSchoolYear() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        //如果是9月之前， 则还处于上一学年
        long currentSchoolYear = currentMonth < Calendar.SEPTEMBER ? (currentYear - 1) : currentYear;
        return currentSchoolYear;
    }

    /**
     * 当前届
     *
     * @author jinwp
     * @date 2023/3/22 9:56
     * @return java.lang.Long
     */
    public static Long getCurrentGraduateYear() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        return (long) currentYear;
    }

    /**
     * 判断日期是否是星期一
     *
     * @param date
     * @author: jinwp
     * @date: 2022年09月23日 09:23:47
     * @return: java.lang.Boolean
     */
    public static Boolean isMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekIndex == 1;
    }

    /**
     * 判断日期是否是星期日
     *
     * @param date
     * @author: jinwp
     * @date: 2022年09月23日 09:23:47
     * @return: java.lang.Boolean
     */
    public static Boolean isSunday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekIndex == 0;
    }

    /**
     * @param date
     * @throws
     * @Description: 判断日期是否是周末休息日
     * @author xiang
     * @date 2023/2/15 11:07
     */
    public static Boolean isRestDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekIndex == 0 || weekIndex == 6;
    }

    /**
     * 根据多种格式转换时间
     *
     * @param date
     * @return java.util.Date
     * @Author cgy
     * @Date 11:01 2022/10/28
     * @Param
     **/
    public static Date parseDateByFormats(String date, String[] dateFormat) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        String rightFormat = null;
        for (String format : dateFormat) {
            if (isRightFormat(date, format)) {
                rightFormat = format;
                break;
            }
        }
        //格式无法匹配，则返回空
        if (StringUtils.isBlank(rightFormat)) {
            return null;
        }
        //不需要特殊处理的
        if (!CollectionUtil.contains(EXCEL_DATE_FORMAT_SPECIAL, rightFormat)) {
            return parseDate(date, rightFormat);
        }
        return getDateStart(parseDate(date, rightFormat));
    }

    /**
     * 将日期字符串转换成日期对象
     *
     * @param date
     * @return java.util.Date
     * @author jinwp
     * @date 2023/2/6 10:35
     */
    public static Date parseAllDate(String date) {

        if (StringUtils.isBlank(date)) {
            return null;
        }
        // 四种格式轮询比较
        String[] dateFormats = {E_DATE, E_SLASH_DATE, DATE_TIME, APP_E_DATE};
        for (String format : dateFormats) {
            if (isRightFormat(date, format)) {
                return parseDate(date, format);
            }
        }
        return null;
    }

    /**
     * @param startDate   开始时间
     * @param endDate     结束时间
     * @param preWeekDays 每周实习天数，不传默认每周5天
     * @param holidayDays 节假日放假天数
     * @param weekDays 周末休息天数（已除去调休,节假日）
     * @throws
     * @Description: 计算实习天数
     * @author xiang
     * @date 2023/2/14 9:18
     */
    public static double getPracticeDays(Date startDate, Date endDate, Double preWeekDays,
                                         Integer holidayDays, Integer weekDays) {
        double practiceDays = 0;
        //总实习天数
        long allWeekDays = getSpaceDays(startDate, endDate);
        if (preWeekDays == null) {
            //实际实习天数（实习天数 - 放假天数 - 周末休息天数）
            practiceDays = allWeekDays - holidayDays - weekDays;
        } else {
            //实际实习天数（实习天数 - 放假天数）/ 7 * 每周上班天数）
            practiceDays = (allWeekDays - holidayDays) / 7.0 * preWeekDays;
        }
        return practiceDays;
    }


    /**
     * 初始化一天的最小时间
     *
     * @author jinwp
     * @date 2023/4/18 14:51
     * @param date
     * @return java.lang.String
     */
    public static String initMinDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return date;
        }
        return date.trim() +" 00:00:00";
    }

    /**
     * 初始化一天的最大时间
     *
     * @author jinwp
     * @date 2023/4/18 14:51
     * @param date
     * @return java.lang.String
     */
    public static String initMaxDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return date;
        }
        return date.trim() +" 23:59:59";
    }

    public static void main(String[] args) {
        Date sDate = DateUtils.parseDate("2023.01.01", DateUtils.APP_E_DATE);
        Date eDate = DateUtils.parseDate("2023.01.31", DateUtils.APP_E_DATE);
        double spaceDay = DateUtils.getPracticeDays(sDate, eDate, 5d, 7, 0);
        System.err.println("spaceDay == " + spaceDay);
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }
}
