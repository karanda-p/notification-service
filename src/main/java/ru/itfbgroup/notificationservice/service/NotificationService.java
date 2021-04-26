package ru.itfbgroup.notificationservice.service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import ru.itfbgroup.notificationservice.component.TemplateProperty;
import ru.itfbgroup.notificationservice.model.Attachment;
import ru.itfbgroup.notificationservice.model.NotificationMessage;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final JavaMailSender mailSender;
    private final TemplateProperty templateProperty;
    @Qualifier("emailConfigBean")
    private final Configuration emailConfig;

    public void sendNotificationMessage(NotificationMessage message) throws Exception {

        TemplateProperty.Template template = templateProperty.getTemplates().get(message.getTemplate());
        List<Attachment> attachments = message.getAttachments();

        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        Template messageTemplate = emailConfig.getTemplate(template.getPath());
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(messageTemplate, message.getAttributes());

        helper.setTo(message.getEmail());
        helper.setText(html, true);
        helper.setSubject(template.getSubject());

        if (attachments != null) {
            for (Attachment attachment : attachments) {
                byte[] decodedBytes = Base64.getDecoder().decode(attachment.getContent());
                File file = new File(attachment.getFileName());
                FileUtils.writeByteArrayToFile(file, decodedBytes);
                helper.addAttachment(attachment.getFileName(), file);
            }
        }

        mailSender.send(msg);
    }
}
