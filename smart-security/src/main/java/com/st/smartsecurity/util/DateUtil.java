package com.st.smartsecurity.util;

import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 日期工具类
 * 本工具类负责日期相关处理，主要功能有：
 * 1. 将字符串日期处理成Date
 * 2. 将Date 格式化成指定格式字符串
 *
 * @author kunee
 */
public class DateUtil {
	private static Map<String, SimpleDateFormat> formats;

	public static final String DATE_FORMATE_STRING_DEFAULT = "yyyyMMddHHmmss";
	public static final String DATE_FORMATE_STRING_A = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_FORMATE_STRING_B = "yyyy-MM-dd";

	/**
	 * 举例：11/08/2015 23:23:23 pm
	 */
	public static final String DATE_FORMATE_STRING_C = "MM/dd/yyyy HH:mm:ss a";

	/**
	 * 举例：11/08/2015 23:23:23 pm
	 */
	public static final String DATE_FORMATE_STRING_D = "yyyy-MM-dd HH:mm:ss a";

	public static final String DATE_FORMATE_STRING_H = "yyyyMMdd";
	public static final String DATE_FORMATE_STRING_I = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String DATE_FORMATE_STRING_J = "yyyyMMddHHmmss.SSS";
	public static final String DATE_FORMATE_STRING_TO_MIN = "yyyy-MM-dd HH:mm";
	public static final String DATE_FORMATE_STRING_HOUR_MIN = "HH:mm";
	public static final String DATE_FORMATE_STRING_K = "yyyy年MM月dd日";
	public static final String DATE_FORMATE_STRING_L = "yyyy年MM月dd日  HH时mm分";
	public static final String DATE_FORMATE_STRING_M = "HH时mm分";
	public static final String DATE_FORMATE_STRING_MON_DAY = "MM-dd";
	public static final String DATE_FORMATE_STRING_YEAR_MON = "yyyy-MM";
	public static final String DATE_FORMATE_STRING_YEAR = "yyyy";
	public static final String DATE_FORMATE_STRING_HOUR = "HH";


	static {
		formats = new HashMap<String, SimpleDateFormat>();

		formats.put(DATE_FORMATE_STRING_DEFAULT, new SimpleDateFormat(DATE_FORMATE_STRING_DEFAULT));
		formats.put(DATE_FORMATE_STRING_A, new SimpleDateFormat(DATE_FORMATE_STRING_A));
		formats.put(DATE_FORMATE_STRING_B, new SimpleDateFormat(DATE_FORMATE_STRING_B));
		formats.put(DATE_FORMATE_STRING_C, new SimpleDateFormat(DATE_FORMATE_STRING_C));
		formats.put(DATE_FORMATE_STRING_D, new SimpleDateFormat(DATE_FORMATE_STRING_D));

		formats.put(DATE_FORMATE_STRING_H, new SimpleDateFormat(DATE_FORMATE_STRING_H));
		formats.put(DATE_FORMATE_STRING_I, new SimpleDateFormat(DATE_FORMATE_STRING_I));
		formats.put(DATE_FORMATE_STRING_J, new SimpleDateFormat(DATE_FORMATE_STRING_J));

		formats.put(DATE_FORMATE_STRING_TO_MIN, new SimpleDateFormat(DATE_FORMATE_STRING_TO_MIN));
		formats.put(DATE_FORMATE_STRING_HOUR_MIN, new SimpleDateFormat(DATE_FORMATE_STRING_HOUR_MIN));
		formats.put(DATE_FORMATE_STRING_K, new SimpleDateFormat(DATE_FORMATE_STRING_K));
		formats.put(DATE_FORMATE_STRING_L, new SimpleDateFormat(DATE_FORMATE_STRING_L));
		formats.put(DATE_FORMATE_STRING_M, new SimpleDateFormat(DATE_FORMATE_STRING_M));
	}

	/**
	 * 将Date转换为 pattern 格式的字符串，
	 *
	 * @param date    日期
	 * @param pattern 日期格式
	 * @return String --格式化的日期字符串
	 * @see Date
	 */
	public static String getFormatTimeString(Date date, String pattern) {
		SimpleDateFormat sDateFormat = getDateFormat(pattern);
		return sDateFormat.format(date);
	}

