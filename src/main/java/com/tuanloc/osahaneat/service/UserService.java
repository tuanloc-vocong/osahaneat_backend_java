package com.tuanloc.osahaneat.service;

import com.tuanloc.osahaneat.dto.UserDto;
import com.tuanloc.osahaneat.entity.Users;
import com.tuanloc.osahaneat.repository.UserRepository;
import com.tuanloc.osahaneat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImpl {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUser() {
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
}
