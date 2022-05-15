package com.decoderprojectead.authuser.controller;

import com.decoderprojectead.authuser.controller.request.UserRequest;
import com.decoderprojectead.authuser.controller.response.UserResponse;
import com.decoderprojectead.authuser.dto.UserDto;
import com.decoderprojectead.authuser.exception.HttpException;
import com.decoderprojectead.authuser.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
public class AuthenticationController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    @PostMapping("/singup")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest) throws HttpException {
        log.info("Recebido requisão para registrar novo usuário. {}", userRequest);
        final UserDto userDto = objectMapper.convertValue(userRequest, UserDto.class);
        final UserDto userCreated = userService.registerNewUser(userDto);
        final UserResponse userResponse = objectMapper.convertValue(userCreated, UserResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
