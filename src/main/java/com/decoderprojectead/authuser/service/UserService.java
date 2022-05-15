package com.decoderprojectead.authuser.service;

import com.decoderprojectead.authuser.dto.UserDto;
import com.decoderprojectead.authuser.exception.HttpException;
import com.decoderprojectead.authuser.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();

    Optional<UserModel> findById(UUID userId);

    void delete(UserModel userModel);

    UserDto registerNewUser(UserDto userDto) throws HttpException;
}
