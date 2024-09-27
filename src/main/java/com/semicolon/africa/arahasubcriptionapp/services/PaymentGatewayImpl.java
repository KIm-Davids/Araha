package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.dtos.responses.PaymentGatewayResponse;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentGatewayImpl {
    @Value("${stripe.api.key}")
    private String apiKey;

    public PaymentGatewayImpl() {
        Stripe.apiKey = apiKey;
    }

    public PaymentGatewayResponse createCharge(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<>();
        PaymentGatewayResponse response = new PaymentGatewayResponse();
        chargeParams.put("amount", (int) (amount * 100)); // Amount in cents
        chargeParams.put("currency", "usd");
        chargeParams.put("source", token);
        Charge.create(chargeParams);
        response.setMessage("Payment Successful");
        return response;
    }
}
