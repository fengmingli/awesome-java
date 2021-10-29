package com.lifengming.springboot.expand.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mockuai
 */
@Service("generalMember")
public class GeneralMember implements Strategy {

	@Override
	public BigDecimal calculatePrice() {
		return new BigDecimal("100");
	}
}

