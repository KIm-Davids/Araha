package com.semicolon.africa.arahasubcriptionapp.services;

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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

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
    public void testToLoginUser() {
        userRegister();
        UserLoginResponse userLoginResponse = userLogin();
        assertThat(userLoginResponse).isNotNull();
        assertThat(userLoginResponse.getMessage()).contains("Logged in Successfully");
        assertThat(userLoginResponse.isLoggedIn()).isEqualTo(true);
    }

    private UserLoginResponse userLogin() {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("arahia@gmail.com");
        userLoginRequest.setPassword("password");
        UserLoginResponse userLoginResponse = userService.login(userLoginRequest);
        return userLoginResponse;
    }

    @Test
    public void testThatUserCannotLoginWithIncorrectPassword_ThrowsException() {
        userRegister();
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("araha@gmail.com");
        userLoginRequest.setPassword("wrongpassword");
        assertThrows(EmailAlreadyExist.class, () -> userService.login(userLoginRequest));
    }

    @Test
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
<<<<<<< HEAD
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
=======
//    public void testThatUserUpdateTheirDetails(){
//        userRegister();
//        userLogin();
//        UpdateUserRequest userUpdateRequest = new UpdateUserRequest();
//
//
//    }


>>>>>>> 62b5e4aee25c0df2a671bf86ad87a87c2fe543bb
}