package com.gtt.smagtt.login.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendPasswordResetEmail(String toEmail, String token, String userName) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(toEmail);
            helper.setSubject("Password Reset Code");

            String content = "<html>"
                    + "<body>"
                    + "<p>Dear <strong>" + userName + "</strong>,</p>"
                    + "<p>You requested to reset your password. Use the code below:</p>"
                    + "<h2 style='font-size: 32px; font-weight: bold; color: black;'>" + token + "</h2>"
                    + "<p>This code will expire in 1 hour.</p>"
                    + "<p>If you didn’t request this, please ignore this email.</p>"
                    + "<br><p>Regards,<br>SMAGTT Support Team</p>"
                    + "</body>"
                    + "</html>";

            helper.setText(content, true); // Enable HTML

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
