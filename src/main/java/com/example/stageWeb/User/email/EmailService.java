package com.example.stageWeb.User.email;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmailService implements EmailSender{

    private static Logger logger= LoggerFactory.getLogger(EmailService.class);
    @Autowired
    private JavaMailSender mailSender ;


    public void send(String to, String email) throws MessagingException {



        MimeMessage mimeMessage =mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"utf-8");
        mimeMessageHelper.setText(email ,true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("Confirm your email");
        mimeMessageHelper.setFrom("mohamedaydi30@gmail.com");
        mailSender.send(mimeMessage);




    }
}