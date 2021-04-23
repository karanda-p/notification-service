package ru.itfbgroup.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.itfbgroup.notificationservice.component.TemplateProperty;

@SpringBootApplication
@EnableConfigurationProperties(TemplateProperty.class)
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

}
