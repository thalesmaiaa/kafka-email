package org.example.simpleemail.email;

import org.example.simpleemail.notification.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    private final NotificationService notificationService;


    public EmailService(EmailRepository emailRepository, NotificationService notificationService) {
        this.emailRepository = emailRepository;
        this.notificationService = notificationService;
    }


    public Email sendEmail(Email email) throws InterruptedException {
        Email emailToSave = new Email(email.getTitle(), email.getSubject(), email.getBody());
        emailRepository.save(emailToSave);

        notificationService.notify(emailToSave);

        return emailToSave;

    }


}
