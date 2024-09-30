package com.semicolon.africa.arahasubcriptionapp.web;

import com.semicolon.africa.arahasubcriptionapp.data.models.Subscription;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.CreateSubscriptionRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.DeleteSubRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.GetAllSubRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UpdateSubsRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.*;
import com.semicolon.africa.arahasubcriptionapp.services.SubscriptionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/araha")
@CrossOrigin(origins = "*")
public class SubscriptionController {

    private final SubscriptionServiceImpl service;

    private SubscriptionController(SubscriptionServiceImpl service){
        this.service = service;
    }

    @PostMapping("/create-subscription")
    public ResponseEntity<?> createSubscription(@RequestBody CreateSubscriptionRequest request) {
        try {
            CreateSubscriptionResponse response = service.createSubscription(request);
            return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PatchMapping("/update-subscription")
    public ResponseEntity<?> updateSubscriptionAmount(@RequestBody UpdateSubsRequest request){
        try{
            UpdateSubsResponse response = service.updateSubscription(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_GATEWAY);
        }
    }

    @DeleteMapping("/delete-subscription")
    public ResponseEntity<?> deleteSubscription(@RequestBody DeleteSubRequest request){
        try{
            DeleteSubResponse response = service.deleteSubscription(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), PRECONDITION_FAILED);
        }
    }

    @GetMapping("/get-all-subscription")
    public ResponseEntity<?> getAllSubscription(@RequestBody GetAllSubRequest request){
        try{
            List<Subscription> response = service.getAllSubscriptions();
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), EXPECTATION_FAILED);
        }
    }


}
