package com.example.interview.service;

import com.example.interview.entity.dto.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public boolean validateUser(User user){
        if("user".equals(user.getUsername()) && "user".equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
