@serenity
Feature: Serenity Test

  Scenario: Basic open page and click test
    Given I navigate to the following webpage "http://www.emag.ro/homepage?ref=emag_CMP-494"
    And I navigate to the category "Fashion"
    Then I should see the pageTitle containing "Fashion"
