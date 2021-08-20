package uz.javokhir.sendEmailService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.javokhir.sendEmailService.mailservice.EmailService;
import uz.javokhir.sendEmailService.model.request.EmailRequest;

@RestController
@RequestMapping(value = "email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
        System.out.println(request);
        emailService.sendEmail(request);
        return ResponseEntity.ok().build();
    }
//        if (result)
//            return ResponseEntity.ok("Email Sent Successfully... ");
//        else
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email sending failed");

}