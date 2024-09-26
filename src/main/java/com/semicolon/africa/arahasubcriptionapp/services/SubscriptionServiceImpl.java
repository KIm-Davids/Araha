package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.SubscriptionRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.SubscriptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.semicolon.africa.arahasubcriptionapp.mapper.mapSubscriptions.mapSubscription;

@Service
public class SubscriptionServiceImpl implements SubscriptionServices {

    private final SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository){
        this.repository = repository;
    }

    @Override
    public CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest request) {
        CreateSubscriptionResponse response = new CreateSubscriptionResponse();
//        validateSubscription(request);
//        Subscription subscription = mapSubscription(request);
        Subscription subscription = mapSubscription(request);
        repository.save(subscription);
        response.setMessage("Successfully paid for " + request.getSubscriptionType());
        return response;
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
