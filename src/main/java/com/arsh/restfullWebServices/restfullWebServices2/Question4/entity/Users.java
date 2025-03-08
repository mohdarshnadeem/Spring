package com.arsh.restfullWebServices.restfullWebServices2.Question4.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFilter("UserFilter")
public class Users {
    private Long id;
    private String name;
    private String email;
//    @JsonIgnore  // This will statically ignore the password field in the response
    private String password;

    public Users(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

//    @JsonIgnore
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }
}
