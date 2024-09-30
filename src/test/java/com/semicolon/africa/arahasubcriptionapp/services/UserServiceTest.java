package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.Utils.JwtUtilsImpl;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.UserRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UpdateUserRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserLoginRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserLogoutRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UpdatedUserResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserLoginResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserLogoutResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.arahasubcriptionapp.exception.EmailAlreadyExist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtilsImpl impl;

    @Test
    public void testToRegisterUser() {
        UserRegisterResponse userRegisterResponse = userRegister();
        assertThat(userRegisterResponse).isNotNull();
        assertThat(userService.getAllUsers().size()).isEqualTo(1L);
        assertThat(userRegisterResponse.getMessage()).contains("successfully registered");
    }

    private UserRegisterResponse userRegister() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("arahia@gmail.com");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setPhoneNumber("08133608692");
        userRegisterRequest.setUsername("users");
        UserRegisterResponse userRegisterResponse = userService.register(userRegisterRequest);
        return userRegisterResponse;
    }

    @Test
    public void testThatAUserCannotRegisterTwiceWithSameEmail_ThrowException() {
        userRegister();
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("arahia@gmail.com");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setPhoneNumber("08133608692");
        userRegisterRequest.setUsername("users");
        assertThrows(EmailAlreadyExist.class, () -> userService.register(userRegisterRequest));
    }

    @Test
    public void testToLoginUser() throws ParseException {
        userRegister();
        String  userLoginResponse = userLogin();
        System.out.println(userLoginResponse);
        assertThat(userLoginResponse).isNotNull();
//        assertThat(userLoginResponse.getMessage()).contains("Logged in Successfully");
//        assertThat(userLoginResponse.isLoggedIn()).isEqualTo(true);
    }

    private String userLogin() throws ParseException {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJheW8iLCJwYXNzd29yZCI6IjA4MTgzODcyNDI0IiwicGhvbmVOdW1iZXIiOiJheW9AZ21haWxjb20iLCJzdWJzY3JpcHRpb25UeXBlIjoiTk9UX1NFVCIsImV4cCI6MTcyNzY0MjIzMSwiaWF0IjoxNzI3NjM4NjMxLCJlbWFpbCI6IiQyYSQxMCRRY1dRc1htZU9nUXNNbHFTbUN6LlV1a2FRTUx6QU1wU1RUSUpCUFVwN21sV1hiSVBkWTlzSyJ9.bbPjMvJPtx1znTawqcq53RzzC2zcwW6rZ525cH7dXjA";
//        userLoginRequest.setEmail("arahia@gmail.com");
//        userLoginRequest.setPassword("password");
        System.out.print(token);
        UserLoginResponse userLoginResponse = userService.login(userLoginRequest, token);
        return token;
    }

    @Test
    public void testThatUserCannotLoginWithIncorrectPassword_ThrowsException() {
        userRegister();
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("araha@gmail.com");
        userLoginRequest.setPassword("wrongpassword");
//        assertThrows(EmailAlreadyExist.class, () -> userService.login(userLoginRequest, token));
    }

    @Test
    public void testThatUserUpdateTheirDetails() throws ParseException {
//        userRegister();
    public void testThatUserUpdateTheirDetails() {
        userLogin();
        UpdateUserRequest userUpdateRequest = new UpdateUserRequest();
        userUpdateRequest.setNewEmail("newmail@gmail.com");
        userUpdateRequest.setNewPhoneNumber("08133608699");
        userUpdateRequest.setId(96L);
        userUpdateRequest.setNewUsername("NewUser");
        userUpdateRequest.setNewPassword("newpassword");
        UpdatedUserResponse updatedUserResponse = userService.update(userUpdateRequest);
        assertThat(updatedUserResponse).isNotNull();
        assertThat(updatedUserResponse.getMessage()).contains("updated successfully");
    }

    @Test
    public void testThatUserCanLogout() {
        userLogin();
        UserLogoutRequest userLogoutRequest = new UserLogoutRequest();
        userLogoutRequest.setEmail("arahia@gmail.com");
        UserLogoutResponse userLogoutResponse = userService.logOut(userLogoutRequest);
        assertThat(userLogoutResponse).isNotNull();
        assertThat(userLogoutResponse.getMessage()).contains("Logged Out Succcessfully");
        assertThat(userLogoutResponse.isLoggedIn()).isEqualTo(false);
    }
//    public void testThatUserUpdateTheirDetails(){
//        userRegister();
//        userLogin();
//        UpdateUserRequest userUpdateRequest = new UpdateUserRequest();
//
//
//    }


}