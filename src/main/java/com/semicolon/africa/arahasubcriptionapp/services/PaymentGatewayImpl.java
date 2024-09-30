package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.dtos.requests.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.StripeClient;
import com.stripe.model.Customer;
import com.stripe.param.CustomerCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PaymentGatewayImpl {
    @Value("${stripe.api.key}")
    private String apiKey;

    public PaymentGatewayImpl() {
        Stripe.apiKey = apiKey;
    }

    public Customer createCharge(@RequestBody PaymentRequest request){
        StripeClient client = new StripeClient("sk_test_51Q2pg8Fyx62noX7U0fPvLRZkTsEbwhCjF93lWksrfQqae8CYmW97T9MTOfOevmj2IHP3dV7uRIcfUY3wexNemD8W00oDuKAUh1");
        CustomerCreateParams params = CustomerCreateParams.builder()
                .setBalance(request.getBalance())
//                .setPaymentMethod(MasterCard)
                .setEmail("e@gmail.com")
                .build();

        try{
            return client.customers().create(params);
        }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("Failed to create payment intent");
        }

    }
}
