Feature: Authentication page test

  Scenario Outline: Authentication sucess in the page
    Given I visit the page in app
    When I enter the page with this information
      | user   | passwordUser   |
      | <user> | <passwordUser> |
    Then I verify the entry to the page

    Examples:
      | user                   | passwordUser |
      | agudelo.0312@gmail.com | Sebas18+     |

