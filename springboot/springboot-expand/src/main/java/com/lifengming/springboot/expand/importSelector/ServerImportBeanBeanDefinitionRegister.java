package com.lifengming.springboot.expand.importSelector;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * @author lifengming
 * @date 2020.12.06
 */
public class ServerImportBeanBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //复用（@link ServerImportSelector）实现，避免重复劳动
        ServerImportSelector importSelector = new ServerImportSelector();
        //赛选CLASS 名称集合
        String[] selectClassNames = importSelector.selectImports(importingClassMetadata);
        Stream.of(selectClassNames)
                //转化为BeanDefinitionBuilder对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                //转化为BeanDefinition
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition ->
                        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry)
                );
    }
}
