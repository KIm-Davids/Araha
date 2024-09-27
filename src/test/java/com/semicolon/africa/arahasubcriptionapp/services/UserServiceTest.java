package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.data.repositories.UserRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UpdateUserRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserLoginRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserLoginResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.arahasubcriptionapp.exception.EmailAlreadyExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();
    }
    @Test
    public void testToRegisterUser(){
        UserRegisterResponse userRegisterResponse = userRegister();
        assertThat(userRegisterResponse).isNotNull();
        assertThat(userService.getAllUser().size()).isEqualTo(1L);
       assertThat(userRegisterResponse.getMessage()).contains("successfully registered");
    }

    private UserRegisterResponse userRegister() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("araha@gmail.com");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setPhoneNumber("08133608698");
        userRegisterRequest.setUsername("username");
        UserRegisterResponse userRegisterResponse = userService.register(userRegisterRequest);
        return userRegisterResponse;
    }

    @Test
    public void testThatAUserCannotRegisterTwiceWithSameEmail_ThrowException(){
        userRegister();
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail("araha@gmail.com");
        userRegisterRequest.setPassword("password");
        userRegisterRequest.setPhoneNumber("08133608698");
        userRegisterRequest.setUsername("username");
        assertThrows(EmailAlreadyExist.class, ()-> userService.register(userRegisterRequest));
    }
    @Test
    public void testToLoginUser(){
        userRegister();
        UserLoginResponse userLoginResponse = userLogin();
        assertThat(userLoginResponse).isNotNull();
        assertThat(userLoginResponse.getMessage()).contains("Logged in Successfully");
        assertThat(userLoginResponse.isLoggedIn()).isEqualTo(true);
    }

    private UserLoginResponse userLogin() {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("araha@gmail.com");
        userLoginRequest.setPassword("password");
        UserLoginResponse userLoginResponse = userService.login(userLoginRequest);
        return userLoginResponse;
    }

    @Test
    public void testThatUserCannotLoginWithIncorrectPassword_ThrowsException(){
        userRegister();
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("araha@gmail.com");
        userLoginRequest.setPassword("wrongpassword");
        assertThrows(EmailAlreadyExist.class, ()-> userService.login(userLoginRequest));
    }
//    @Test
//    public void testThatUserUpdateTheirDetails(){
//        userRegister();
//        userLogin();
//        UpdateUserRequest userUpdateRequest = new UpdateUserRequest();
//
//
//    }


}