package uz.javokhir.sendEmailService.mailservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uz.javokhir.sendEmailService.model.request.EmailRequest;
import uz.javokhir.sendEmailService.property.MailProperties;


import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    @Async
    @Override
    public void sendEmail(EmailRequest emailRequest) {
        log.info("Send email to {}, fullName {}, message {}",
                mailProperties.getReceiver(), emailRequest.getFullName(), emailRequest.getMessage());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
            message.setTo(mailProperties.getSender());
            message.setFrom(mailProperties.getReceiver());
            message.setSubject(emailRequest.getSubject());
            message.setText(" FullName: " + emailRequest.getFullName() + "\nMessage: " + emailRequest.getMessage());
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
