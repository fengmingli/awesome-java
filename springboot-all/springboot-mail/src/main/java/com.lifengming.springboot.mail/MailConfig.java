package com.lifengming.springboot.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * 发邮件基本配置
 * @author lifengming
 * @date 2020.06.05
 */
@Configuration
public class MailConfig {

    @Bean
    public JavaMailSenderImpl javaMailSenderImpl() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(MailConstant.ALIYUN_DEFAULT_HOST);
        javaMailSender.setUsername(MailConstant.ALIYUN_DEFAULT_USER_NAME);
        javaMailSender.setPassword(MailConstant.ALIYUN_DEFAULT_MM);
        javaMailSender.setDefaultEncoding(MailConstant.DEFAULT_ENCODING);

        Properties properties = new Properties();
        //设置链接超时
        properties.setProperty(MailPropertiesEnum.MAIL_SMTP_TIMEOUT.getPropertiesName(),
                MailPropertiesEnum.MAIL_SMTP_TIMEOUT.getPropertiesValue());
        //设置通过ssl协议使用465端口发送、使用默认端口（25）时下面三行不需要
        //开启认证
        properties.setProperty(MailPropertiesEnum.MAIL_SMTP_AUTH.getPropertiesName(),
                MailPropertiesEnum.MAIL_SMTP_AUTH.getPropertiesValue());
        //设置ssl端口
        properties.setProperty(MailPropertiesEnum.MAIL_SMTP_PORT.getPropertiesName(),
                MailPropertiesEnum.MAIL_SMTP_PORT.getPropertiesValue());
        properties.setProperty(MailPropertiesEnum.MAIL_SMTP_SOCKET_FACTORY.getPropertiesName(),
                MailPropertiesEnum.MAIL_SMTP_SOCKET_FACTORY.getPropertiesValue());
        javaMailSender.setJavaMailProperties(properties);

        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

}
