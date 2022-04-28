Feature: login


Scenario: login
When user enters the credentials "Admin" and "admin123"
Then user should be display ed with the profile page 

Scenario: Invalidlogin
When user enters the wrong credentials
Then user should be display with invalid credentials 