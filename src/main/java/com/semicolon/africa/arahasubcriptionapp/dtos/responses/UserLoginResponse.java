package com.semicolon.africa.arahasubcriptionapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginResponse {
    private Long id;
    private boolean isLoggedIn;
    private String message;
}
