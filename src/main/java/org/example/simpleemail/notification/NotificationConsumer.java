package org.example.simpleemail.notification;

import jakarta.mail.internet.MimeMessage;
import org.example.simpleemail.email.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {


    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender javaMailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

    public NotificationConsumer(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @KafkaListener(topics = "email-notification", groupId = "simple-email")
    public void receiveNotification(Email email){

        LOGGER.info("received email notification: {}", email);
        sendEmail(email);
    }


    public void sendEmail(Email email)  {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(email.getTo());
            mimeMessageHelper.setText(email.getBody(), true);
            mimeMessageHelper.setSubject(email.getSubject());

            javaMailSender.send(mimeMessage);
        } catch (Exception exception) {
            exception.printStackTrace();
            LOGGER.error("Error sending email: {}", exception.getMessage());
        }
    }
}
