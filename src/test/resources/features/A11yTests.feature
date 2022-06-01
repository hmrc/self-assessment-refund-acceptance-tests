Feature: A11y tests (Temp)

  @a11y @journey
  Scenario: A11y - Refund Journey
    Given The user starts a personal journey with Nino AA111111A
    When the User toggles on English language
    And the user is on the RefundAmountPage
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    And the user select personal account
    And the user click continue
    And the user enter valid personal bank details
    And the user click continue
    And the user click continue
    And the user click continue

  @a11y @journey
  Scenario: A11y - IV Kickout Page
    Given The user starts a personal journey with confidence level < 250
    And the user Failed IV IV Uplift
    Then the user is on the IvKickoutPage

  @a11y @history
  Scenario: A11y - History Pages
    Given The user starts a history journey
    And the user is on the RefundHistoryPage
    And the user clicks on Processing for result number 1
    And the user is on the StatusProcessingPage
    And the user click back
    And the user clicks on Approved for result number 3
    And the user is on the StatusApprovedPage
    And the user click back
    And the user clicks on the History tab
    And the user clicks on Paid for result number 1
    And the user is on the StatusPaidPage
    And the user click back
    And the user clicks on Rejected for result number 2
    And the user is on the StatusRejectedPage