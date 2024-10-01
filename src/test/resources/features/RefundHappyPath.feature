@test
Feature: Refund Happy Path

  Scenario Outline: Individual user completes refund with card on file
    Given The Individual user starts a refund journey with Nino AB200111C, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects <amount> and clicks continue
    Then the user is on the HowYouWillGetTheRefundPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects <accountType> and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid <bank details> bank details <roll number> roll number and clicks continue
    Then the user is on the CheckYourAnswersPage
    And the page shows <checkAnswersAmount> and <checkAnswersRoll> the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage
    Examples:
      | amount               | accountType      | bank details | roll number | checkAnswersAmount   | checkAnswersRoll |
      | the full amount      | business account | business     | with        | the full amount      | shows            |
      | the full amount      | personal account | personal     | with        | the full amount      | shows            |
      | the full amount      | business account | business     | without     | the full amount      | doesn't show     |
      | the full amount      | personal account | personal     | without     | the full amount      | doesn't show     |
      | the suggested amount | business account | business     | with        | the suggested amount | shows            |
      | the suggested amount | personal account | personal     | with        | the suggested amount | shows            |
      | the suggested amount | business account | business     | without     | the suggested amount | doesn't show     |
      | the suggested amount | personal account | personal     | without     | the suggested amount | doesn't show     |
      | a different amount   | business account | business     | with        | the amount typed     | shows            |
      | a different amount   | personal account | personal     | with        | the amount typed     | shows            |
      | a different amount   | business account | business     | without     | the amount typed     | doesn't show     |
      | a different amount   | personal account | personal     | without     | the amount typed     | doesn't show     |

  Scenario: Individual user completes refund without card on file and clicks feedback link
    Given The Individual user starts a refund journey with Nino AB200111D, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the WeNeedYourBankDetailsPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects personal account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid personal bank details without roll number and clicks continue
    Then the user is on the CheckYourAnswersPage
    And the page shows the amount typed and doesn't show the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage
    When the user clicks the feedback link
    Then the user is on the SurveyPage

  Scenario: Organisation user completes refund with card on file
    Given The Organisation user starts a refund journey with Nino AB200111C, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects the full amount and clicks continue
    Then the user is on the HowYouWillGetTheRefundPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects business account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid business bank details with roll number and clicks continue
    Then the user is on the CheckYourAnswersPage
    And the page shows the full amount and shows the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage

  Scenario: Organisation user completes refund without card on file
    Given The Organisation user starts a refund journey with Nino AB200111D, confidence 250, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the WeNeedYourBankDetailsPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects personal account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid personal bank details without roll number and clicks continue
    Then the user is on the CheckYourAnswersPage
    And the page shows the amount typed and doesn't show the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage

  Scenario: Agent user completes refund with card on file
    Given The Agent user starts a refund journey with Nino AB200111C, confidence 50, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the HowYourClientWillGetRefundPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects personal account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid personal bank details without roll number and clicks continue
    Then the user is on the CheckYourAnswersPage
    And the page shows the amount typed and doesn't show the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage

  Scenario: Agent user completes refund without card on file
    Given The Agent user starts a refund journey with Nino AB200111D, confidence 50, and urls provided
    Then the user is on the RefundAmountPage
    When the user selects a different amount and clicks continue
    Then the user is on the WeNeedYourClientsBankDetailsPage
    When the user clicks continue
    Then the user is on the TypeOfAccountPage
    When the user selects personal account and clicks continue
    Then the user is on the EnterBankDetailsPage
    When the user enters valid personal bank details without roll number and clicks continue
    Then the user is on the CheckYourAnswersPage
    And the page shows the amount typed and doesn't show the roll number
    When the user clicks continue
    Then the user is on the DummyReauthenticationPage
    When the user clicks continue
    Then the user is on the RequestReceivedPage

    #TODO: after OPS-12792, consider other Agent auth scenarios e.g. Legacy & Non-Legacy, Just Delegated Enrolment Only