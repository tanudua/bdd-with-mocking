package com.bdd.with.mocking.service;

import com.bdd.with.mocking.model.UserData;
import com.bdd.with.mocking.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tanudua created on 10/4/2021
 */
public interface UserService {
    public UserDetails getAllUsersWhoFirstNameStartsWith(String firstNameStartsWith);
}
