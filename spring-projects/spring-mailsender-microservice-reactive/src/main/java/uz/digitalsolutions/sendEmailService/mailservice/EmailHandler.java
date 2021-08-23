package uz.digitalsolutions.sendEmailService.mailservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import uz.digitalsolutions.sendEmailService.model.EmailRequest;


@Service
@RequiredArgsConstructor
public class EmailHandler {

    private final EmailService emailService;

    public Mono<ServerResponse> sendEmail(ServerRequest serverRequest) {

        Mono<EmailRequest> emailToSend = serverRequest.bodyToMono(EmailRequest.class);
       return emailToSend.flatMap(emailRequest -> ServerResponse.ok()
                       .contentType(MediaType.APPLICATION_JSON)
                       .body(emailService.sendEmail(emailRequest), ResponseEntity.class));
    }


}
