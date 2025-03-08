package com.arsh.restfullWebServices.restfullWebServices2.Question3;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/swaggerUser")
@Tag(name = "User Management", description = "Endpoints for managing users")
public class UserController2 {

    private Map<Integer,String > users = new HashMap<>();


    @Operation(summary = "Get User Details", description = "Fetch user details using the user ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully retrieved user details"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public String getUser(@RequestParam(required = false) int id){
        return users.getOrDefault(id,"User not found");
    }

    @Operation(summary = "Save User Details", description = "Save user details by providing an ID and name")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/create")
    public String saveUser(@RequestParam int id, @RequestParam String name){
        users.put(id,name);
        return "User created successfully";
    }

    @Operation(summary = "Delete user", description = "Delete user details by providing an ID or name")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @DeleteMapping("/delete/{id},/delete/{name}")
    public String deleteUser(@RequestParam Integer id){
        if(users.containsKey(id)){
            users.remove(id);
            return "User removed successfully";
        }else{
            return "No user found with provided id";
        }
    }
}
