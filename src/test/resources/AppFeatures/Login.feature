@login @Functional
Feature: Login page feature

  @regression @Test
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Mitigram"

  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario Outline: Try to login with Invalid credentials
    Given user is on login page
    When user enters username "<UserName>"
    And user enters password "<PassWord>"
    And user clicks on Login button
    Then user should get Error message

    Examples:
      | UserName            | PassWord |
      |                     |          |
      | jaynatkal           | password |
      | jayantkal@gmail.com | password |

  @sanity
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "mitigramUserName"
    And user enters password "MitiGramUserPassord"
    And user clicks on Login button
    Then user should be navigate on dashBoard screen

  @regression
  Scenario: Validate all links are working on Login screen
    Given user is on login page
    Then links and images should not be broken on page

  @regression @sanity
  Scenario: ContactUs Link validation
    Given user is on login page
    Then Click here to contact us link should be display

  @sanity
  Scenario: Validate the App store icons and links
    Given user is on login page
    Then app store icon should be display
    And google play icon should be display
