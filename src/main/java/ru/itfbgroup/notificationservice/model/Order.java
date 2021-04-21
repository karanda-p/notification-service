package ru.itfbgroup.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    private Long id;
    private Long customerId;
    private Long restaurantId;
    private String address;
    private OrderStatus status;
    private LocalDateTime creationDate;
    private String doneDate;
    private double amount;
}
