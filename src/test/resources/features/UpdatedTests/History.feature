@test
Feature: Happy Path (Refund)

  Scenario: Views Paid Refund
    Given The user starts a history journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundHistoryPage
    When the user clicks the history tab
    And the user clicks view paid
    Then the user is on the StatusPaidPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: Views Rejected Refund
    Given The user starts a history journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundHistoryPage
    When the user clicks the history tab
    And the user clicks view rejected
    Then the user is on the StatusRejectedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: Views Approved Refund
    Given The user starts a history journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundHistoryPage
    When the user clicks view approved
    Then the user is on the StatusApprovedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: Happy Processing Refund
    Given The user starts a history journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundHistoryPage
    When the user clicks view processing
    Then the user is on the StatusProcessingPage
    When the user clicks back to tax account
    # add when button leads somewhere