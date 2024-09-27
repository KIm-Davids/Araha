package com.semicolon.africa.arahasubcriptionapp.web;


import com.semicolon.africa.arahasubcriptionapp.dtos.responses.ApiResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.PaymentGatewayResponse;
import com.semicolon.africa.arahasubcriptionapp.services.PaymentGatewayImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
public class PaymentGatewayController {

    private final PaymentGatewayImpl paymentGateway;

    private PaymentGatewayController(PaymentGatewayImpl paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    @PostMapping("/charge")
    public ResponseEntity<?> charge(@RequestParam String token, @RequestParam double amount){
        try{
            PaymentGatewayResponse response = paymentGateway.createCharge(token, amount);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_GATEWAY);
        }
    }

}
