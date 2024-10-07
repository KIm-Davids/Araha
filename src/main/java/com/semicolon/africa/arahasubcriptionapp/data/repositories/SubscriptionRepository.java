package com.semicolon.africa.arahasubcriptionapp.data.repositories;


import com.semicolon.africa.arahasubcriptionapp.constants.SubscriptionType;
import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.models.User;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Subscription findSubscriptionBySubscriptionType(SubscriptionType subscriptionType);
    Subscription findSubscriptionById(Long id);
    List<Subscription> findSubscriptionsBy();

    Optional<Subscription> findBySubscriptionType(SubscriptionType subscriptionType);
}
