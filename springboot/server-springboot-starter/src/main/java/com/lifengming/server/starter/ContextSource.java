package com.lifengming.server.starter;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lifengming
 * @since 2020.02.02
 */
@Setter
@Getter
public class ContextSource {
    private String hostName;
    private String registerUrl;

    public String getHost() {
        return "Hello" + hostName + "=注册地址为=" + registerUrl;
    }
}
