Feature: A11y tests (Temp)

  @a11y @zap
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

  @a11y @zap
  Scenario: A11y - History Pages
    Given The user begins their personal journey with RefundHistoryPage
    And the user is on the RefundHistoryPage
    And the user clicks on View Progress for result number 1
    And the user is on the StatusPendingPage
    And the user click back
    And the user clicks on the Completed tab
    And the user clicks on Completed for result number 1
    And the user is on the StatusCompletedPage
    And the user click back
    And the user clicks on Rejected for result number 3
    And the user is on the StatusRejectedPage