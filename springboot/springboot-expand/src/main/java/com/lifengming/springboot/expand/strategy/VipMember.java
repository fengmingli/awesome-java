package com.lifengming.springboot.expand.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mockuai
 */
@Service("vipMember")
public class VipMember  implements Strategy {

	@Override
	public BigDecimal calculatePrice() {
		return new BigDecimal("80");
	}
}

