@test
Feature: Tracker Pages

  Scenario: Individual user views Approved Refund
    Given The Individual user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view approved
    Then the user is on the StatusApprovedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: Individual user views Rejected Refund
    Given The Individual user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    And the user clicks view rejected
    Then the user is on the StatusRejectedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario Outline: Individual user views Processing Refund
    Given The Individual user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view processing
    Then the user is on the RefundProcessingPage
    When the user clicks <URL>
    Then the user is on the <page>
    Examples:
      | URL                     | page              |
      | back                    | RefundTrackerPage |
      | contact us (processing) | SaEnquiresPage    |

  Scenario: Individual user views Processing Risking Refund
    Given The Individual user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view processing risking
    Then the user is on the StatusProcessingRiskingPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: Agent user views Approved Refund
    Given The Agent user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view approved
    Then the user is on the StatusApprovedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario: Agent user views Rejected Refund
    Given The Agent user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    And the user clicks view rejected
    Then the user is on the StatusRejectedPage
    When the user clicks back to tax account
    # add when button leads somewhere

  Scenario Outline: Agent user views Processing Refund
    Given The Agent user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view processing
    Then the user is on the RefundProcessingPage
    When the user clicks <URL>
    Then the user is on the <page>
    Examples:
      | URL                     | page              |
      | back                    | RefundTrackerPage |
      | contact us (processing) | SaEnquiresPage    |

  Scenario: Agent user views Processing Risking Refund
    Given The Agent user starts a tracker journey with Nino AB111111C, confidence 250, and urls provided
    Then the user is on the RefundTrackerPage
    When the user clicks view processing risking
    Then the user is on the StatusProcessingRiskingPage
    When the user clicks back to tax account
    # add when button leads somewhere
