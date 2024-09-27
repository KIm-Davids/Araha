package com.semicolon.africa.arahasubcriptionapp.data.models;

import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
=======
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
<<<<<<< HEAD
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f

import java.time.LocalDateTime;

@Entity
<<<<<<< HEAD
<<<<<<< HEAD
//@Table(name = "subscription")
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String user_id;
    @Enumerated(EnumType.STRING)
=======
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f
@Table(name = "subscription")
@Getter
@Setter
public class Subscription {

    @jakarta.persistence.Id
    @Id
    private String id;
    private String userToken;
<<<<<<< HEAD
>>>>>>> 8176f6a12d5f35dc74bf04df3ebb17425f6ec9f5
=======
>>>>>>> 1c283acdadc6d353384fe13ade5d8f6a417fd08f
    private SubscriptionType subscriptionType;
    private String paymentDesc;
    private double paymentAmount;
    private LocalDateTime paymentDate;
    private double discountAmount;
    private boolean isActive;
}
