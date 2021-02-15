@Careers
Feature: Careers page feature

  @regression
  Scenario: Careers page title
    Given user is on Careers page
    When user gets the title of the page
    Then page title should be "Careers at Mitigram"

  @regression
  Scenario: Check for Open Positions on Careers page
    Given user is on Careers page
    Then get Count of total open position
    And check the list of open position

  @regression @sanity
  Scenario: Validate the Broken links in Careers page
    Given user is on Careers page
    Then links and images should not be broken on careers page

  Scenario: validate the Contact us functionality for open position
    Given user is on Careers page
    Then CareersMitigram link should be display for mail

  @regression
  Scenario Outline: Introduce yourself for future opening
    Given user is on Careers page
    When user enter "<firstName>""<lastName>""<country>""<email>""<phone>"
    And upload the CV
    And submit the application
    Then user should get confirmation message
    Examples:
      | firstName | lastName | country | email               | phone      |
      | Jaynat    | Kale     | Sweden  | jaynatKal@gmail.com | 8275411638 |


