@a11y @zap
Feature: E2E - Smoke (For accessibility / zap page captures)

  @journey @wip
  Scenario: A11y - Refund Journey
    Given The user starts a personal journey with Nino AB111111D
    When the User toggles on English language
    And the user clicks other amount
    And the user enter an amount of 1
    And the user click continue
    And the user select personal account
    And the user click continue
    And the user enter valid personal bank details without roll number
    And the user click continue
    And the user click continue
    And the user click continue
    And the user signs out

  @journey
  Scenario: A11y - IV Kickout Page
    Given The user starts a personal journey for AB111111D with confidence level < 250
    And the user Failed IV IV Uplift
    Then the user is on the IvKickoutPage
    When the User toggles on Welsh language
    Then the user is on the IvKickoutPage
    And the user signs out

#  @a11y @journey
#  Scenario: A11y - BARS Lockout Refund Journey
#    Given The user starts a personal journey with Nino AA111111A
#    When the User toggles on English language
#    And the user is on the RefundAmountPage
#    And the user clicks other amount
#    And the user enter an amount of 1
#    And the user click continue
#    And the user select personal account
#    And the user click continue
#    And the user enter invalid personal bank details
#    And the user click continue
#    And the user click continue
#    And the user click continue
#    Then the user is on the LockoutPage

  @history
  Scenario: A11y - History Pages
    Given The user starts a history journey for AB111111C
    When the User toggles on English language
    And the user clicks on Processing for result number 1
    And the user click back
    And the user clicks on Approved for result number 2
    And the user click back
    And the user clicks on the History tab
    And the user clicks on Paid for result number 1
    And the user click back
    And the user clicks on Rejected for result number 2
    And the user signs out