	/**
	 * 将Date转换为默认的yyyyMMddHHmmss 格式的字符串
	 *
	 * @param date
	 * @return String yyyyMMddHHmmss 格式字符串
	 */
	public static String getDefaultFormateTimeString(Date date) {
		return getFormatTimeString(date, DATE_FORMATE_STRING_DEFAULT);
	}

	/**
	 * 根据pattern取得的dateFormate
	 *
	 * @param pattern
	 * @return
	 */
	public static SimpleDateFormat getDateFormat(String pattern) {
		SimpleDateFormat sDateFormat = formats.get(pattern);
		if (sDateFormat == null) {
			sDateFormat = new SimpleDateFormat(pattern);
			formats.put(pattern, sDateFormat);
		}
		return sDateFormat;
	}

	/**
	 * 使用传入的格式将日期字符串转换为Date对象
	 *
	 * @param date    字符串
	 * @param pattern
	 * @return 日期Date对象
	 * @throws ParseException
	 * @see Date
	 */
	public static Date getDateFromString(String date, String pattern) throws ParseException {
		SimpleDateFormat sDateFormat = getDateFormat(pattern);
		return sDateFormat.parse(date);
	}

	/**
	 * 将日期字符串转化成默认格式YYYYMMDDHHMMSS的Date对象
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDefaultDateFromString(String date) throws ParseException {
		return getDateFromString(date, DATE_FORMATE_STRING_DEFAULT);
	}

	/**
	 * 取当前时间转换成格式为yyyyMMddHHmmss的日期字符串
	 *
	 * @return 当前日期字符串
	 * @throws ParseException
	 * @see Date
	 */
	public static String getNowDefault() {
		return getNow(DATE_FORMATE_STRING_DEFAULT);
	}

	/**
	 * 按照pattern格式取当前日期格式成字符串
	 *
	 * @param pattern 日期字符串格式
	 * @return 格式化后的当前日期字符串
	 */
	public static String getNow(String pattern) {
		return getFormatTimeString(new Date(), pattern);
	}

	/**
	 * 取当前时间格式为yyyyMMdd的字符串
	 *
	 * @return 当前日期字符串
	 * @throws ParseException
	 * @see Date
	 */
	public static String getNowII() {
		return getFormatTimeString(new Date(), DATE_FORMATE_STRING_H);
	}

