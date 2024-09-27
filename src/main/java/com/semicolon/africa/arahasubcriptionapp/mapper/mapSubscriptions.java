package com.semicolon.africa.arahasubcriptionapp.mapper;

import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.SubscriptionRequest;

import java.time.LocalDateTime;

public class mapSubscriptions {
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f

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
<<<<<<< HEAD
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f
}
