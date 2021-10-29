package com.lifengming.springboot.mail;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author lifengming
 * @date 2020.05.31
 */
@SpringBootTest(classes = {MainApplication.class})
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void sendMail() {
        //简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("lifengming@mockuai.com");
        simpleMailMessage.setFrom("zmdls@mockuai.com");
        simpleMailMessage.setSubject("mockuai666");
        simpleMailMessage.setText("mockuai666！");
        mailSender.send(simpleMailMessage);
    }


    @Test
    public void mainSendTest() {
        Assert.assertTrue(checkEmailFormat("lzmdls@mockuai.com"));
        Assert.assertTrue(checkEmailFormat("lfm940624@163.com"));
        Assert.assertTrue(checkEmailFormat("672457123@qq.com"));

    }

    private boolean checkEmailFormat(String content){
        /*
         * " \w"：匹配字母、数字、下划线。等价于'[A-Za-z0-9_]'。
         * "|"  : 或的意思，就是二选一
         * "*" : 出现0次或者多次
         * "+" : 出现1次或者多次
         * "{n,m}" : 至少出现n个，最多出现m个
         * "$" : 以前面的字符结束
         */
        String REGEX="^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher=p.matcher(content);

        return matcher.matches();
    }
}
