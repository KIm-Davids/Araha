package com.semicolon.africa.arahasubcriptionapp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequest {
    private Long id;
    private String email;
    private String password;
}
