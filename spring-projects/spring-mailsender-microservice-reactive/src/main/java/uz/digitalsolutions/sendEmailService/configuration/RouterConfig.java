package uz.digitalsolutions.sendEmailService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import uz.digitalsolutions.sendEmailService.mailservice.EmailHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> emailRouter(EmailHandler emailHandler) {
        return route(POST("/send-email"), emailHandler::sendEmail);
    }

}
