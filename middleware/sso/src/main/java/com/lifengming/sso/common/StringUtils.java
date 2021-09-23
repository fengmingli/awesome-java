package com.lifengming.sso.common;

/**
 * @author lifengming
 * @date 2021.09.23
 */
public class StringUtils {

    public StringUtils() {
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

}
