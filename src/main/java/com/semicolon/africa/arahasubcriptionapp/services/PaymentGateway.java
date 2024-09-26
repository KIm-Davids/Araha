package com.semicolon.africa.arahasubcriptionapp.services;

import com.stripe.model.Charge;

public interface PaymentGateway {

    Charge createCharge(String token, double amount);
}
