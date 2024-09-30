package com.semicolon.africa.arahasubcriptionapp.web;


import com.semicolon.africa.arahasubcriptionapp.dtos.requests.PaymentRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.ApiResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.PaymentGatewayResponse;
import com.semicolon.africa.arahasubcriptionapp.services.PaymentGatewayImpl;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping
public class PaymentGatewayController {

    private final PaymentGatewayImpl paymentGateway;

    private PaymentGatewayController(PaymentGatewayImpl paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    @PostMapping("/v1/customers")
    public ResponseEntity<?> charge(@RequestBody PaymentRequest request){
        try{
            Customer response = paymentGateway.createCharge(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_GATEWAY);
        }
    }

}
