package com.lifengming.server.starter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lifengming
 * @since 2020.02.02
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "lfm")
public class RegisterConfigProperties {
    private String hostName;

    @Value("${lfm.register.client.url}")
    private String registerUrl;
}
