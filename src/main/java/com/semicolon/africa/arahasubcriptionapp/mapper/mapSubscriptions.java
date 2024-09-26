package com.semicolon.africa.arahasubcriptionapp.mapper;

import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.SubscriptionRequest;

import java.time.LocalDateTime;

public class mapSubscriptions {

    public static Subscription mapSubscription(CreateSubscriptionRequest request){
        Subscription subscription = new Subscription();
        subscription.setSubscriptionType(request.getSubscriptionType());
        subscription.setPaymentDesc(request.getSubscriptionDesc());
        subscription.setPaymentAmount(request.getAmount());
        subscription.setUserToken(request.getUserToken());
        subscription.setPaymentDate(LocalDateTime.now());
        subscription.setActive(true);
        return subscription;
    }
}
