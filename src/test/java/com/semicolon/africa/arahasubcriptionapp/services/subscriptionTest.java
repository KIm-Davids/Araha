package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.constants.CardType;
import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.SubscriptionRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UpdateSubsRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UpdateSubsResponse;
import org.junit.jupiter.api.Nested;
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.DeleteSubRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.DeleteSubResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

import static com.semicolon.africa.arahasubcriptionapp.constants.CardType.MASTERCARD;
import static com.semicolon.africa.arahasubcriptionapp.constants.CardType.VISA;
import static com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class SubscriptionTest {

    @Autowired
    private SubscriptionRepository subscriptionRepository;


    @Autowired
    private SubscriptionServices service;

    @Test
    void testCreateSubscription_Success() {
        CreateSubscriptionRequest request = new CreateSubscriptionRequest();
        request.setSubscriptionType(SubscriptionType.GOTV);
        request.setPaymentAmount(100.0);
        request.setCardType(CardType.VERVE);
        CreateSubscriptionResponse response = service.createSubscription(request);
        assertEquals("Successfully created subscription", response.getMessage());
    }


@Test
void testUpdateSubscription() {

    UpdateSubsRequest request = new UpdateSubsRequest();
    request.setSubscriptionType(JUMIA);
    request.setCardType(CardType.VERVE);
    request.setPaymentAmount(2000);

    UpdateSubsResponse response = service.updateSubscription(request);
    assertEquals("Updated Successfully", response.getMessage());

    }
    @Test
    public  void testThatSubscriptionCanBeDelete(){

        DeleteSubRequest deleteSubRequest = new DeleteSubRequest();
        deleteSubRequest.setSub_id(1L);
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





