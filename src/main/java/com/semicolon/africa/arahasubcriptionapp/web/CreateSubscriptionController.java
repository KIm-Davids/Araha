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



}
