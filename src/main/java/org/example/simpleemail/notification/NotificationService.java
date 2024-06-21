package org.example.simpleemail.notification;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.simpleemail.email.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    private final ObjectMapper jsonMapper;


    private NotificationProducer notificationProducer;

    public NotificationService(NotificationProducer notificationProducer, ObjectMapper jsonMapper) {
        this.notificationProducer = notificationProducer;
        this.jsonMapper = jsonMapper;
    }

    public void notify(Email email) {

        ObjectNode objectNode = jsonMapper.createObjectNode();
        objectNode.put("email", email.getBody());

        LOGGER.info("notifying email {}...", objectNode);
        notificationProducer.sendNotification(email);
    }
}
