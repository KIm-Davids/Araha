package com.semicolon.africa.arahasubcriptionapp.services;


import com.semicolon.africa.arahasubcriptionapp.exceptions.SubscriptionNotFindException;
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.SubscriptionRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.ChangeSubsResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;

import static com.semicolon.africa.arahasubcriptionapp.validations.validations.validateSubscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.GetAllSubResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
public class SubscriptionServiceImpl implements SubscriptionServices {

//
//    public SubscriptionServiceImpl(SubscriptionRepository repository){
//        this.repository = repository;
//    }
//
//    @Override
//    public CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest request) {
//        CreateSubscriptionResponse response = new CreateSubscriptionResponse();
//        validateSubscription(request);
//        Subscription subscription = mapSubscription(request);
//        repository.save(subscription);
//        response.setMessage("Successfully paid for " + request.getSubscriptionType());
//        return response;
//    }
//

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
    public ChangeSubsResponse  changeSubscription(changeSubRequest request) {
    return null;
    }

    @Override
    public void pausingSubscription(pauseSubRequest request) {

    }

    @Override
    public void resumingSubscription(ResumeSubRequest request) {

    }

    @Override
    public DeleteSubResponse deleteSubResponse(DeleteSubRequest request) {
        Subscription subscription = subscriptionRepository.findSubscriptionById(request.getSub_id());
        validateForSubscriptionId(request.getSub_id());
        subscriptionRepository.delete(subscription);
        DeleteSubResponse response = new DeleteSubResponse();
        response.setMessage("Subscription deleted successfully");
        return response ;
    }

    private void validateForSubscriptionId(Long id) {
        if(id==null) throw new SubscriptionNotFindException("Subscription id not find");
    }

    @Override
    public GetAllSubResponse getAllSubscription(GetAllSubRequest request) {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        GetAllSubResponse response = new GetAllSubResponse();
        return null;
    }
}
