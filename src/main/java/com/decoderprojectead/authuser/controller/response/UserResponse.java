package com.decoderprojectead.authuser.controller.response;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse {

    private UUID userId;
    private String username;
    private String email;
    private String password;
    private String oldPassword;
    private String fullName;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;
}
