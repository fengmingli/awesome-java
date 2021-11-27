package com.lifengming.springboot.mail;

/**
 * @author lifengming
 * @date 2020.06.05
 */
public enum MailPropertiesEnum {

    /**阿里云相关参数配置*/
    MAIL_SMTP_TIMEOUT("mail.smtp.timeout", "1000"),
    MAIL_SMTP_AUTH("mail.smtp.auth", "true"),
    MAIL_SMTP_PORT("mail.smtp.socketFactory.port", "465"),
    MAIL_SMTP_SOCKET_FACTORY("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"),

    ;
    /**
     * 参数名
     */
    private final String propertiesName;

    /**
     * 参数内容
     */
    private final String propertiesValue;


    MailPropertiesEnum(String propertiesName, String propertiesValue) {
        this.propertiesName = propertiesName;
        this.propertiesValue = propertiesValue;
    }

    public String getPropertiesName() {
        return propertiesName;
    }

    public String getPropertiesValue() {
        return propertiesValue;
    }

}

