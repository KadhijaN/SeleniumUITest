Feature: Login to Reddit and perform some operations

  Scenario: Log in to Reddit and perform operations
    Given I open the Reddit website
    When I log in with username "testscript1406" and password "TestScript123"
    Then I should see my Reddit homepage
    When I search for subreddit "sports"
    Then I should open the first subreddit result and print the top post title
    Then I should toggle the upvote or downvote on the second post