package com.lifengming.springboot.expand.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author lifengming
 * @date 2020.12.06
 */
public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //读取EnableServer中的所有属性方法
        //其中key为属性方法的名称，value为属性方法的返回对象
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());

        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationAttributes);
        Server.Type type = (Server.Type) attributes.get("type");

        //导入的类名称数组
        String[] importClassNames = new String[0];

        switch (type){
            case HTTP:
                importClassNames=new String[]{HttpServer.class.getName()};
                break;
            case FTP:
                importClassNames=new String[]{FtpServer.class.getName()};
                break;
            default:
                break;
        }
        return importClassNames;
    }
}
