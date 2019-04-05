Feature:Test login page

  Scenario: Test positive login page
    Given I am on main application page
    When I login as correct user
    Then I see logout link

	Scenario: Test move email to Spam
	 Given I am on main application page
     When I login as correct user
     And I mark first email by checkbox
     And I click on clickIsSpamButton
     Then count of emails less for one