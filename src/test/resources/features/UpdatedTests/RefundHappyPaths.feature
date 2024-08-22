@test
Feature: Happy Path (Refund)

  Scenario Outline: Happy Path - Card on File
    Given The user starts a journey with Nino AB111111C
    Then the user is on the RefundAmountPage
    When the user selects <amount> and clicks continue
    Then the user is on the AccountOnFilePage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects <accountType> and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid <bank details> bank details <roll number> roll number and clicks continue
    Then the user is on the CheckDetailsPage
    And the page shows <checkAnswersAmount> and <checkAnswersRoll> the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage
    Examples:
      | amount             | accountType      | bank details | roll number | checkAnswersAmount | checkAnswersRoll |
      | the full amount    | business account | business     | with        | the full amount    | shows            |
      | the full amount    | personal account | personal     | with        | the full amount    | shows            |
      | the full amount    | business account | business     | without     | the full amount    | doesn't show     |
      | the full amount    | personal account | personal     | without     | the full amount    | doesn't show     |
      | a different amount | business account | business     | with        | the amount typed   | shows            |
      | a different amount | personal account | personal     | with        | the amount typed   | shows            |
      | a different amount | business account | business     | without     | the amount typed   | doesn't show     |
      | a different amount | personal account | personal     | without     | the amount typed   | doesn't show     |

  Scenario: Happy Path - No Card on File & User clicks feedback link
    Given The user starts a journey with Nino AB111111D
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects personal account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid personal bank details without roll number and clicks continue
    Then the user is on the CheckDetailsPage
    And the page shows the amount typed and doesn't show the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage
    When the user clicks the feedback link
    Then the user is on the SurveyPage

  Scenario: Enrolment with low confidence