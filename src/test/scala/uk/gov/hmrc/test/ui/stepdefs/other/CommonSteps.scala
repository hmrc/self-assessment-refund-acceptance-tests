package uk.gov.hmrc.test.ui.stepdefs.other

import uk.gov.hmrc.test.ui.pages._
import uk.gov.hmrc.test.ui.pages.support.HelperFunctions
import uk.gov.hmrc.test.ui.testdata.{Language, ScenarioContext}

class CommonSteps extends Steps with DriverActions {

  And("""^the user click continue$""") { () =>
    continue()
  }

  And("""^the user click back""") { () =>
    clickBack()
  }

  And("""^The user begins their (personal|business) journey (and has|without) card on file$""") { (accType: String, card: String) =>
    ScenarioContext.set("personalOrBusiness", accType)
    go to (AuthWizardPage.url)
    AuthWizardPage.enterRedirectUrl(ViewChangeAccountPage.url)
    //TODO Sort out test user creds / stubs
    card match {
//      case "and has" => AuthWizardPage.enterValidNinoWithCardOnFile()
      case "and has" => AuthWizardPage.enterValidNino()
//      case "without" => AuthWizardPage.enterValidNinoWithoutCardOnFile()
      case "without" => AuthWizardPage.enterValidNino()
    }
    AuthWizardPage.clickSubmit()
  }

  When("""^the User toggles on (Welsh|English) language$""") { option: String =>
    if (option == "Welsh") {
      HelperFunctions.toggleLangOn(Language.welsh)
      ScenarioContext.set("langToggle", Language.welsh)
    } else {
      HelperFunctions.toggleLangOn(Language.english)
      ScenarioContext.set("langToggle", Language.english)
    }
  }

  Given("""^The user begins their (personal|business) journey with (.*)$""") { (accType: String, page: String) =>
    ScenarioContext.set("personalOrBusiness", accType)
    go to (AuthWizardPage.url)
    page match {
      //Test purposes to go to any page with this function
      case "RefundAmountPage" => AuthWizardPage.enterRedirectUrl(RefundAmountPage.url)
      case "AccountOnFilePage" => AuthWizardPage.enterRedirectUrl(AccountOnFilePage.url)
      case "CheckDetailsPage" => AuthWizardPage.enterRedirectUrl(CheckDetailsPage.url)
      case "AuthenticationPage" => AuthWizardPage.enterRedirectUrl(AuthenticationPage.url)
      case "RequestReceivedPage" => AuthWizardPage.enterRedirectUrl(RequestReceivedPage.url)
      case "EnterBankDetailsPage" => AuthWizardPage.enterRedirectUrl(EnterBankDetailsPage.url)
      case "TypeOfAccountPage" => AuthWizardPage.enterRedirectUrl(TypeOfAccountPage.url)
      case "ViewChangeAccountPage" => AuthWizardPage.enterRedirectUrl(ViewChangeAccountPage.url)
      case "RefundHistoryPage" => AuthWizardPage.enterRedirectUrl(RefundsHistoryPage.urlOrigin)
      case "StatusCompletedPage" => AuthWizardPage.enterRedirectUrl(StatusCompletedPage.url)
      case "StatusPendingPage" => AuthWizardPage.enterRedirectUrl(StatusPendingPage.url)
      case "StatusRejectedPage" => AuthWizardPage.enterRedirectUrl(StatusRejectedPage.url)
      case "SurveyPage" => AuthWizardPage.enterRedirectUrl(SurveyPage.urlRedirect)
      case _ => AuthWizardPage.clickSubmit()
    }
    AuthWizardPage.enterValidNino()
    AuthWizardPage.clickSubmit()
  }

  And("""^the user is on the (.*)$""") { page: String =>
    page match {
      case "RefundAmountPage" =>
        RefundAmountPage.shouldBeLoaded()
        RefundAmountPage.assertContent()
      case "AccountOnFilePage" =>
        AccountOnFilePage.shouldBeLoaded()
        AccountOnFilePage.assertContent()
      case "CheckDetailsPage" =>
        CheckDetailsPage.shouldBeLoaded()
        CheckDetailsPage.assertContent()
      case "AuthenticationPage" =>
        AuthenticationPage.shouldBeLoaded()
      case "RequestReceivedPage" =>
        RequestReceivedPage.shouldBeLoaded()
        RequestReceivedPage.referenceNumberDisplayed()
        RequestReceivedPage.setReferenceNumber()
        RequestReceivedPage.assertContent()
      case "EnterBankDetailsPage" =>
        EnterBankDetailsPage.shouldBeLoaded()
        EnterBankDetailsPage.assertContent()
      case "TypeOfAccountPage" =>
        TypeOfAccountPage.shouldBeLoaded()
        TypeOfAccountPage.assertContent()
      case "ViewChangeAccountPage" =>
        ViewChangeAccountPage.shouldBeLoaded()
        ViewChangeAccountPage.refundCreditAmount()
      case "RefundHistoryPage" =>
        RefundsHistoryPage.shouldBeLoaded()
        RefundsHistoryPage.assertContent("In Progress")
        RefundsHistoryPage.clickTab("Completed")
        RefundsHistoryPage.assertContent("Completed")
      case "SurveyPage" =>
        SurveyPage.shouldBeLoaded()
      case "StatusCompletedPage" =>
        StatusCompletedPage.shouldBeLoaded()
        StatusCompletedPage.assertContent()
      case "StatusPendingPage" =>
        StatusPendingPage.shouldBeLoaded()
        StatusPendingPage.assertContent()
      case "StatusRejectedPage" =>
        StatusRejectedPage.shouldBeLoaded()
        StatusRejectedPage.assertContent()
    }
  }
}
