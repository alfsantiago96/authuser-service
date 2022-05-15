package com.decoderprojectead.authuser.mapper;

import com.decoderprojectead.authuser.dto.UserDto;
import com.decoderprojectead.authuser.enums.UserStatus;
import com.decoderprojectead.authuser.enums.UserType;
import com.decoderprojectead.authuser.model.UserModel;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserModelMapper {

    public static UserModel newUser(UserDto userDto) {
        UserModel userModel = copyProperties(userDto);
        userModel.setUserStatus(UserStatus.ACTIVE);
        userModel.setUserType(UserType.STUDENT);
        userModel.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        userModel.setLasUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        return userModel;
    }

    private static UserModel copyProperties(UserDto userDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        return userModel;
    }
}
