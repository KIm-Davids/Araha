package com.semicolon.africa.arahasubcriptionapp.services;

<<<<<<< HEAD
import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
=======
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.SubscriptionRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.SubscriptionResponse;
<<<<<<< HEAD
import com.semicolon.africa.arahasubcriptionapp.exceptions.AllReadyOnASubscription;
=======
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

<<<<<<< HEAD
=======
import static com.semicolon.africa.arahasubcriptionapp.mapper.mapSubscriptions.mapSubscription;
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5

@Service
public class SubscriptionServiceImpl implements SubscriptionServices {

<<<<<<< HEAD
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository repository){
        this.subscriptionRepository = repository;
    }

    @Override
    public CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest createSubscriptionRequest) {
        for(Subscription subscription : subscriptionRepository.findAll()) {
            if (subscription.getSubscriptionType().equals(createSubscriptionRequest.getSubscriptionType())) {
                throw new AllReadyOnASubscription("Already on a subscription");
            }
        }
        Subscription newSubscription = new Subscription();
        newSubscription.setSubscriptionType(createSubscriptionRequest.getSubscriptionType());
        newSubscription.setActive(true);
        newSubscription.setPaymentAmount(createSubscriptionRequest.getPaymentAmount());
        newSubscription.setPaymentDesc(createSubscriptionRequest.getPaymentDesc());
//        newSubscription.setSubscriptionType(createSubscriptionRequest.getSubscriptionType());
        newSubscription.setPaymentDate(LocalDateTime.now());
        double discountAmount = (double) 10 /100 * createSubscriptionRequest.getPaymentAmount();
        newSubscription.setDiscountAmount(discountAmount);
        subscriptionRepository.save(newSubscription);
        CreateSubscriptionResponse createSubscriptionResponse = new CreateSubscriptionResponse();
        createSubscriptionResponse.setMessage("Successfully created subscription");
        return createSubscriptionResponse;
=======
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
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
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
