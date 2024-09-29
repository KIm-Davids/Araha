package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.DeleteSubResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.GetAllSubResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UpdateSubsResponse;


public interface SubscriptionServices {

//    CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest request);

    CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest createSubscriptionRequest);

    UpdateSubsResponse updateSubscription(UpdateSubsRequest request);

    void pausingSubscription(pauseSubRequest request);

    void resumingSubscription(ResumeSubRequest request);

    DeleteSubResponse deleteSubResponse(DeleteSubRequest request);

    GetAllSubResponse getAllSubscription(GetAllSubRequest request);
}
