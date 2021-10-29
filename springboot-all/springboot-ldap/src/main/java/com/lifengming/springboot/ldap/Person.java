package com.lifengming.springboot.ldap;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;

import javax.naming.Name;

/**
 * @author lifengming
 * @date 2020.12.23
 */
@ToString
@Entry(base = "OU=中间件中心,OU=xxxx,DC=xxxx,DC=com", objectClasses = {"user","top"})
@Data
public class Person {
    @Id
    private Name id;
//    @DnAttribute(value = "uid", index = 3)
//    private String uid;
    @Attribute(name = "cn")
    private String commonName;
    @Attribute(name = "sn")
    private String suerName;
    @Attribute
    private String mail;
}
