package uz.digitalsolutions.sendEmailService.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:application.properties")
public class MailProperties {

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${spring.mail.username}")
    private String receiver;
}