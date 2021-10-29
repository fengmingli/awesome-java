package com.lifengming.common.spring;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import javax.validation.constraints.NotNull;

/**
 * 获取spring的属性配置的工具类
 *
 * @author lifengming
 * @since 2019.12.31
 */
@Component
public class PropertiesUtils implements EmbeddedValueResolverAware {
    private StringValueResolver stringValueResolver;

    @Override
    public void setEmbeddedValueResolver( StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }

    /**
     * 获取属性，直接传入属性名称即可
     *
     * @param name 属性名
     * @return value
     */
    public String getPropertiesValue(String name) {
        String result;
        try {
            result = stringValueResolver.resolveStringValue("${" + name + "}");
        } catch (IllegalArgumentException e) {
            result = null;
        }
        return result;
    }
}
