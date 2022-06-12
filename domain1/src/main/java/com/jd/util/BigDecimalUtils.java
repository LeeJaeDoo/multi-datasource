package com.jd.util;

import java.math.BigDecimal;

import lombok.experimental.UtilityClass;

/**
 * @author Jaedoo Lee
 */
@UtilityClass
public class BigDecimalUtils {

    public static boolean isZero(BigDecimal value) {
        return value.equals(BigDecimal.ZERO);
    }

    public static boolean isGreaterThan(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) > 0;
    }

    public static boolean isSameOrGreaterThan(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) >= 0;
    }

    public static boolean islessThan(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) < 0;
    }

}
