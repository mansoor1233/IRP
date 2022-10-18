Feature: Tabledata

  @Table
  Scenario: fetching data to excel
    Given The user launches the chromebrowser
    And user opens the application url "https://techtamminaapps.appiancloud.com/suite/sites/irp3-users-site"
    And Enters the username as "appianrpa.bot" and password as "Tammina123"
    Then Clicks on signin button
    And Get the tabledata to excel
