package com.kapcb.framework.common.constants.enums;

/**
 * <a>Title: DoublePool </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DoublePool <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/19 22:53
 */
public enum DoublePool {

    EARTH_RADIUS(6378.137, "earth‘s radius"),
    ONE_HUNDRED_EIGHTY_DEGREES(180.0, "one hundred and eighty degrees");
    
    private Double value;
    private String description;

    DoublePool(Double value, String description) {
        this.value = value;
        this.description = description;
    }

    public Double value(){
        return this.value;
    }
}
