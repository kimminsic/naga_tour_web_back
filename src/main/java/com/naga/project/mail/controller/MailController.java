package com.naga.project.mail.controller;

import com.naga.project.mail.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @GetMapping("/mail")
    public String execMail(@RequestParam Map<String, String> email){
        return mailService.sendMail(email.get("email"));
    }

    @GetMapping("/sendPw")
    public String PwMail(@RequestParam Map<String, String> email,@RequestParam String userid){
        return mailService.PwSend(email.get("email"),userid);
    }


}