package com.arsh.restfullWebServices.restfullWebServices2.Question5.controller;

import com.arsh.restfullWebServices.restfullWebServices2.Question5.entity.UserV1;
import com.arsh.restfullWebServices.restfullWebServices2.Question5.entity.UserV2;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserV1V2Controller {

    private final UserV1 userV1 = new UserV1(1, "Arsh nadeem", "Arsh@tothenew.com");
    private final UserV2 userV2 = new UserV2(1, "Abhinav Srivastav", "abhinav@tothenew.com", "Sector 62", "7927923820");

    // a) MIME Versioning:accept header versioning
    @GetMapping(value = "/user", produces = "application/vnd.company.app-v1+json")
    public UserV1 getUserV1Mime() {
        return userV1;
    }

    @GetMapping(value = "/user", produces = "application/vnd.company.app-v2+json")
    public UserV2 getUserV2Mime() {
        return userV2;
    }

    // b) Request Parameter Versioning
    @GetMapping(value = "/user/param", params = "version=1")
    public UserV1 getUserV1Param() {
        return userV1;
    }

    @GetMapping(value = "/user/param", params = "version=2")
    public UserV2 getUserV2Param() {
        return userV2;
    }


    // c) URI Versioning
    @GetMapping("/v1/user")
    public UserV1 getUserV1URI() {
        return userV1;
    }

    @GetMapping("/v2/user")
    public UserV2 getUserV2URI() {
        return userV2;
    }

    // d) Request Header Versioning or custom header versioning
    @GetMapping(value = "/user/header", headers = "X-API-VERSION=1")
    public UserV1 getUserV1Header() {
        return userV1;
    }

    @GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
    public UserV2 getUserV2Header() {
        return userV2;
    }
}
