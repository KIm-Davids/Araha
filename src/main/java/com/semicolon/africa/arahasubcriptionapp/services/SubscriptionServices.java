package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.ChangeSubsResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.DeleteSubResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.GetAllSubResponse;

public interface SubscriptionServices {

//    CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest request);

   ChangeSubsResponse  changeSubscription(changeSubRequest request);

    void pausingSubscription(pauseSubRequest request);

    void resumingSubscription(ResumeSubRequest request);

    DeleteSubResponse deleteSubResponse(DeleteSubRequest request);

    GetAllSubResponse getAllSubscription(GetAllSubRequest request);
}
