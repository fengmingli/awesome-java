package com.lifengming.springboot.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lifengming
 * @date 2021.01.27
 */
public class TestLogging {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestLogging.class);
        logger.info("Hello SLF4J");
        logger.error("ERROR");
    }
}
