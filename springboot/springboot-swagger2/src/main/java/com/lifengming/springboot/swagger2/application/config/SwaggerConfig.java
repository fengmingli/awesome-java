package com.lifengming.springboot.swagger2.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(restApiInfo())
                .select()
                // 指定包名
                .apis(RequestHandlerSelectors.basePackage("com.lifengming.springboot.swagger2.application.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo restApiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger2构建api文档")
                .description("简单优雅的restful风格")
                .termsOfServiceUrl("no terms of serviceUrl")
                .version("1.0")
                .build();
    }
}