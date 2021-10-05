package com.bdd.with.mocking;

import com.bdd.with.mocking.controller.UserController;
import com.bdd.with.mocking.model.UserDetails;
import com.bdd.with.mocking.service.impl.UserApi;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import org.jeasy.random.EasyRandom;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author tanudua created on 10/5/2021
 */
public class UserDetailsWithMockingTest extends BaseTest {

    @Autowired
    private UserController userController;

    private UserDetails userDetails;

    @Given("Feature_two: A User Details Service")
    public void feature_two_a_user_details_service() {
        // do initialization here. In this example there was no need to do any initialization
    }

    @When("Feature_two: I request for user details whose first name starts with {string} and first_name as {string} and last_name as {string}")
    public void feature_two_i_request_for_user_details_whose_first_name_starts_with_and_first_name_as_and_last_name_as(String firstNameStartsWith,String firstName, String lastName) {
        new Expectations() {{
            new MockUp<UserApi>() {
                @Mock
                public CompletableFuture<UserDetails> getUserDetails() {
                    EasyRandom generator = new EasyRandom();
                    UserDetails userDetails = generator.nextObject(UserDetails.class);
                    userDetails.getData().get(0).setFirst_name(firstName);
                    userDetails.getData().get(0).setLast_name(lastName);
                    return CompletableFuture.completedFuture(userDetails);
                }

            };

        }};

        userDetails = userController.getAllUsersWhoFirstNameStartsWith(firstNameStartsWith);
    }

    @Then("Feature_two: I get the user details with first_name as {string} and last_name as {string}")
    public void feature_two_i_get_the_user_details_with_first_name_as_and_last_name_as(String firstName, String lastName) {
        Assert.assertTrue(userDetails.getData().get(0).getFirst_name().equalsIgnoreCase(firstName));
        Assert.assertTrue(userDetails.getData().get(0).getLast_name().equalsIgnoreCase(lastName));
    }


    @After
    public void tearDown() {
        userDetails = null;
    }

}