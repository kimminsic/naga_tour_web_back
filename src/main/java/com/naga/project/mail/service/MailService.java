package com.naga.project.mail.service;

import com.naga.project.User.DAO.Siteuser;
import com.naga.project.User.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender mailSender;
    private final UserRepository userRepository;

    
    //이메일 인증번호 전송
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

    
    //비밀번호 재설정 전송
    public String PwSend (String email, @RequestParam String userid){
        SimpleMailMessage message = new SimpleMailMessage();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String code = RandomStringUtils.randomAlphanumeric(12);

        Siteuser getUser = userRepository.findByUserid(userid).get(0);
        getUser.setPassword(bCryptPasswordEncoder.encode(code));
        userRepository.save(getUser);
        
        String msg = "임시비밀번호는"+code+"입니다";
        message.setTo(email);
        message.setSubject("임시 비밀번호 전송");
        message.setText(msg);
        System.out.println(code);
        mailSender.send(message);
        return code;
    }
}
