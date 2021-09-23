package com.lifengming.sso.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;

/**
 * @author lifengming
 * @date 2021.09.23
 */
public abstract class CookieHelper implements CookieHandler {
    private static final Logger log = LoggerFactory.getLogger(CookieHelper.class);

    @Override
    public void addCookie(CookieContext cookieContext) {
        CookieWrapper cookie = new CookieWrapper(cookieContext.getName(), cookieContext.getValue());
        if (cookieContext.getPath() != null) {
            cookie.setPath(cookieContext.getPath());
        }
        cookie.setHttpOnly(true);
        // secure & sameSite must be set together
        cookie.setSecure(true);
        cookie.setSameSite(cookieContext.getSameSite());
        String header = CookieSameSiteSupport.generateHeader(cookie);
        cookieContext.getResponse().addHeader("Set-Cookie",header);
    }

    @Override
    public String getCookie(CookieContext cookieContext) {
        Cookie[] cookies = cookieContext.getRequest().getCookies();
        if (cookies == null || StringUtils.isEmpty(cookieContext.getName())) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookieContext.getName().equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    @Override
    public void removeCookie(CookieContext cookieContext) {

    }
}
