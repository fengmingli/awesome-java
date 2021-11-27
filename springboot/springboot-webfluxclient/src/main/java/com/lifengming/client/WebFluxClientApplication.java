package com.lifengming.client;

import com.lifengming.client.proxys.JDKProxyCreator;
import com.lifengming.client.proxys.ProxyCreator;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author lifengming
 * @date 2021.01.03
 */
@SpringBootApplication
public class WebFluxClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxClientApplication.class, args);
    }

    @Bean
    ProxyCreator jdkProxyCreator(){
        return new JDKProxyCreator();
    }

    @Bean
    FactoryBean<IUserApi> userApi(ProxyCreator proxyCreator) {
        return new FactoryBean<IUserApi>() {
            @Override
            public IUserApi getObject() {
                return (IUserApi) proxyCreator.createProxy(this.getObjectType());
            }

            @Override
            public Class<?> getObjectType() {
                return IUserApi.class;
            }
        };
    }
}
