package com.semicolon.africa.arahasubcriptionapp.web;

import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.ApiResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.CreateSubscriptionResponse;
import com.semicolon.africa.arahasubcriptionapp.services.SubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/araha")
@CrossOrigin(origins = "*")
public class CreateSubscriptionController {

    @Autowired
    private SubscriptionServiceImpl service;

    @PostMapping("/create-subscription")
    public ResponseEntity<?> createASubscription(CreateSubscriptionRequest request){
        try {
            CreateSubscriptionResponse response = service.createSubscription(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
}
