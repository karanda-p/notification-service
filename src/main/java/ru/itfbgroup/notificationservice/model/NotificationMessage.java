package ru.itfbgroup.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationMessage {

    private String customerName;
    private String email;
    private String phone;
    private boolean emailEnabled;
    private boolean phoneEnabled;
    private Long orderId;
    private OrderStatus orderStatus;
}
