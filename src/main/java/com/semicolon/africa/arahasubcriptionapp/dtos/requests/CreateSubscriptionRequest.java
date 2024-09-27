package com.semicolon.africa.arahasubcriptionapp.dtos.requests;


import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
<<<<<<< HEAD
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSubscriptionRequest {

<<<<<<< HEAD

    private SubscriptionType subscriptionType;
    private String paymentDesc;
    private double paymentAmount;
    private LocalDateTime paymentDate;
    private double discountAmount;
    private boolean isActive;
    private String user_id;
=======
    private String userToken;
    private SubscriptionType subscriptionType;
    private String subscriptionDesc;
    private double amount;
    private LocalDateTime localDateTime;
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5

}
