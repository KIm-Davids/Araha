package com.semicolon.africa.arahasubcriptionapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLogoutResponse {
    private String message;
    private boolean isLoggedIn;
}
