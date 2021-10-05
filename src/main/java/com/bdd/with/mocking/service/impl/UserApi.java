package com.bdd.with.mocking.service.impl;

import com.bdd.with.mocking.model.UserDetails;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * @author tanudua created on 10/4/2021
 */
@Component
public class UserApi {

    private Logger logger = LoggerFactory.getLogger(UserApi.class);

    private final String userApiUrl;

    public UserApi(@Value("${userApiUrl}") String userApiUrl) {
        this.userApiUrl = userApiUrl;
    }

    public CompletableFuture<UserDetails> getUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            final String url = userApiUrl + "/users";
            RestTemplate restTemplate = new RestTemplate();
            try {
                UserDetails userDetails =  restTemplate.getForObject(url,UserDetails.class);
                return userDetails;
            } catch (RestClientException e) {
                logger.error("Exception in hitting user api : " + e.getMessage());
                throw e;
            }
        });
    }
}
