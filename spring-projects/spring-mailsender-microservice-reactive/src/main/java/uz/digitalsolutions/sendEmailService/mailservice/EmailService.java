package uz.digitalsolutions.sendEmailService.mailservice;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import uz.digitalsolutions.sendEmailService.model.EmailRequest;

public interface EmailService {

    Mono<ResponseEntity<?>> sendEmail(EmailRequest emailRequest);
}
