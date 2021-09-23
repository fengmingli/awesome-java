package com.lifengming.sso.common;

import javax.servlet.http.Cookie;

/**
 * @author lifengming
 * @date 2021.09.23
 */
public class CookieWrapper extends Cookie {
    private String sameSite;

    /**
     * Constructs a cookie with the specified name and value.
     *
     * <p>The name must conform to RFC 2109. However, vendors may
     * provide a configuration option that allows cookie names conforming
     * to the original Netscape Cookie Specification to be accepted.
     *
     * <p>The name of a cookie cannot be changed once the cookie has
     * been created.
     *
     * <p>The value can be anything the server chooses to send. Its
     * value is probably of interest only to the server. The cookie's
     * value can be changed after creation with the
     * <code>setValue</code> method.
     *
     * <p>By default, cookies are created according to the Netscape
     * cookie specification. The version can be changed with the
     * <code>setVersion</code> method.
     *
     * @param name the name of the cookie
     *
     * @param value the value of the cookie
     *
     * @throws IllegalArgumentException    if the cookie name is null or
     * empty or contains any illegal characters (for example, a comma,
     * space, or semicolon) or matches a token reserved for use by the
     * cookie protocol
     *
     * @see #setValue
     * @see #setVersion
     */
    public CookieWrapper(String name, String value) {
        super(name, value);
    }

    public void setSameSite(String sameSite) {
        this.sameSite = sameSite;
    }

    public String getSameSite() {
        return sameSite;
    }
}
