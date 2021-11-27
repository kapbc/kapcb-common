package com.kapcb.framework.common.constants.enums;


/**
 * <a>Title: IntegerPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:39
 */
public enum IntegerPool implements IEnumPool<Integer> {

    ZERO(0, "number 0"),
    ONE(1, "number 1"),
    MINUS_ONE(-1, "负1"),
    FOUR(4, "number 4"),
    FIVE(5, "number 5"),
    TEN(10, "number 10"),
    THIRTY(30, "number 30"),
    TWO_HUNDRED_FIFTY_SIX(256, "number 256"),

    RGB_0xFF0(0xFF000000, "rgb oxff00000"),
    RGB_0xFFF(0xFFFFFFFF, "rgb oxfffffff");

    private Integer value;
    private String description;

    IntegerPool(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer value() {
        return this.value;
    }
}