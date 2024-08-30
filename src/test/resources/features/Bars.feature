@test
Feature: BARS

  Scenario Outline: User fails verify checks
    Given The user starts a refund journey with Nino AB111111D, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects <account> and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters <bank> bank details without roll number and clicks continue
    Then the user sees the BARS error for failing verify checks
    When the user clicks continue
    Then the user sees the BARS error for failing verify checks
    When the user clicks continue
    Then the user is on the LockoutPage
    When the user clicks contact HMRC
    Then the user is on the SaEnquiresPage
    Examples:
      | account          | bank                |
      | business account | wrong name business |
      | personal account | wrong name personal |

  Scenario Outline: User fails validate checks 4 times without lockout
    Given The user starts a refund journey with Nino AB111111D, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects <account> and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters <bank> bank details without roll number and clicks continue
    Then the user sees the BARS error for failing validate checks
    When the user clicks continue
    Then the user sees the BARS error for failing validate checks
    When the user clicks continue
    Then the user sees the BARS error for failing validate checks
    When the user clicks continue
    Then the user sees the BARS error for failing validate checks
    Examples:
      | account          | bank             |
      | business account | invalid business |
      | personal account | invalid personal |

  Scenario Outline: User fails validate checks
    Given The user starts a refund journey with Nino AB111111D, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects <account> and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters <bank> bank details without roll number and clicks continue
    Then the user sees the BARS error for <error>
    Examples:
      | account          | bank                    | error                   |
      | personal account | wellFormatted=No        | failing validate checks |
      | business account | onEISCD=No              | failing validate checks |
      | personal account | denyList                | failing validate checks |
      | business account | supportsDirectCredit=No | an unsupported account  |
      | business account | missingRollNumber       | missing roll number     |