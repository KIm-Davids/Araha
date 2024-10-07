package com.semicolon.africa.arahasubcriptionapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatedUserResponse {
    private Long id;
    private String newEmail;
    private String newPassword;
    private String newUsername;
    private String newPhoneNumber;
    private String message;
}
