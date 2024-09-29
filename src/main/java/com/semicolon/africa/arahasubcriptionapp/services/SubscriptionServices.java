package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.ChangeSubsResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.DeleteSubResponse;

import java.util.List;

public interface SubscriptionServices {

    CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest request);

    ChangeSubsResponse  changeSubscription(changeSubRequest request);

    DeleteSubResponse deleteSubscription(DeleteSubRequest request);

    List<Subscription> getAllSubscriptions();
}
