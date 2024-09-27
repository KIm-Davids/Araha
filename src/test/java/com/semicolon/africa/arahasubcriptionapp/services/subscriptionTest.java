package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.constants.CardType;
import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class SubscriptionTest {





    @Autowired
    private SubscriptionServices service;

    @Test
    void testCreateSubscription_Success() {
        CreateSubscriptionRequest request = new CreateSubscriptionRequest();
        request.setSubscriptionType(SubscriptionType.JUMIA);
        request.setPaymentAmount(100.0);
        request.setCardType(CardType.VERVE);
        CreateSubscriptionResponse response = service.createSubscription(request);
        assertEquals("Successfully created subscription", response.getMessage());
    }
}
