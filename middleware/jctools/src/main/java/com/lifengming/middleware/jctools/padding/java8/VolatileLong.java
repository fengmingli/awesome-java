package com.lifengming.middleware.jctools.padding.java8;

import sun.misc.Contended;

/**
 * @author mockuai
 */
@Contended
public class VolatileLong {
    public volatile long value = 0L;
}
