package com.lifengming.spi.java.expand;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * 需要被扩展的接口，注意要加上@SPI注解
 * @author lifengming
 * @date 2020.12.12
 */

@SPI("dubbo")
public interface AdaptiveExt2 {

    @Adaptive({"t"})
    String echo(String msg, URL url);
}
