Feature: Rest Facade test

  Scenario: Make a GET request as String
    Given I make a GET to "http://jsonplaceholder.typicode.com/posts/1" as string

  Scenario: Make a GET request as object
    Given I make a GET to "http://jsonplaceholder.typicode.com/posts/1" as object

  Scenario: Make a POST request with a String
    Given I make a POST request to "http://httpbin.org/post" as String

  Scenario: Make a POST request using an Object
    Given I make a POST request to "http://jsonplaceholder.typicode.com/posts/" with object
      | 111 | 12 | Alex | test |

  Scenario: I want to convert object to map
    Given I convert Object to map
      | userId | 112      |
      | id     | 2        |
      | title  | Alex     |
      | body   | for test |

