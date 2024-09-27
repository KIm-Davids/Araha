package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.SubscriptionResponse;

public interface SubscriptionServices {

    CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest request);

    void changeSubscription(changeSubRequest request);

    void pausingSubscription(pauseSubRequest request);

    void resumingSubscription(ResumeSubRequest request);

    void cancellingSubscription(cancelSubRequest request);

    void getAllSubscription(getAllSubRequest request);
}
