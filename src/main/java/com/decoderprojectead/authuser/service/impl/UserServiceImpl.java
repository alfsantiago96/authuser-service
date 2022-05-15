package com.decoderprojectead.authuser.service.impl;

import com.decoderprojectead.authuser.dto.UserDto;
import com.decoderprojectead.authuser.exception.HttpError;
import com.decoderprojectead.authuser.exception.HttpException;
import com.decoderprojectead.authuser.exception.InvalidUsernameException;
import com.decoderprojectead.authuser.mapper.UserDtoMapper;
import com.decoderprojectead.authuser.mapper.UserModelMapper;
import com.decoderprojectead.authuser.model.UserModel;
import com.decoderprojectead.authuser.repository.UserRepository;
import com.decoderprojectead.authuser.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }

    @Override
    public UserDto registerNewUser(UserDto userDto) throws HttpException {
        try {
            validateNewUser(userDto);
            final UserModel userModel = UserModelMapper.newUser(userDto);
            return UserDtoMapper.map(userRepository.save(userModel));
        } catch (Exception exception) {
            throw exception;
        }
    }

    private void validateNewUser(UserDto userDto) throws HttpException {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent())
            throw new InvalidUsernameException(new HttpError());
    }
}