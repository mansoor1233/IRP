Feature: Login Functionality

  @DecisionMaker
  Scenario: Login in the application
    Given The user launches the chromebrowser
    And user opens the application url "https://techtamminaapps.appiancloud.com/suite/sites/irp3-users-site"
    And Enters the username as "appianrpa.bot" and password as "Tammina123"
    Then Clicks on signin button
    And User should navigate to the Usersite Page
    And User Clicks on the create new campaign button
    And Enters the Role Dropdown
    And Enter the Keyskills
    And Enter the Requirement
    And Enddate

  