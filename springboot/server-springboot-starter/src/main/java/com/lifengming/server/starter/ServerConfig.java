package com.lifengming.server.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lifengming
 * @since 2020.02.02
 */
@Configuration
@ConditionalOnBean(ServerAutoConfigMarker.class)
@EnableConfigurationProperties(RegisterConfigProperties.class)
@SuppressWarnings("all")
public class ServerConfig {
    @Autowired
    RegisterConfigProperties properties;

    @Bean
    public ContextSource contextSource() {
        ContextSource ctx = new ContextSource();
        ctx.setHostName(properties.getHostName());
        ctx.setRegisterUrl(properties.getRegisterUrl());
        return ctx;
    }
}
