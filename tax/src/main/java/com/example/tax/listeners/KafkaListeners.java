package com.example.tax.listeners;

import com.example.tax.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    Logger log = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = "redevable", groupId = "kf-group-1")
    void redevable_listener(User data) {
        log.debug(data.toString());
    }

}
