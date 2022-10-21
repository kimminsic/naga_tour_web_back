package com.naga.project.mail.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender mailSender;


    public String sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        String code = RandomStringUtils.randomAlphanumeric(6);
        String msg = "인증코드는 " + code + " 입니다.";
        message.setTo(email);
        message.setSubject("인증코드 확인 메일");
        message.setText(msg);
        System.out.println(code);
        mailSender.send(message);
        return code;
    }
}
