package ru.itfbgroup.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itfbgroup.notificationservice.model.NotificationMessage;
import ru.itfbgroup.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/notify")
    public void sendNotification(@RequestBody NotificationMessage message) throws Exception {

        if (message.isEmailEnabled()) {
            notificationService.sendNotificationMessage(message);
        }

        if (message.isPhoneEnabled()) {
            // Сервис отправки СМС
        }
    }
}
