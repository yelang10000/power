package com.sun.power.core.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 获取系统当前时间
	 * @return 系统当前时间
	 *
	 */
	public static Timestamp nowTime() {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String timeStr = df.format(time);
		time = Timestamp.valueOf(timeStr);
		return time;
	}

	/**
	 * 时间格式化字符串, yyyy-MM-dd HH:mm:sss,显示到秒
	 */
	public static final String FormatSdFormatString = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 时间格式化对象, yyyy-MM-dd HH:mm:ss
	 */
	public static SimpleDateFormat sdFormat = new SimpleDateFormat(
			FormatSdFormatString);

	/**
	 * 将Date转为Calendar
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar timeTranFor(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * 获取当前时间前N天的日期
	 * 
	 * @param date
	 * @param beforeDays
	 * @return
	 */
	public static Date getNextDay(Date date, int beforeDays) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -beforeDays);
		return calendar.getTime();
	}

	/**
	 * 一个小时前的时间
	 * 
	 * @return
	 */
	public static Date getBeforeHour() {
		/* HOUR_OF_DAY 指示一天中的小时 */
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.get(Calendar.HOUR_OF_DAY) - 1);
		return calendar.getTime();
	}

	/**
	 * 获取传入时间前24小时的时间
	 * 
	 * @return
	 */
	public static Timestamp getBefore24Hour() {
		/* HOUR_OF_DAY 指示一天中的小时 */
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.get(Calendar.HOUR_OF_DAY) - 24);
		return new Timestamp(calendar.getTime().getTime());
	}

	/**
	 * 得到传入时间与当前时间的时间差
	 * 
	 * @return
	 */
	public static String getDateDiff(Calendar calendar) {

		Calendar calendarNow = Calendar.getInstance();
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		// long ns = 1000;// 一秒钟的毫秒数long diff;try {
		// 获得两个时间的毫秒时间差异
		long diff = calendarNow.getTimeInMillis() - calendar.getTimeInMillis();
		if (diff < nm) {
			// long sec = diff % nd % nh % nm / ns;// 计算差多少秒//输出结果
			return "0分钟以前";
		} else if (diff >= nm && diff < nh) {
			long min = diff % nd % nh / nm;// 计算差多少分钟
			return min + "分钟以前";
		} else if (diff >= nh && diff <= nd) {
			long hour = diff % nd / nh;// 计算差多少小时
			return hour + "小时以前";
		} else {
			return sdFormat.format(calendar.getTime());
		}
		// long day = diff / nd;// 计算差多少天
		// System.out.println("时间相差：" + day + "天" + hour + "小时" + min + "分钟" +
		// sec + "秒。");

	}

	/**
	 * main Test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Date before24Hour = getBefore24Hour();
		System.out.println(before24Hour);

		Calendar c = Calendar.getInstance();

		c.setTimeInMillis(1441793637610L);
		System.out.println(c.getTime());
		c.setTimeInMillis(1441793624117L);
		System.out.println(c.getTime());
		c.setTimeInMillis(1438586878957L);
		System.out.println(c.getTime());

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1); // 得到前一个月
		System.out.println(sdFormat.format(calendar.getTime()));

		System.out.println("一个小时前的时间：" + sdFormat.format(getBeforeHour()));
		System.out.println("当前的时间：" + sdFormat.format(new Date()));

		Date nextDay = getNextDay(new Date(), 7);
		String str1 = sdFormat.format(nextDay);
		System.out.println("+++++" + str1);

		Timestamp now = new Timestamp(System.currentTimeMillis());// 获取系统当前时间
		long time = now.getTime() - 6000;
		c.setTimeInMillis(time);
		System.out.println(sdFormat.format(c.getTime()));

		Date date = new Date();
		date = now;
		String str = sdFormat.format(date);
		System.out.println(str);
	}

}
