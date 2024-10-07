package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.data.models.User;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UpdateUserRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserLoginRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UpdatedUserResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserLoginResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserRegisterResponse;

import java.util.List;

public interface UserService {

    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);

    List<User> getAllUsers();

    UserLoginResponse login(UserLoginRequest userLoginRequest);

    UpdatedUserResponse update(UpdateUserRequest userUpdateRequest);
}