	/**
	 * 取当日,格式为YYYYMMDD 时分秒为0
	 *
	 * @return 当前日期
	 * @throws ParseException
	 * @see Date
	 */
	public static Date getNowDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.HOUR, 0);
		return cal.getTime();
	}

	/**
	 * 将输入的时间字符串按照pattern格式的转换为时间后取自1976以来的毫秒数
	 *
	 * @return 时间毫秒数
	 * @throws ParseException
	 * @see Date
	 */
	public static long dateString2Long(String str, String pattern) throws ParseException {
		return getDateFromString(str, pattern).getTime();
	}

	/**
	 * 把since1976的毫秒数转成默认格式yyyyMMddHHmmss的String日期字符串
	 *
	 * @param time
	 * @return
	 */
	public static String longToDateStringDefault(long time) {
		return getFormatTimeString(new Date(time), DATE_FORMATE_STRING_DEFAULT);
	}

	/**
	 * 将时间的毫秒数 since 1976转换为按照pattern格式的日期字符串
	 *
	 * @return 日期字符串
	 * @see Date
	 */
	public static String longToDateString(long time, String pattern) {
		return getFormatTimeString(new Date(time), pattern);
	}


	/**
	 * 将Date对象转成since 1976的毫秒数
	 *
	 * @param date
	 * @return since1976的毫秒数
	 */
	@Deprecated
	public static long date2Long(Date date) {
		return date.getTime();
	}

	/**
	 * 将since1976毫秒数转成Date对象
	 *
	 * @param time
	 * @return
	 */
	@Deprecated
	public static Date longToDate(long time) {
		return new Date(time);
	}

	/**
	 * 自动适配两种格式的日期字符串转换为date对象  优先匹配A格式
	 * A格式	:	yyyy-MM-dd HH:mm:ss
	 * B格式	:	yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	@Deprecated
	public static Date getDateFromStringAdaptTwoPattern(String date) throws ParseException {
		try {
			return getDateFromString(date, DATE_FORMATE_STRING_A);
		} catch (ParseException e) {
			return getDateFromString(date, DATE_FORMATE_STRING_B);
		}
	}

	/**
	 * 获取当前时间的前后几个月的时间,以格式为：yyyy-MM-dd HH:mm:ss字符串 返回
	 * 例：取前6个月的时间传入-6,后6个月的时间传入6
	 *
	 * @param count
	 * @return
	 */
	@Deprecated
	public static String getDIYDate(int count) {

		Date newDate = addTime(new Date(), Calendar.MONDAY, count);

		return getFormatTimeString(newDate, DATE_FORMATE_STRING_A);
	}


	/**
	 * 得到某个日期的月尾
	 *
	 * @param date
	 * @return
	 */
	public static Date getMonEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return cal.getTime();
	}

	/**
	 * 得到某个日期的月头
	 *
	 * @param date
	 * @return
	 */
	public static Date getMonBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到某个日期的年头
	 *
	 * @param date
	 * @return
	 */
	public static Date getYearBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到某个日期的年尾
	 *
	 * @param date
	 * @return
	 */
	public static Date getYearEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return cal.getTime();
	}

	/**
	 * 获取这个月的开始日期，时分秒都为0
	 *
	 * @return 月初日期
	 */
	public static Date getThisMonBegin() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}


	/**
	 * 获取这个月的开始日期，时分秒都为0
	 *
	 * @return 月初日期
	 */
	public static Date getThisYearBegin() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取今年尾，时分秒都为0
	 *
	 * @return 明年第一天
	 */
	public static Date getThisYearEnd() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.YEAR, 1);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取今日开始
	 *
	 * @return 今日凌晨0点
	 */
	public static Date getTodayBegin() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取今天结束时间
	 *
	 * @return 今天结束(明天开始)
	 */
	public static Date getTodayEnd() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取某个日期的开始，时分秒都为0
	 *
	 * @return 日期开始时间
	 */
	public static Date getDayBegin(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取某个日期的结束，
	 *
	 * @return 日期结束时间
	 */
	public static Date getDayEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.add(Calendar.MILLISECOND, -1);
		return cal.getTime();
	}

	/**
	 * @param datetime 日期 例:2017-10-17
	 * @return String 例:星期二
	 * @doc 日期转换星期几
	 * @history 2017年10月17日 上午9:55:30 Create by 【hsh】
	 */
	public static String dateToWeek(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = {"sun", "mon", "tues", "wed", "thur", "fir", "sat"};
		Calendar cal = Calendar.getInstance(); // 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 获取这个月的末尾天，时分秒为24:60:60 000
	 *
	 * @return 月末日期
	 */
	public static Date getThisMonEnd() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}


	/**
	 * 将某个日期加减一个时间
	 *
	 * @param time  被处理的日期
	 * @param field 取Calendar类的 field
	 * @param value 加减的值
	 * @return 处理后的日期
	 */
	public static Date addTime(Date time, int field, int value) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.add(field, value);
		return cal.getTime();
	}

	/**
	 * 美化日期，输出刚刚， **分钟前，**小时前等描述性文字
	 *
	 * @param date 需要被美化的日期
	 * @return
	 */
	public static String beautifyDt(Date date) {
		if (date == null) {
			return "";
		}
		Date now = new Date();

		long mms = (now.getTime() - date.getTime()) / 1000;

		if (mms < 60) {
			return "刚刚";
		} else if (mms < 60 * 60) {
			return mms / 60 + "分钟前";
		} else if (mms < 60 * 60 * 24) {
			return mms / (60 * 60) + "小时前";
		} else if (mms < 60 * 60 * 24 * 3) {
			int d = getBetweenDays(date, now);
			if (d == 1) {
				return "昨天 " + DateUtil.getFormatTimeString(date, DateUtil.DATE_FORMATE_STRING_HOUR_MIN);
			} else {
				return "前天 " + DateUtil.getFormatTimeString(date, DateUtil.DATE_FORMATE_STRING_HOUR_MIN);
			}
		} else {
			return DateUtil.getFormatTimeString(date, DateUtil.DATE_FORMATE_STRING_B);
		}
	}

	/**
	 * 美化时长，输出刚刚， **秒，**分钟等描述性文字
	 *
	 * @param second 需要被美化的时长
	 * @return
	 */
	public static String beautifyDt(long second) {
		if (second < 60) {
			return second + "秒";
		} else if (second < 60 * 60) {
			return second / 60 + "分钟";
		} else if (second < 60 * 60 * 24) {
			return second / (60 * 60) + "小时";
		} else {
			return second / (60 * 60 * 24) + "天";
		}

	}

	/**
	 * 将某个日期输出为中文格式的星期
	 *
	 * @param date 需要被转换的日期
	 * @return 中文 '一'到'日'
	 */
	public static String getWeekCN(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		switch (week) {
			case 1:
				return "日";
			case 2:
				return "一";
			case 3:
				return "二";
			case 4:
				return "三";
			case 5:
				return "四";
			case 6:
				return "五";
			case 7:
				return "六";
		}
		return null;

	}

	/**
	 * 一年后的今天
	 */
	public static Date getDateOneYearLater() {
		return addTime(new Date(), Calendar.YEAR, 1);
	}

	/**
	 * 获得中国式年龄（出生算一岁）
	 *
	 * @param birthdayDate
	 * @return
	 */
	public static int getAge(Date birthdayDate) {
		Calendar cal = Calendar.getInstance();


		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthdayDate);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth + 1;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth 
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth 
				age--;
			}
		}
		return age;
	}


	/**
	 * 判断指定日期是否在一个日期范围内
	 *
	 * @param fromDate 范围开始日期
	 * @param toDate   范围结束日期
	 * @param testDate 测试日期
	 * @return 在范围内true, 否则false
	 */
	public static boolean betweenDays(Date fromDate, Date toDate, Date testDate) {
		if (fromDate == null || toDate == null || testDate == null) {
			return false;
		}

		// 1、 交换开始和结束日期
		if (fromDate.getTime() > toDate.getTime()) {
			Date tempDate = fromDate;
			fromDate = toDate;
			toDate = tempDate;
		}

		// 2、缩小范围
		long testDateTime = testDate.getTime();
		if ((testDateTime > fromDate.getTime() && testDateTime > toDate.getTime())
				|| testDateTime < fromDate.getTime()
				&& testDateTime < toDate.getTime()) {
			return false;
		}

		return true;
	}

	/**
	 * 获取两个日期相隔多少天
	 *
	 * @param dateBegin
	 * @param dateEnd
	 * @return 相隔天数
	 */
	public static int getBetweenDays(Date dateBegin, Date dateEnd) {
		if (dateBegin == null || dateEnd == null) {
			return -1;
		}
		int betweenDays;
		betweenDays = (int) (Math.abs(dateBegin.getTime() - dateEnd.getTime()) / 1000 / 60 / 60 / 24);
		return betweenDays;
	}

	/**
	 * 比较时间的时分秒大小
	 *
	 * @param firstDate
	 * @param secondDate
	 * @return 大于0  第一个值大于第二个 小于0 第二个值大于第一个 0 相等
	 */
	public static int compareHourMinSecond(Date firstDate, Date secondDate) {
		int first = firstDate.getHours() * 100 * 100 + firstDate.getMinutes() * 100 + firstDate.getSeconds();
		int second = secondDate.getHours() * 100 * 100 +
				secondDate.getMinutes() * 100 + secondDate.getSeconds();
		return first - second;
	}

	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static void main(String args[]) throws ParseException {

		Date date = getDateFromString("2018-06", "yyyy-MM");

		System.out.println(DateUtil.getDefaultFormateTimeString(getMonEnd(date)));

		//System.out.println(DateUtil.getBetweenDays(DateUtil.getDateFromString("2015-07-14 23:59:58", DateUtil.DATE_FORMATE_STRING_A), DateUtil.getDateFromString("2015-07-15 23:59:58", DateUtil.DATE_FORMATE_STRING_A)));
	}
}
