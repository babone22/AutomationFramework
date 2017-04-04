Feature: Rest Facade test

  Scenario: Make a GET request as String
    Given I make a GET to "http://jsonplaceholder.typicode.com/posts/1" as string

  Scenario: Make a GET request as object
    Given I make a GET to "http://jsonplaceholder.typicode.com/posts/1" as object
