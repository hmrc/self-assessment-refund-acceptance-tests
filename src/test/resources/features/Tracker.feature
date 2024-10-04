@test
Feature: Tracker Pages

  Scenario: Users views Paid Refund
    Given The Individual user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view approved
    Then the user is on the StatusApprovedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: User views Rejected Refund
    Given The Individual user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    And the user clicks view rejected
    Then the user is on the StatusRejectedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: User views Processing Refund
    Given The Individual user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view processing
    Then the user is on the StatusProcessingPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: User views Processing Risking Refund
    Given The Individual user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view processing risking
    Then the user is on the StatusProcessingRiskingPage
    When the user clicks back to tax account
    # add when button leads somewhere