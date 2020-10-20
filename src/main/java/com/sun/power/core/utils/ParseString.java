package com.sun.power.core.utils;

import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;


public class ParseString {

    /**
     * 若为null则转换为"",并替换"'" 为 "''",便于入库
     *
     * @param str
     * @return
     */
    public static String replaceParticular(String str) {

        if (str == null) {
            str = "";
        }
        if (!"".equals(str.trim())) {
            str = str.replaceAll("'", "''");
        }
        return str;
    }

    /**
     * 将null转换为""
     *
     * @param obj
     * @return
     */
    public static String nvl(Object obj) {
        return (obj == null || "null".equals(obj)) ? "" : obj.toString().trim();
    }

    /**
     * 将null转换为""
     *
     * @param obj
     * @return
     */
    public static String nvl2(Object obj) {
        return (obj == null || "null".equals(obj)) ? "0" : obj.toString().trim();
    }

    /**
     * 将null转换为默认值str
     *
     * @param str
     * @return
     */
    public static String defaultIfBlank(Object obj, String str) {
        return isNull(obj) ? str : nvl(obj);
    }

    // 数字验证

    /**
     * 数字验证,当为数字时返回true
     */
    public static boolean checkNumber(String num) {
        if (isNull(num)) {
            return false;
        }
        return num.matches("\\d*(\\.\\d+)?");
    }

    /**
     * 电子邮箱验证, 验证通过返回false
     */
    public static boolean checkEmail(String num) {
        if (isNull(num)) {
            return false;
        }
        return !num.matches("(?:\\w[-._\\w]*\\w@\\w[-._\\w]*\\w\\.\\w{2,3}$)");
    }

    /**
     * 手机号码验证, 验证通过返回false
     */
    public static boolean checkMobile(String num) {
        if (isNull(num)) {
            return false;
        }
        return !num.matches("^(13[0-9]|15[0|1|2|3|5|6|7|8|9]|18[6|7|8|9])\\d{8}$");
    }

    /**
     * 电话号码验证, 验证通过返回false
     */
    public static boolean checkPhone(String num) {
        if (isNull(num)) {
            return false;
        }
        return !num
                .matches("(\\d{11})|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$");
    }

    /**
     * 身份证号码验证, 验证通过返回false
     */
    public static boolean checkID(String num) {
        // if (isNull(num))
        // return false;
        return !num.matches("^\\d{10}|\\d{13}|\\d{15}|\\d{17}(?:\\d|x|X)$");
    }

    /**
     * 邮编验证, 验证通过返回false
     */
    public static boolean checkPost(String num) {
        if (isNull(num)) {
            return false;
        }
        return !num.matches("^[0-9]{6}$");
    }

    /**
     * IP验证, 验证通过返回false
     */
    public static boolean checkIP(String num) {
        // if (isNull(num))
        // return false;
        return !num
                .matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");
    }

    /**
     * 当为null或为空时返回true
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        return str == null || "".equals(str) || "null".equals(str);
    }

    /**
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return obj == null || "".equals(nvl(obj));
    }

    public static boolean notNull(String str) {
        return !isNull(str);
    }

    public static boolean notNull(Object obj) {
        return !isNull(obj);
    }

    // 匹配0,1

    /**
     * 匹配0,1
     */
    public static boolean checkPz(String num) {
        if (StringUtils.isEmpty(num)) {
            return false;
        }
        boolean bool = false;
        Pattern pattern = compile("[0,1]*");
        Matcher isNum = pattern.matcher(String.valueOf(num).trim());
        if (!isNum.matches()) {
            bool = true;
        }
        return bool;
    }

    // 获取当前时间

    /**
     * 获取当前时间
     */
    public static String getDateTime() {
        String dateTime;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = new Date();
        dateTime = df.format(dat.getTime());
        return dateTime;
    }

    // 字符to日期的转换

    /**
     * 字符to日期的转换
     */
    public static Date charTdate(String strDat) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dat = null;
        Date cDate;
        try {
            cDate = df.parse(strDat);
            dat = new java.sql.Date(cDate.getTime());
        } catch (ParseException e) {
        }
        return dat;
    }

    // 日期to字符

    /**
     * 日期to字符
     */
    public static String dateTchar(Date dat) {
        if (dat == null) {
            return "";
        }
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sim.format(dat.getTime());
        return strDate;
    }

    // 取出月份

    /**
     * 取出月份
     */
    public static String getMounth() {
        String month = "";
        SimpleDateFormat sim = new SimpleDateFormat("yyyyMM");
        Date dat = new Date();
        month = sim.format(dat.getTime());
        return month;
    }

    /**
     * 日期to字符
     *
     * @param dat
     * @return
     */
    public static String dateTchar1(Date dat) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyyMMdd");
        String strDate = sim.format(dat.getTime());
        return strDate;
    }

    /**
     * 验证字符串str长度是否超过数据库中字段的指定长度len
     *
     * @param str
     * @param len
     * @return
     */
    public static boolean checkLength(String str, int len) {

        if (null == str || "".equals(str.trim())) {
            return true;
        }
        byte[] tempCharArray = null;
        try {
            tempCharArray = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return tempCharArray == null || tempCharArray.length <= len;
    }

    /**
     * rs.get(**) 转为String (Date除外) zxq
     *
     * @param obj
     * @return
     */
    public static String stringRsGet(Object obj) {
        String chars = "Char";
        String str = "String";
        String bigDecimal = "BigDecimal";
        if (obj == null) {
            return "";
        } else if (str.equals(obj.getClass().getSimpleName()) || chars.equals(obj.getClass().getSimpleName())) {
            return (String) obj;
        } else if (bigDecimal.equals(obj.getClass().getSimpleName())) {
            return obj.toString();
        }
        return "";
    }

    /**
     * 整数校验 大于0
     */
    public static boolean isNumeric(String str) {
        if (isNull(str)) {
            return false;
        }
        return str.matches("\\d*");
    }

    /**
     * String -> Long
     *
     * @param str
     * @return
     */
    public static Long strToLong(String str) {
        if (isNull(str)) {
            return null;
        }
        return Long.valueOf(str);
    }
}
