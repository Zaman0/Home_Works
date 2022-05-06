Feature: login


Scenario Outline: login
When user enters the credentials
|Admin| admin123|
Then user should be displayed with the profile page
