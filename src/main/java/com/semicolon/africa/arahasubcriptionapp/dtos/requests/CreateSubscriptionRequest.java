package com.semicolon.africa.arahasubcriptionapp.dtos.requests;


import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
<<<<<<< HEAD
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
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSubscriptionRequest {

<<<<<<< HEAD
<<<<<<< HEAD

    private SubscriptionType subscriptionType;
    private String paymentDesc;
    private double paymentAmount;
    private LocalDateTime paymentDate;
    private double discountAmount;
    private boolean isActive;
    private String user_id;
=======
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f
    private String userToken;
    private SubscriptionType subscriptionType;
    private String subscriptionDesc;
    private double amount;
    private LocalDateTime localDateTime;
<<<<<<< HEAD
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f

}
