package com.semicolon.africa.arahasubcriptionapp.data.repositories;


import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
