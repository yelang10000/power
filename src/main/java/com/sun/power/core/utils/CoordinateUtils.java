package com.sun.power.core.utils;

/**
 * @author: 朱星晨
 * @date: 2019/7/29
 */
public class CoordinateUtils {
    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return 距离
     */
    public static double getDistance(double lng1, double lat1,
                                     double lng2,double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }


    /**
     * 经纬度校验，只校验正数 0-90.000000 0-180.000000 范围内
     * 经度longitude: (?:[0-9]|[1-9][0-9]|1[0-7][0-9]|180)\\.([0-9]{6})
     * 纬度latitude：  (?:[0-9]|[1-8][0-9]|90)\\.([0-9]{6})
     * @return
     */
    public static boolean checkItude(Double longitude,Double latitude){
        if (longitude==null||latitude==null){
            return false;
        }
//        String reglo = "((?:[0-9]|[1-9][0-9]|1[0-7][0-9])\\.([0-9]{0,6}))|((?:180)\\.([0]{0,6}))";
//        String regla = "((?:[0-9]|[1-8][0-9])\\.([0-9]{0,6}))|((?:90)\\.([0]{0,6}))";
//        longitude = longitude.trim();
//        latitude = latitude.trim();
        return true;
    }

    public static void main(String[] args) {
        Long distance = (long) getDistance(116.368921	,39.882108,
                116.361332,	39.886505);
        System.out.println("距离" + distance + "米");
    }

}