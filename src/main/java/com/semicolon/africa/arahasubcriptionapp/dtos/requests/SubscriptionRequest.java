package com.semicolon.africa.arahasubcriptionapp.dtos.requests;

import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SubscriptionRequest {

    private String userToken;
    private SubscriptionType subscriptionType;
    private String subscriptionDesc;
    private double amount;
    private LocalDateTime localDateTime;
}
