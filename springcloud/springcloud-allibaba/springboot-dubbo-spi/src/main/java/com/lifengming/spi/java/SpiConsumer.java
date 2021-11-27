package com.lifengming.spi.java;

import com.lifengming.spi.java.spi.Ordered;

import java.util.List;
import java.util.Optional;

/**
 * @author lifengming
 * @date 2021.01.23
 */
public interface SpiConsumer extends Ordered {

    /**
     * 创建
     * @return /
     */
    default Optional<List<String>> createPath() {
        return Optional.empty();
    }
}
