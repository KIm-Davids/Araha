package com.semicolon.africa.arahasubcriptionapp.dtos.requests;


import com.semicolon.africa.arahasubcriptionapp.constants.CardType;
import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSubscriptionRequest {

    private SubscriptionType subscriptionType;
    private String paymentDesc;
    private double paymentAmount;
    private LocalDateTime paymentDate;
    private double discountAmount;
    private boolean isActive;
    private String user_id;
    private CardType cardType;
    private String userToken;
    private LocalDateTime localDateTime;

}
