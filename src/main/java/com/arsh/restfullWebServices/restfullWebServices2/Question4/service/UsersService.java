package com.arsh.restfullWebServices.restfullWebServices2.Question4.service;

import com.arsh.restfullWebServices.restfullWebServices2.Question4.entity.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsersService {

    private List<Users> users = new ArrayList<>();

    public Users saveUsers(Users user) {
        users.add(user);
        return user;
    }

    public List<Users> getAllUsers() {
        return users;
    }
}
