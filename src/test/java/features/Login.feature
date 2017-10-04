Feature: LoginFeature
  This feature deals with the login functionality on Index Page

  Scenario: Login with correct username and password
    Given I am on Index Page
    When I login as "epam"/"1234"
    Then Name "Piter Chailovskii" must be displayed on the right upper corner of the page
    And All Index page elements exist

    Scenario: Open and work on Different Elements Page
      Given I am on Different Elements Page
      When All Different Elements page elements exist
      And Select and checked all need elements
      Then All need logs appeared in Log Section for selected elements
      When Unselect and check all need elements
      Then All need logs appeared in Log Section for unselected elements


