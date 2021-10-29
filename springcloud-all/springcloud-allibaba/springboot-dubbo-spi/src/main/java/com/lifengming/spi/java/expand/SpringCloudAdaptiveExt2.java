package com.lifengming.spi.java.expand;

import org.apache.dubbo.common.URL;

/**
 * @author lifengming
 * @date 2020.12.12
 */
public class SpringCloudAdaptiveExt2 implements AdaptiveExt2{
    @Override
    public String echo(String msg, URL url) {
        return "Spring cloud";
    }
}
