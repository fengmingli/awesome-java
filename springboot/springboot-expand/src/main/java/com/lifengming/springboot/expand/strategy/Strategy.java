package com.lifengming.springboot.expand.strategy;

import java.math.BigDecimal;

/**
 * @author lifengming
 * @date 2020.08.07
 */
public interface Strategy {
    /**
     * 计算价格：共同行为
     * @return /
     */
    public BigDecimal calculatePrice();

}
