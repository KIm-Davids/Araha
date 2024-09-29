package com.semicolon.africa.arahasubcriptionapp.services;


import com.semicolon.africa.arahasubcriptionapp.dtos.responses.DeleteSubResponse;

import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UpdateSubsResponse;
import com.semicolon.africa.arahasubcriptionapp.exception.InvalidAmountException;
import com.semicolon.africa.arahasubcriptionapp.exception.InvalidCardException;

import com.semicolon.africa.arahasubcriptionapp.exceptions.AllReadyOnASubscription;
import com.semicolon.africa.arahasubcriptionapp.exceptions.SubscriptionNotFindException;
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.SubscriptionRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;

import com.semicolon.africa.arahasubcriptionapp.dtos.responses.GetAllSubResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionServices {


    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository repository){
        this.subscriptionRepository = repository;
    }

    @Override
    public CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest createSubscriptionRequest) {
//        Subscription subscription = subscriptionRepository.findSubscriptionBySubscriptionType(createSubscriptionRequest.getSubscriptionType());
//            if (subscription.getSubscriptionType().equals(createSubscriptionRequest.getSubscriptionType())) {
//                throw new AllReadyOnASubscription("Already on a subscription");
//            }


        Subscription newSubscription = new Subscription();
        newSubscription.setSubscriptionType(createSubscriptionRequest.getSubscriptionType());
        newSubscription.setActive(true);
        newSubscription.setId(2L);
        newSubscription.setPaymentAmount(createSubscriptionRequest.getPaymentAmount());
        newSubscription.setCardType(createSubscriptionRequest.getCardType());
        newSubscription.setPaymentDesc(createSubscriptionRequest.getPaymentDesc());
        newSubscription.setPaymentDate(LocalDateTime.now());
        double discountAmount = (double) 10 / 100 * createSubscriptionRequest.getPaymentAmount();
        newSubscription.setDiscountAmount(discountAmount);
        subscriptionRepository.save(newSubscription);

        CreateSubscriptionResponse createSubscriptionResponse = new CreateSubscriptionResponse();
        createSubscriptionResponse.setMessage("Successfully created subscription");
        return createSubscriptionResponse;
    }


    @Override
    public UpdateSubsResponse updateSubscription(UpdateSubsRequest updateSubsRequest) {
    Subscription subscription  = subscriptionRepository.findSubscriptionById(2L);
        if(updateSubsRequest.getCardType().toString().equals(" ")){
            throw new InvalidCardException("No Card Inputted");
        }

        if(updateSubsRequest.getPaymentAmount() == 0){
            throw new InvalidAmountException("Please Ensure to enter a valid amount");
        }

        if(subscription.getSubscriptionType().equals(updateSubsRequest.getSubscriptionType())){
//            subscription.setSubscriptionType(updateSubsRequest.getSubscriptionType());
            subscription.setActive(updateSubsRequest.isActive());
            subscription.setPaymentAmount(updateSubsRequest.getPaymentAmount());
            subscription.setCardType(updateSubsRequest.getCardType());
            subscription.setPaymentDesc(updateSubsRequest.getPaymentDesc());
            subscription.setPaymentDate(updateSubsRequest.getPaymentDate());
            subscription.setDiscountAmount(updateSubsRequest.getDiscountAmount());
            subscriptionRepository.save(subscription);
        }else {
            throw new AllReadyOnASubscription("Unable to update subscription");
        }
    UpdateSubsResponse updateSubsResponse = new UpdateSubsResponse();
    updateSubsResponse.setMessage("Updated Successfully");
return updateSubsResponse;

    }


    @Override
    public DeleteSubResponse deleteSubscription(DeleteSubRequest request) {
        Subscription subscription = subscriptionRepository.findSubscriptionById(request.getSub_id());
        validateForSubscriptionId(request.getSub_id());
        subscriptionRepository.delete(subscription);
        DeleteSubResponse response = new DeleteSubResponse();
        response.setMessage("Subscription deleted successfully");
        return response ;
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    private void validateForSubscriptionId(Long id) {
        if(id==null) throw new SubscriptionNotFindException("Subscription id not find");
    }


}
