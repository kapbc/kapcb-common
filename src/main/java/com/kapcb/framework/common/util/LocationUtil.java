package com.kapcb.framework.common.util;

import cn.hutool.core.util.NumberUtil;
import com.kapcb.framework.common.constants.enums.DoublePool;
import lombok.experimental.UtilityClass;

/**
 * <a>Title: LocationUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: LocationUtil <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/19 22:53
 */
@UtilityClass
public class LocationUtil {

    private static double rad(double degrees) {
        return degrees * Math.PI / DoublePool.ONE_HUNDRED_EIGHTY_DEGREES.value();
    }

    /**
     * @param firstLongitude  经度
     * @param firstLatitude   纬度
     * @param secondLongitude 经度
     * @param secondLatitude  纬度
     * @return double
     */
    public static double getDistance(double firstLongitude, double firstLatitude, double secondLongitude, double secondLatitude) {
        double radLat1 = rad(firstLatitude);
        double radLat2 = rad(secondLatitude);
        double a = radLat1 - radLat2;
        double b = rad(firstLongitude) - rad(secondLongitude);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * DoublePool.EARTH_RADIUS.value();
        s = Math.round(s * 10000d) / 10000d;
        return NumberUtil.round(s, 2).doubleValue();
    }
}
