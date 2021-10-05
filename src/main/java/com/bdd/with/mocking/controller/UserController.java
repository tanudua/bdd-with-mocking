package com.bdd.with.mocking.controller;

import com.bdd.with.mocking.model.UserData;
import com.bdd.with.mocking.model.UserDetails;
import com.bdd.with.mocking.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tanudua created on 10/4/2021
 */
@RestController
@RequestMapping("/")
@Api(value = "/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAllUsersWhoFirstNameStartsWith")
    @ApiOperation(value = "/getAllUsersWhoFirstNameStartsWith", notes = "Return list of active male users")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Server Error")})
    public UserDetails getAllUsersWhoFirstNameStartsWith(@RequestParam String firstNameStartsWith) {
        return userService.getAllUsersWhoFirstNameStartsWith(firstNameStartsWith);
    }



}
