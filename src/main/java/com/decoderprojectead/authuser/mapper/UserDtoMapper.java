package com.decoderprojectead.authuser.mapper;

import com.decoderprojectead.authuser.dto.UserDto;
import com.decoderprojectead.authuser.model.UserModel;
import org.springframework.beans.BeanUtils;

public class UserDtoMapper {

    public static UserDto map(UserModel userModel) {
        var userDto = new UserDto();
        BeanUtils.copyProperties(userModel, userDto);
        return userDto;
    }
}
