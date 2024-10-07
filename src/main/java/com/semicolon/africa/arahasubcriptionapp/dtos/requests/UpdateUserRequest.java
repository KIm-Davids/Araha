package com.semicolon.africa.arahasubcriptionapp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserRequest {
    private Long id;
    private String newEmail;
    private String newPassword;
    private String newUsername;
    private String newPhoneNumber;
}
