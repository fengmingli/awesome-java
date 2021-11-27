package com.lifengming.spi.java.expand;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author lifengming
 * @date 2020.12.12
 */
//@since 测试4
//@Adaptive
public class ThriftAdaptiveExt2 implements AdaptiveExt2 {
    @Override
    public String echo(String msg, URL url) {
        return "thrift";
    }
}
