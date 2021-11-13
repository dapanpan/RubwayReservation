package com.example.hatchersign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class mailService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendSimpleMail(String toEmail,String text) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("854265824@qq.com");
        message.setTo(toEmail);
        message.setSubject("北京地铁预约通知！请查看邮件正文");
        message.setText(text);

        mailSender.send(message);
    }

}
