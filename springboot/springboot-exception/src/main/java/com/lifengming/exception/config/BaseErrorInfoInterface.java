package com.lifengming.exception.config;

/**
 * @author lifengming
 * @date 2020.11.28
 */
public interface BaseErrorInfoInterface {
    /**
     * 错误码
     * @return 错误码
     */
    String getResultCode();

    /**
     * 错误描述
     * @return 错误描述
     * */
    String getResultMsg();
}
