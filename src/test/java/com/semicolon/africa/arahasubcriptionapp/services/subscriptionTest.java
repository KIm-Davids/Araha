package com.semicolon.africa.arahasubcriptionapp.services;
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.DeleteSubRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.DeleteSubResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.semicolon.africa.arahasubcriptionapp.constants.CardType.MASTERCARD;
import static com.semicolon.africa.arahasubcriptionapp.constants.CardType.VISA;
import static com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class SubscriptionTest {

    @Autowired
    private SubscriptionServices service;

    @Test
    void testCreateSubscription_Success() {
        CreateSubscriptionRequest request = new CreateSubscriptionRequest();
        request.setSubscriptionType(NETFLIX);
        request.setPaymentAmount(200.00);
        request.setCardType(MASTERCARD);
        CreateSubscriptionResponse response = service.createSubscription(request);
        assertEquals("Successfully created subscription", response.getMessage());
    }
    @Test
    public  void testThatSubscriptionCanBeDelete(){

        DeleteSubRequest deleteSubRequest = new DeleteSubRequest();
        deleteSubRequest.setSub_id(2L);
        DeleteSubResponse response = service.deleteSubscription(deleteSubRequest);
        assertEquals("Subscription deleted successfully",response.getMessage());

    }
    @Test
    public void testToGetAllSubscriptions(){
        List<Subscription> subscriptions = service.getAllSubscriptions();
        assertNotNull(subscriptions);
        assertEquals(2,subscriptions.size());

    }

}
