package ru.itfbgroup.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.itfbgroup.notificationservice.model.Customer;
import ru.itfbgroup.notificationservice.model.NotificationMessage;
import ru.itfbgroup.notificationservice.model.Order;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;

    public void sendNotificationMessage(NotificationMessage message){

        System.out.println(message);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(message.getEmail());
        msg.setSubject("Смена статуса заказа");

        msg.setText(message.getCustomerName() + " статус заказа №" + message.getOrderId() + " изменен на "
                + message.getOrderStatus().getValue() +"\nс уважением, ваша служба доставки!");

        mailSender.send(msg);
    }
}
