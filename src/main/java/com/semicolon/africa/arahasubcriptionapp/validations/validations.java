package com.semicolon.africa.arahasubcriptionapp.validations;

import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.SubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.exceptions.ValuesCannotBeEmptyException;


public class validations {

    public static void validateSubscription(CreateSubscriptionRequest request){
        if (request.getSubscriptionDesc().equals(" ") || request.getSubscriptionType().equals(" ") || request.getAmount() == 0 || request.getUserToken().equals(" ")){
            throw new ValuesCannotBeEmptyException("Field cannot be empty");
        }
    }
}
