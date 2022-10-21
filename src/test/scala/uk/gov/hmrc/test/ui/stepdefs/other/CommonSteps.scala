/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
      case "RefundHistoryPage" => AuthWizardPage.enterRedirectUrl(RefundsHistoryPage.urlOrigin)
      case "StatusApprovedPage" => AuthWizardPage.enterRedirectUrl(StatusApprovedPage.url)
      case "StatusPendingPage" => AuthWizardPage.enterRedirectUrl(StatusProcessingPage.url)
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
      case "RefundHistoryPage" =>
        RefundsHistoryPage.shouldBeLoaded()
        RefundsHistoryPage.assertContent("In Progress")
        RefundsHistoryPage.clickTab("History")
        RefundsHistoryPage.assertContent("History")
      case "SurveyPage" =>
        SurveyPage.shouldBeLoaded()
      case "StatusApprovedPage" =>
        StatusApprovedPage.shouldBeLoaded()
        StatusApprovedPage.assertContent()
      case "StatusProcessingPage" =>
        StatusProcessingPage.shouldBeLoaded()
        StatusProcessingPage.assertContent()
      case "StatusRejectedPage" =>
        StatusRejectedPage.shouldBeLoaded()
        StatusRejectedPage.assertContent()
      case "StatusPaidPage" =>
        StatusPaidPage.shouldBeLoaded()
        StatusPaidPage.assertContent()
      case "IvKickoutPage" =>
        //TODO - probable bug - no ticket for it.
//        IvKickoutPage.shouldBeLoaded()
        IvKickoutPage.assertContent()
      case "LockoutPage" =>
        LockoutPage.shouldBeLoaded()
        LockoutPage.assertContent()
      case "DesErrorPage" =>
        DesErrorPage.shouldBeLoaded()
        DesErrorPage.assertContent()
      case "ItsaViewerPage" => ItsaViewerPage.assertCurrentUrl()
    }
  }
}
