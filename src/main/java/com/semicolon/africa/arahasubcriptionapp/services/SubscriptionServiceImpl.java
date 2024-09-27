package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.SubscriptionNotFindException;
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.SubscriptionRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.*;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.ChangeSubsResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.DeleteSubResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.GetAllSubResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubscriptionServiceImpl implements SubscriptionServices {

    private final SubscriptionRepository repository;

    public SubscriptionServiceImpl(SubscriptionRepository repository){
        this.repository = repository;
    }

    @Override
    public CreateSubscriptionResponse createSubscription(CreateSubscriptionRequest createRequest) {
        return null;
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
        Subscription subscription = repository.findSubscriptionById(request.getSub_id());
        validateForSubscriptionId(request.getSub_id());
        repository.delete(subscription);
        DeleteSubResponse response = new DeleteSubResponse();
        response.setMessage("Subscription deleted successfully");
        return response ;
    }

    private void validateForSubscriptionId(String id) {
        if(id==null) throw new SubscriptionNotFindException("Subscription id not find");
    }

    @Override
    public GetAllSubResponse getAllSubscription(GetAllSubRequest request) {
        List<Subscription> subscriptions = repository.findAll();
        GetAllSubResponse response = new GetAllSubResponse();
        return null;
    }
}
