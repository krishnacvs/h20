Feature: H20 Application Home page BDD

@WebTest
Scenario: Home page default landing page
Given User is on landing page
When User loads the application url
Then Home page is populated
And Navigate to Countries Link








