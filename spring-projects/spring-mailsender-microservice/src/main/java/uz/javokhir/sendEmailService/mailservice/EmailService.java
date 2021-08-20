package uz.javokhir.sendEmailService.mailservice;

import uz.javokhir.sendEmailService.model.request.EmailRequest;

public interface EmailService {

    void sendEmail(EmailRequest emailRequest);
}