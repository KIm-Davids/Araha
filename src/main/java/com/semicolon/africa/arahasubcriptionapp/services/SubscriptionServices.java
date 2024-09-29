package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.DeleteSubResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.GetAllSubResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UpdateSubsResponse;



import java.util.List;

    CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest createSubscriptionRequest);

    UpdateSubsResponse updateSubscription(UpdateSubsRequest request);
public interface SubscriptionServices {

    CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest request);

    ChangeSubsResponse  changeSubscription(changeSubRequest request);

    DeleteSubResponse deleteSubscription(DeleteSubRequest request);

    List<Subscription> getAllSubscriptions();
}
