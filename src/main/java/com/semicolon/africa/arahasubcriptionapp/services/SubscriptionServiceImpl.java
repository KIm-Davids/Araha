package com.semicolon.africa.arahasubcriptionapp.services;


import com.semicolon.africa.arahasubcriptionapp.constants.CardType;
import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;

import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.SubscriptionRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.SubscriptionResponse;

import com.semicolon.africa.arahasubcriptionapp.exceptions.AllReadyOnASubscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.semicolon.africa.arahasubcriptionapp.mapper.mapSubscriptions.mapSubscription;

import static com.semicolon.africa.arahasubcriptionapp.mapper.mapSubscriptions.mapSubscription;

@Service
public class SubscriptionServiceImpl implements SubscriptionServices {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository repository){
        this.subscriptionRepository = repository;
    }

    @Override
    public CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest createSubscriptionRequest) {
        for (Subscription subscription : subscriptionRepository.findAll()) {
            if (subscription.getSubscriptionType().equals(createSubscriptionRequest.getSubscriptionType())) {
                throw new AllReadyOnASubscription("Already on a subscription");
            }
        }
        Subscription newSubscription = new Subscription();
        newSubscription.setSubscriptionType(createSubscriptionRequest.getSubscriptionType());
        newSubscription.setActive(true);
        newSubscription.setPaymentAmount(createSubscriptionRequest.getPaymentAmount());
        newSubscription.setCardType(createSubscriptionRequest.getCardType());
        newSubscription.setPaymentDesc(createSubscriptionRequest.getPaymentDesc());
//        newSubscription.setSubscriptionType(createSubscriptionRequest.getSubscriptionType());
        newSubscription.setPaymentDate(LocalDateTime.now());
        double discountAmount = (double) 10 / 100 * createSubscriptionRequest.getPaymentAmount();
        newSubscription.setDiscountAmount(discountAmount);
        subscriptionRepository.save(newSubscription);
        CreateSubscriptionResponse createSubscriptionResponse = new CreateSubscriptionResponse();
        createSubscriptionResponse.setMessage("Successfully created subscription");
        return createSubscriptionResponse;
    }
    @Override
    public void changeSubscription(changeSubRequest request) {

    }

    @Override
    public void pausingSubscription(pauseSubRequest request) {

    }

    @Override
    public void resumingSubscription(ResumeSubRequest request) {

    }

    @Override
    public void cancellingSubscription(cancelSubRequest request) {

    }

    @Override
    public void getAllSubscription(getAllSubRequest request) {

    }
}
