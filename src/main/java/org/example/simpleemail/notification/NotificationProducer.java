package org.example.simpleemail.notification;

import org.example.simpleemail.email.Email;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private final KafkaTemplate<String, Email> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, Email> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(Email email) {
        kafkaTemplate.send("email-notification", email);
    }

}
