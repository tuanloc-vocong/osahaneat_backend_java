package com.tuanloc.osahaneat.service;

import com.tuanloc.osahaneat.dto.UserDto;
import com.tuanloc.osahaneat.entity.Roles;
import com.tuanloc.osahaneat.entity.Users;
import com.tuanloc.osahaneat.payload.request.SignUpRequest;
import com.tuanloc.osahaneat.repository.UserRepository;
import com.tuanloc.osahaneat.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements LoginServiceImpl {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAllUser(){
        List<Users> listUser = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (Users user : listUser){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUserName(user.getUserName());
            userDto.setFullname(user.getFullname());
            userDto.setPassword(user.getPassword());
            userDto.setCreatedDate(userDto.getCreatedDate());

            userDtoList.add(userDto);
        }
        return  userDtoList;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        Users user = userRepository.findByUserName(username);
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());

        Users users = new Users();
        users.setFullname(signUpRequest.getFullname());
        users.setUserName((signUpRequest.getEmail()));
        users.setPassword(signUpRequest.getPassword());
        users.setRoles(roles);

        try {
            userRepository.save(users);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
