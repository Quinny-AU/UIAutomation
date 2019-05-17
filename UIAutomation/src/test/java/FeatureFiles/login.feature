Feature: Login and Registration functionality

@registerS
@positiveScenario
Scenario: User successfully register account
Given Initialize browser to shopping site
When User enters valid email address and account details
Then User successfully registers account

@registerF
@negativeScenario
Scenario Outline: User register account fail
Given Initialize browser to shopping site and navigates to registration
When User enters invalid <email> address
Then User account registration fails
And User enters already registered <registeredEmail>
Then User registration is rejected

Examples:
|email	|registeredEmail|
|test@#gmail.com|bradyquinn96@gmail.com|