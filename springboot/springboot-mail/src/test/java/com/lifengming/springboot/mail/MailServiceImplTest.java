package com.lifengming.springboot.mail;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * @author lifengming
 * @date 2020.03.10
 */
@SpringBootTest(classes = {MainApplication.class})
@RunWith(SpringRunner.class)
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    public void simpleMailTest() {
        String[] str = {"lifengming@mockuai.com"};
        String[] str1 = {"672457123@qq.com"};
        mailService.sendSimpleMail(str, "ceshi", "var1", str1);


    }

    @Test
    public void htmlMailTest() {

        String var1 = "<body style=\"color: #666; font-size: 14px; font-family: 'Open Sans',Helvetica,Arial,sans-serif;\">\n" +
                "<div class=\"box-content\" style=\"width: 80%; margin: 20px auto; max-width: 800px; min-width: 600px;\">\n" +
                "    <div class=\"header-tip\" style=\"font-size: 12px;\n" +
                "                                   color: #aaa;\n" +
                "                                   text-align: right;\n" +
                "                                   padding-right: 25px;\n" +
                "                                   padding-bottom: 10px;\">\n" +
                "        Confidential - Scale Alarm Use Only\n" +
                "    </div>\n" +
                "    <div class=\"info-top\" style=\"padding: 15px 25px;\n" +
                "                                 border-top-left-radius: 10px;\n" +
                "                                 border-top-right-radius: 10px;\n" +
                "                                 background: {0};\n" +
                "                                 color: #fff;\n" +
                "                                 overflow: hidden;\n" +
                "                                 line-height: 32px;\">\n" +
                "        <img src=\"cid:icon-alarm\" style=\"float: left; margin: 0 10px 0 0; width: 32px;\" /><div style=\"color:#010e07\"><strong>服务实例水平伸缩通知</strong></div>\n" +
                "    </div>\n" +
                "    <div class=\"info-wrap\" style=\"border-bottom-left-radius: 10px;\n" +
                "                                  border-bottom-right-radius: 10px;\n" +
                "                                  border:1px solid #ddd;\n" +
                "                                  overflow: hidden;\n" +
                "                                  padding: 15px 15px 20px;\">\n" +
                "        <div class=\"tips\" style=\"padding:15px;\">\n" +
                "            <p style=\" list-style: 160%; margin: 10px 0;\">Hi,</p>\n" +
                "            <p style=\" list-style: 160%; margin: 10px 0;\">hi</p>\n" +
                "        </div>\n" +
                "        <div class=\"time\" style=\"text-align: right; color: #999; padding: 0 15px 15px;\">hi</div>\n" +
                "        <br>\n" +
                "        <table class=\"list\" style=\"width: 100%; border-collapse: collapse; border-top:1px solid #eee; font-size:12px;\">\n" +
                "            <thead>\n" +
                "            <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;\">\n" +
                "                {3}\n" +
                "            </tr>\n" +
                "            </thead>\n" +
                "            <tbody>\n" +
                "            {4}\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n";
        String[] str = {"lifengming@mockuai.com"};
        String[] str1 = {"672457123@qq.com"};
        try {
            mailService.sendHtmlMail(str, "测试", var1, str1);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
