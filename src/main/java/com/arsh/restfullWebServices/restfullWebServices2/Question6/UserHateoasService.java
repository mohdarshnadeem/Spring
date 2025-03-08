package com.arsh.restfullWebServices.restfullWebServices2.Question6;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserHateoasService {

    private final List<UsersHateoas> users = Arrays.asList(
            new UsersHateoas(1, "Rajesh Sharma", "rajesh.sharma@example.com"),
            new UsersHateoas(2, "Priya Iyer", "priya.iyer@example.com"),
            new UsersHateoas(3, "Amit Kumar", "amit.kumar@example.com"),
            new UsersHateoas(4, "Neha Verma", "neha.verma@example.com")
    );

    public UsersHateoas getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<UsersHateoas> getAllUsers() {
        return users;
    }
}
