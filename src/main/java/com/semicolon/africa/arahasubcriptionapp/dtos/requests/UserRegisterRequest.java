package com.semicolon.africa.arahasubcriptionapp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequest {
    private String email;
    private String password;
    private String username;
    private String phoneNumber;
}
