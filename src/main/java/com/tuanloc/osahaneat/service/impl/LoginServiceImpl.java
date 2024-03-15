package com.tuanloc.osahaneat.service.impl;

import com.tuanloc.osahaneat.dto.UserDto;
import com.tuanloc.osahaneat.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImpl {
    List<UserDto> getAllUser();
    boolean checkLogin(String userName, String password);
    boolean addUser(SignUpRequest signUpRequest);
}
