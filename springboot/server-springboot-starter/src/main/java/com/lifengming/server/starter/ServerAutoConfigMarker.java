package com.lifengming.server.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lifengming
 * @since 2020.02.02
 */
@Configuration
public class ServerAutoConfigMarker {

    @Bean
    public Marker eurekaServerMarkerBean() {
        return new Marker();
    }

    static class Marker {
    }
}
