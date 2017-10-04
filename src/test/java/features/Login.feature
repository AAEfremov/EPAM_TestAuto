Feature: LoginFeature
  This feature deals with the functionality of Index Page and Different Elements Page

  Scenario: Login with correct username and password and check that all elements exist on Index page
    Given Open Index Page
    When I login as epam/1234
    Then Name Piter Chailovskii must be displayed on the right upper corner of the page
    And All Index page elements exist
    And All elements of Header and Left Service dropdown menu exist


    Scenario: Open and work on Different Elements Page
      Given Open Different Elements Page
      When All Different Elements page elements exist
      And Select and check Water checkbox
      And Select and check Wind checkbox
      And Select and check Selen radio
      And Select and check Yellow color
      Then All need logs appeared in Log Section for selected elements
      When Unselect and check Water checkbox
      When Unselect and check Wind checkbox
      Then All need logs appeared in Log Section for unselected elements


