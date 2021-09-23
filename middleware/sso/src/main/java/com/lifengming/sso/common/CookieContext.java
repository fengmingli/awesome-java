package com.lifengming.sso.common;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lifengming
 * @date 2021.09.23
 */
@Setter
@Getter
public class CookieContext {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String name;
    private String value;
    private int version = 0;
    private String comment;
    private String domain;
    private int maxAge = -1;
    private String path;
    private boolean secure;
    private boolean httpOnly;
    private String sameSite;
}
