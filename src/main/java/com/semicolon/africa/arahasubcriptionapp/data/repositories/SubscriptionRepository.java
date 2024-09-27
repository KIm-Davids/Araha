package com.semicolon.africa.arahasubcriptionapp.data.repositories;


import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

//     Subscription findSubscriptionByUserToken(String token);
//
//     Subscription findSubscriptionsByEmailAndPassword(String email,String password);

     Subscription findSubscriptionById(String id);

      List<Subscription> findSubscriptionsBy();

}
