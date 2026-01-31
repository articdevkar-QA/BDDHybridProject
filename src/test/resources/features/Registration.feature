@Register
Feature:Registration Functionality
Scenario: Register for a new user
Given User should be on demo Web Shop
When User Enter all deatils required for registration and click on register button
Then Registration should be successful
