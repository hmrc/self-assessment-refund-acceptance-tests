@test
Feature: History Pages

  Scenario: Users views Paid Refund
    Given The Individual user starts a history journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundHistoryPage
    When the user clicks the history tab
    And the user clicks view paid
    Then the user is on the StatusPaidPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: User views Rejected Refund
    Given The Individual user starts a history journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundHistoryPage
    When the user clicks the history tab
    And the user clicks view rejected
    Then the user is on the StatusRejectedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: User views Approved Refund
    Given The Individual user starts a history journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundHistoryPage
    When the user clicks view approved
    Then the user is on the StatusApprovedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: User views Processing Refund
    Given The Individual user starts a history journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundHistoryPage
    When the user clicks view processing
    Then the user is on the StatusProcessingPage
    When the user clicks back to tax account
    # add when button leads somewhere