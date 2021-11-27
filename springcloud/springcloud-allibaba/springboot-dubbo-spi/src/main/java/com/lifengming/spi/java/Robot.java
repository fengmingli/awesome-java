package com.lifengming.spi.java;

import com.lifengming.spi.java.spi.Ordered;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author lifengming
 * @date 2020.04.07
 */
@SPI
public interface Robot extends Ordered {
    void sayHello();
}
