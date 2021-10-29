package com.lifengming.common.serialization.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lifengming
 * @since 2019.12.09
 */
@Setter
@Getter
public class HeartbeatMessage implements Serializable {
    private static final long serialVersionUID = -6592061393725326744L;
    String headType = "head_beat";
}
