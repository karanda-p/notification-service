package ru.itfbgroup.notificationservice.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = "app")
public class TemplateProperty {

    private Map<String, Template> templates;

    @Data
    public static class Template {

        private String path;
        private String subject;

    }

}
