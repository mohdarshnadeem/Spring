package com.arsh.restfullWebServices.restfullWebServices2.Question6;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usersHateoas")
public class UserHateoasController {

    private final UserHateoasService userService;

    public UserHateoasController(UserHateoasService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public EntityModel<UsersHateoas> getUserById(@PathVariable int id) {
        UsersHateoas user = userService.getUserById(id);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        EntityModel<UsersHateoas> entityModel = EntityModel.of(user);

        // HATEOAS link to fetch all users
        WebMvcLinkBuilder linkToAllUsers = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers()
        );
        entityModel.add(linkToAllUsers.withRel("all-users"));

        return entityModel;
    }

    @GetMapping
    public List<EntityModel<UsersHateoas>> getAllUsers() {
        List<UsersHateoas> users = userService.getAllUsers();

        return users.stream().map(user -> {
            EntityModel<UsersHateoas> entityModel = EntityModel.of(user);
            entityModel.add(WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(this.getClass()).getUserById(user.getId())
            ).withSelfRel());

            return entityModel;
        }).collect(Collectors.toList());
    }
}
