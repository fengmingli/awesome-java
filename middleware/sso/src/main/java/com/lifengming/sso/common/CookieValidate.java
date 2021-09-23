package com.lifengming.sso.common;

import java.util.BitSet;

/**
 * @author lifengming
 * @date 2021.09.23
 */
public class CookieValidate {

    private static final BitSet DOMAIN_VALID = new BitSet(128);

    public static void validateDomain(String domain) {
        int i = 0;
        int prev = -1;
        int cur = -1;
        char[] chars = domain.toCharArray();
        while (i < chars.length) {
            prev = cur;
            cur = chars[i];
            if (!DOMAIN_VALID.get(cur)) {
                throw new IllegalArgumentException(domain);
            }
            // labels must start with a letter or number
            if ((prev == '.' || prev == -1) && (cur == '.' || cur == '-')) {
                throw new IllegalArgumentException(domain);
            }
            // labels must end with a letter or number
            if (prev == '-' && cur == '.') {
                throw new IllegalArgumentException(domain);
            }
            i++;
        }
        // domain must end with a label
        if (cur == '.' || cur == '-') {
            throw new IllegalArgumentException(domain);
        }
    }


    public static void validatePath(String path) {
        char[] chars = path.toCharArray();

        for (char ch : chars) {
            if (ch < 0x20 || ch > 0x7E || ch == ';') {
                throw new IllegalArgumentException(path);
            }
        }
    }

    public static void validateCookieValue(String value) {
        int start = 0;
        int end = value.length();

        if (end > 1 && value.charAt(0) == '"' && value.charAt(end - 1) == '"') {
            start = 1;
            end--;
        }

        char[] chars = value.toCharArray();
        for (int i = start; i < end; i++) {
            char c = chars[i];
            if (c < 0x21 || c == 0x22 || c == 0x2c || c == 0x3b || c == 0x5c || c == 0x7f) {
                throw new IllegalArgumentException(Integer.toString(c));
            }
        }
    }
}
