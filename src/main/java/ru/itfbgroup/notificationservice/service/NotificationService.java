package ru.itfbgroup.notificationservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.itfbgroup.notificationservice.component.TemplateProperty;
import ru.itfbgroup.notificationservice.model.Attachment;
import ru.itfbgroup.notificationservice.model.NotificationMessage;

import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;
    private final TemplateProperty templateProperty;

    public void sendNotificationMessage(NotificationMessage message) throws Exception {

        TemplateProperty.Template template = templateProperty.getTemplates().get(message.getTemplate());
        List<Attachment> attachments = message.getAttachments();
        Map<String, Object> attributes = message.getAttributes();
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
//        MimeMailMessage
//        System.out.println(message);
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(message.getEmail());
//        msg.setSubject("Смена статуса заказа");
//
//        msg.setText(message.getCustomerName() + " статус заказа №" + message.getOrderId() + " изменен на "
//                + message.getOrderStatus().getValue() + "\nC уважением, ваша служба доставки!");

//        mailSender.send(null);
    }
}
