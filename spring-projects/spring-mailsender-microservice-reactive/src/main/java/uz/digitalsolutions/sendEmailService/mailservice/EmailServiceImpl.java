package uz.digitalsolutions.sendEmailService.mailservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import uz.digitalsolutions.sendEmailService.model.EmailRequest;
import uz.digitalsolutions.sendEmailService.property.MailProperties;


import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    @Async
    @Override
    public Mono<ResponseEntity<?>> sendEmail(EmailRequest emailRequest) {
        log.info("Send email to {}, fullname {}, message {}", emailRequest.getUsersEmail(), emailRequest.getFullName(), emailRequest.getMessage());
        return Mono.fromCallable(() -> {
            try {
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
                message.setTo(mailProperties.getReceiver());
                message.setFrom(mailProperties.getSender());
                message.setSubject("From " +  emailRequest.getUsersEmail());
                message.setText("Fullname: " + emailRequest.getFullName() + "\nMessage: " + emailRequest.getMessage());
                javaMailSender.send(mimeMessage);
                return ResponseEntity.ok().body(emailRequest);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.internalServerError().build();
            }
        }).subscribeOn(Schedulers.parallel());
    }
}
