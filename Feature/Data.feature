Feature: Login Functionality

  @DecisionMaker
  Scenario: Login in the application
    Given The user opens the application
    And Enters the username and password
    Then Clicks on signin button
    And User should navigate to the Usersite Page
    And User Clicks on the create new campaign button
    And Enters the Required fields
