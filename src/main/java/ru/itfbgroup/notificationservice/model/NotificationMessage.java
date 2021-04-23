package ru.itfbgroup.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationMessage {

    private static final String CREATE = "create";
    private static final String DELIVERY = "delivery";
    private static final String PAID = "paid";
    private static final String DONE = "done";

    private String template;
    private Map<String, Object> attributes;
    private List<Attachment> attachments;

    public void addAttributes(String name, Object value) {
        if (this.attributes == null) {
            attributes = new HashMap<>();
        }
        this.attributes.put(name, value);
    }

    public void addAttachment(Attachment attachment) {
        if (this.attachments == null) {
            attachments = new ArrayList<>();
        }
        this.attachments.add(attachment);
    }
}
