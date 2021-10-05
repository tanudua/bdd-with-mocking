Feature: Feature_one : Get user data from external service

  Scenario: Validate if users are returned as per first name showcasing full integration tests
    Given Feature_one: A User Details Service to test
    When Feature_one: I request for user details whose first name starts with 'George'
    Then Feature_one: I get the user details for those users

