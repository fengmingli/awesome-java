package com.lifengming.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

/**
 * @author lifengming
 * @date 2020.03.10
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Override
    public void sendSimpleMail(String[] to, String subject, String content, String... cc) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Objects.requireNonNull(javaMailSender.getUsername()));
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setCc(cc);
        javaMailSender.send(message);
    }

    @Override
    public void sendHtmlMail(String[] to, String subject, String content, String... cc) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, "UTF-8");
        mimeMessageHelper.setFrom(Objects.requireNonNull(javaMailSender.getUsername()));
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, true);
        mimeMessageHelper.setCc(cc);
        javaMailSender.send(message);
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath, String... cc) throws MessagingException {

    }

    @Override
    public void sendResourceMail(String to, String subject, String content, String rscPath, String rscId, String... cc) throws MessagingException {

    }
}
