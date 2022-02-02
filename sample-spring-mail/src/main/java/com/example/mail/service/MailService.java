package com.example.mail.service;

import com.example.mail.dto.MailDto;
import com.example.mail.util.MailHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author sskim
 */
@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "";

    public void mailSend(MailDto mailDto) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mailDto.getAddress());
        simpleMailMessage.setFrom(FROM_ADDRESS);
        simpleMailMessage.setSubject(mailDto.getTitle());
        simpleMailMessage.setText(mailDto.getMessage());

        mailSender.send(simpleMailMessage);
    }

    public void mailSendWithResource(MailDto mailDto) {
        try {
            MailHandler mailHandler = new MailHandler(mailSender);

            // 받는 사람
            mailHandler.setTo(mailDto.getAddress());
            // 보내는 사람
            mailHandler.setFrom(MailService.FROM_ADDRESS);
            // 제목
            mailHandler.setSubject(mailDto.getTitle());
            // HTML Layout
            String htmlContent = "<p>" + mailDto.getMessage() + "<p> <img src='cid:sample-img'>";
            mailHandler.setText(htmlContent, true);
            // 첨부 파일
            mailHandler.setAttach("sample-text.txt", "static/sample-text.txt");
            // 이미지 삽입
            mailHandler.setInline("sample-img", "static/sample.jpg");

            mailHandler.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
