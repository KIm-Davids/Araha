package com.semicolon.africa.arahasubcriptionapp.data.models;

import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "subscription")
@Getter
@Setter
public class Subscription {

    @jakarta.persistence.Id
    @Id
    private String id;
    private String userToken;
    private SubscriptionType subscriptionType;
    private String paymentDesc;
    private double paymentAmount;
    private LocalDateTime paymentDate;
    private double discountAmount;
    private boolean isActive;
}
