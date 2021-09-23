package com.lifengming.sso.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * @author lifengming
 * @date 2021.09.23
 */
public class CookieSameSiteSupport {
    private static final Logger log = LoggerFactory.getLogger(CookieSameSiteSupport.class);

    private static final BitSet DOMAIN_VALID = new BitSet(128);

    static {
        for (char c = '0'; c <= '9'; c++) {
            DOMAIN_VALID.set(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            DOMAIN_VALID.set(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            DOMAIN_VALID.set(c);
        }
        DOMAIN_VALID.set('.');
        DOMAIN_VALID.set('-');
    }


    public Charset getCharset() {
        return StandardCharsets.UTF_8;
    }


    public static String generateHeader(CookieWrapper cookie) {

        // Can't use StringBuilder due to DateFormat
        StringBuffer header = new StringBuffer();
        header.append(cookie.getName());
        header.append('=');
        String value = cookie.getValue();
        if (value != null && value.length() > 0) {
            CookieValidate.validateCookieValue(value);
            header.append(value);
        }

        // RFC 6265 prefers Max-Age to Expires but... (see below)
        int maxAge = cookie.getMaxAge();
        if (maxAge > -1) {
            // Negative Max-Age is equivalent to no Max-Age
            header.append("; Max-Age=");
            header.append(maxAge);

            // Microsoft IE and Microsoft Edge don't understand Max-Age so send
            // expires as well. Without this, persistent cookies fail with those
            // browsers. See http://tomcat.markmail.org/thread/g6sipbofsjossacn

            // Wdy, DD-Mon-YY HH:MM:SS GMT ( Expires Netscape format )
            header.append("; Expires=");
            // To expire immediately we need to set the time in past
            if (maxAge == 0) {
                header.append(ANCIENT_DATE);
            } else {
                COOKIE_DATE_FORMAT.get().format(
                        new Date(System.currentTimeMillis() + maxAge * 1000L),
                        header,
                        new FieldPosition(0));
            }
        }

        String domain = cookie.getDomain();
        if (domain != null && domain.length() > 0) {
            CookieValidate.validateDomain(domain);
            header.append("; Domain=");
            header.append(domain);
        }

        String path = cookie.getPath();
        if (path != null && path.length() > 0) {
            CookieValidate.validatePath(path);
            header.append("; Path=");
            header.append(path);
        }

        if (cookie.getSecure()) {
            header.append("; Secure");
        }

        if (cookie.isHttpOnly()) {
            header.append("; HttpOnly");
        }
        String sameSite = cookie.getSameSite();
        if (sameSite != null && sameSite.length() > 0) {
            CookieValidate.validateCookieValue(sameSite);
            header.append("; SameSite=");
            header.append(sameSite);
        }
        return header.toString();

    }

    private static final String COOKIE_DATE_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";

    protected static final ThreadLocal<DateFormat> COOKIE_DATE_FORMAT =
            ThreadLocal.withInitial(() -> {
                DateFormat df =
                        new SimpleDateFormat(COOKIE_DATE_PATTERN, Locale.US);
                df.setTimeZone(TimeZone.getTimeZone("GMT"));
                return df;
            });
    protected static final String ANCIENT_DATE;

    static {
        ANCIENT_DATE = COOKIE_DATE_FORMAT.get().format(new Date(10000));
    }

}
