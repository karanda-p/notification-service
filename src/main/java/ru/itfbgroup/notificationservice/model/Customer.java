package ru.itfbgroup.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    private Long id;
    private String login;
    private String password;
    private String phone;
    private Long cartId;
    private String email;
    private boolean emailNotification;
    private boolean phoneNotification;
}
