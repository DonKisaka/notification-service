package com.example.notification_service.service;

import com.example.notification_service.event.OrderNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @KafkaListener(topics = "order-placed", groupId = "notification-service")
    public void getOrderNumber(String orderId) {
        log.info("Received order id: {}", orderId);
    }


    @KafkaListener(topics = "order-placed-email", groupId = "notification-service")
    public void getOrderNotification(OrderNotification orderNotification) {
        log.info("Received order id: {}", orderNotification.getOrderId());

        // Send notification
        log.info("Notification Sent: {}", orderNotification.toString());
    }
}
