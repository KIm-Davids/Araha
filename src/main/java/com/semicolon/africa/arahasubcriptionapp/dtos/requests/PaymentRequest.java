package com.semicolon.africa.arahasubcriptionapp.dtos.requests;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    private Long balance;
    private String email;
//    private String payment_method;
}