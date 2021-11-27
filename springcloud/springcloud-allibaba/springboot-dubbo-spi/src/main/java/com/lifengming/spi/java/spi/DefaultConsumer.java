package com.lifengming.spi.java.spi;

import com.lifengming.spi.java.SpiConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lifengming
 * @date 2021.01.23
 */
public class DefaultConsumer implements SpiConsumer {

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Optional<List<String>> createPath() {
        List<String> path = new ArrayList<>();
        String applicationPath = "/spi/sentinel";
        path.add(applicationPath);
        return Optional.of(path);
    }
}
