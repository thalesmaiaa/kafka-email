package org.example.simpleemail.email;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @PostMapping
    public Email sendEmail(@RequestBody Email email) throws InterruptedException {
        return emailService.sendEmail(email);
    }
}
