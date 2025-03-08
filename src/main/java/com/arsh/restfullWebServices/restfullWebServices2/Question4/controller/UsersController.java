package com.arsh.restfullWebServices.restfullWebServices2.Question4.controller;

import com.arsh.restfullWebServices.restfullWebServices2.Question4.entity.Users;
import com.arsh.restfullWebServices.restfullWebServices2.Question4.service.UsersService;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // Static Filtering: Saves Users and Hides Password
    @PostMapping("/save-static")
    public Users saveUsersStatic(@RequestBody Users Users) {
        return usersService.saveUsers(Users);
    }

    // Dynamic Filtering: Saves Users and Dynamically Hides Password
    // Dynamic Filtering API
    @PostMapping("/save-dynamic")
    public MappingJacksonValue saveUserDynamic(@RequestBody Users user) {
        Users savedUser = usersService.saveUsers(user);

        // Applying dynamic filtering, we have to specify @JsonFilter ion bean class and @JsonProperty on the password
        // field so that spring identify field which we don't want to serialize
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("password");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(savedUser);
        mapping.setFilters(filters);

        return mapping;
    }
}

