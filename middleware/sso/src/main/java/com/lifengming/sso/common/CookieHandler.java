package com.lifengming.sso.common;

/**
 * @author lifengming
 * @date 2021.09.23
 */
public interface CookieHandler {

    /**
     * Add new Cookie
     * @param cookieContext CookieContext
     */
    public void addCookie(CookieContext cookieContext);

    /**
     * Get Cookie
     * @param cookieContext CookieContext
     * @return Cookie string
     */
    public String getCookie(CookieContext cookieContext);

    /**
     * Remove Cookie
     * @param cookieContext CookieContext
     */
    public void removeCookie(CookieContext cookieContext);
}
