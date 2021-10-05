Feature: Feature_two: Get user data from external service with mocking

  Scenario: Validate if users are returned as per first name showcasing mocking
    Given Feature_two: A User Details Service
    When Feature_two: I request for user details whose first name starts with 'S' and first_name as 'Spider' and last_name as 'Man'
    Then Feature_two: I get the user details with first_name as 'Spider' and last_name as 'Man'

