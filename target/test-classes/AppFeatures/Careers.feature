@Careers
Feature: Careers page feature

  @regression @Test
  Scenario: Careers page title
    Given user is on Careers page
    When user gets the title of the page
    Then page title should be "Careers at Mitigram"

  @regression @position
  Scenario: Check for Open Positions on Careers page
    Given user is on Careers page
    Then get Count of total open position
    And check the list of open position

  @regression @sanity @link
  Scenario: Validate the Broken links in Careers page
    Given user is on Careers page
    Then links and images should not be broken on careers page

  Scenario: validate the Contact us functionality for open position
    Given user is on Careers page
    Then CareersMitigram link should be display for mail



