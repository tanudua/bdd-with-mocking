package com.bdd.with.mocking.service.impl;

import com.bdd.with.mocking.model.UserData;
import com.bdd.with.mocking.model.UserDetails;
import com.bdd.with.mocking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tanudua created on 10/4/2021
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserApi userApi;

    @Override
    public UserDetails getAllUsersWhoFirstNameStartsWith(String firstNameStartsWith) {
        return userApi.getUserDetails().thenApplyAsync(userDetails -> {
           List<UserData> userData = userDetails.getData().stream().filter(ud -> ud.getFirst_name().toLowerCase().startsWith(firstNameStartsWith.toLowerCase()))
                   .collect(Collectors.toList());
           userDetails.setData(userData);
           return userDetails;
        }).exceptionally(e -> {
            UserDetails userDetails = new UserDetails();
            userDetails.setError(true);
            userDetails.setErrorMessage(e.getMessage());
            return userDetails;
        }).join();
    }
}
