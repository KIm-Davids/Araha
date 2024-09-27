package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.SubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.SubscriptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
<<<<<<< HEAD
<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.assertEquals;
=======
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f


@SpringBootTest
class SubscriptionTest {

    @Autowired
<<<<<<< HEAD
<<<<<<< HEAD
    private SubscriptionServices service;

    @Test
    void testCreateSubscription_Success() {
        CreateSubscriptionRequest request = new CreateSubscriptionRequest();
        request.setSubscriptionType(SubscriptionType.JUMIA);
        request.setPaymentAmount(100.0);

        CreateSubscriptionResponse response = service.createSubscription(request);

        assertEquals("Successfully created subscription", response.getMessage());


=======
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f
    private static SubscriptionServices service;

    @Test
    void testThatUserCanSubscribe(){
        CreateSubscriptionRequest request = mockRequest();
        CreateSubscriptionResponse response = service.createSubscription(request);
        System.out.println(response);
        assertThat(response).isNotNull();
    }

    private static CreateSubscriptionRequest mockRequest(){
        CreateSubscriptionRequest request = new CreateSubscriptionRequest();
        request.setAmount(1200);
        request.setSubscriptionType(SubscriptionType.NETFLIX);
        request.setUserToken("UserToken");
        request.setLocalDateTime(LocalDateTime.now());
        request.setSubscriptionDesc("Pay for netflix");
        return request;
<<<<<<< HEAD
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f
    }
}
