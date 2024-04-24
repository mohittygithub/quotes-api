package com.quotes.controller;

import com.quotes.dto.ApiResponse;
import com.quotes.dto.UserRegisterRequest;
import com.quotes.service.UserService;
import com.quotes.util.Utility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Utility utility;

    public UserController(UserService userService, Utility utility) {
        this.userService = userService;
        this.utility = utility;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserRegisterRequest userRegisterRequest){
        return new ResponseEntity<>(new ApiResponse(utility.getUrlPath(), 201, true, "Created successfully", List.of(userService.createUser(userRegisterRequest))), HttpStatus.CREATED);
    }
}
