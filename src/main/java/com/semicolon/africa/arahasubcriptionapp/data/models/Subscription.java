package com.semicolon.africa.arahasubcriptionapp.data.models;

import com.semicolon.africa.arahasubcriptionapp.constants.CardType;
import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
//import jakarta.persistence.Table;


import java.time.LocalDateTime;

@Entity
@Table(name = "subscription")
@Getter
@Setter
public class Subscription {


    private String userToken;
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    private String paymentDesc;
    private double paymentAmount;
    private LocalDateTime paymentDate;
    private double discountAmount;
    private boolean isActive;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
