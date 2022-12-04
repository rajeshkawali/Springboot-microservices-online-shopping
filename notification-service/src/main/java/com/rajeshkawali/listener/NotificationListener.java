package com.rajeshkawali.listener;

import com.rajeshkawali.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/**
 * @author Rajesh_Kawali
 *
 */
@Service
@Slf4j
public class NotificationListener {
    public static final String CLASS_NAME = NotificationListener.class.getName();

    @KafkaListener(topics = "notifyTopic", groupId = "notifyId")
    public void notificationListener(OrderPlacedEvent orderPlacedEvent) {
        String _function = ".notificationListener";
        log.info(CLASS_NAME + _function + "::ENTER");
        log.info(CLASS_NAME + _function + "::Received Notification for Order: {}", orderPlacedEvent.getOrderNumber());
        log.info(CLASS_NAME + _function + "::EXIT");
    }
}
