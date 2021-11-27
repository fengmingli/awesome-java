package com.lifengming.springboot.swagger2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lifengming
 * @date 2020.02.28
 */
@Getter
@Setter
@AllArgsConstructor
public class Result implements Serializable {
    private boolean success;
    private String message;
}
