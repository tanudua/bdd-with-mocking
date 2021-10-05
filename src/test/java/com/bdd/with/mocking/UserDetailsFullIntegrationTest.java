package com.bdd.with.mocking;

import com.bdd.with.mocking.controller.UserController;
import com.bdd.with.mocking.model.UserData;
import com.bdd.with.mocking.model.UserDetails;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author tanudua created on 10/5/2021
 */
public class UserDetailsFullIntegrationTest extends BaseTest {

    @Autowired
    private UserController userController;

    private UserDetails userDetails;

    private String firstNameStartsWith;

    @Given("Feature_one: A User Details Service to test")
    public void feature_one_a_user_details_service_to_test() {
        // do initialization here. In this example there was no need to do any initialization
    }

    @When("Feature_one: I request for user details whose first name starts with {string}")
    public void feature_one_i_request_for_user_details_whose_first_name_starts_with(String firstNameStartsWith) {
        this.firstNameStartsWith = firstNameStartsWith;
        userDetails = userController.getAllUsersWhoFirstNameStartsWith(firstNameStartsWith);
    }

    @Then("Feature_one: I get the user details for those users")
    public void feature_one_i_get_the_user_details_for_those_users() {
        List<UserData> userData =  userDetails.getData();
        Assert.assertTrue(userData!=null && userData.size()>0);
        Assert.assertTrue(userData.get(0).getFirst_name().toLowerCase().startsWith(firstNameStartsWith.toLowerCase()));
    }


    @After
    public void tearDown() {
        userDetails = null;
        firstNameStartsWith = null;
    }
}
