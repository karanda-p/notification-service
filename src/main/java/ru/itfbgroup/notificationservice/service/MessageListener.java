package ru.itfbgroup.notificationservice.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.itfbgroup.notificationservice.model.NotificationMessage;

@Data
@RequiredArgsConstructor
@Slf4j
@Component
public class MessageListener {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${message.queue}")
    public void receive(NotificationMessage message) throws Exception {
        log.info("Listening");
        notificationService.sendNotificationMessage(message);
        Thread.sleep(1000);
    }

}
