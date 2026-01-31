@Login
Feature: Login Functionality
Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters "<UserName>" and "<Password>"  the user clicks the login button
    Then the user should be redirected to the dashboard
    
Examples:
    | UserName                 | Password    |
    | abcvfsass@gmail.com      | Pass@123    |
    | abcvfsass1@gmail.com     | Pass@123    |
    | abcvfsass@gmail.com      | Pass@1234   |