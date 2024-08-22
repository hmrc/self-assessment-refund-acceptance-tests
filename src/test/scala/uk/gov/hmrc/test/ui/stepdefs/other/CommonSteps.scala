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
import uk.gov.hmrc.test.ui.stepdefs.DriverActions
import uk.gov.hmrc.test.ui.testdata.{Language, ScenarioContext}

class CommonSteps extends DriverActions {

  And("""^the user signs out$""") { () =>
    signOut()
  }

  And("""^the user click back""") { () =>
    clickBack()
  }
  And("""^the user clicks browser back""") { () =>
    goBack()
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
      case "RefundHistoryPage" => AuthWizardPage.enterRedirectUrl(RefundsHistoryPage.url)
      case "StatusApprovedPage" => AuthWizardPage.enterRedirectUrl(StatusApprovedPage.url)
      case "StatusPendingPage" => AuthWizardPage.enterRedirectUrl(StatusProcessingPage.url)
      case "StatusRejectedPage" => AuthWizardPage.enterRedirectUrl(StatusRejectedPage.url)
      case "SurveyPage" => AuthWizardPage.enterRedirectUrl(SurveyPage.urlRedirect)
      case _ => AuthWizardPage.clickSubmit()
    }
    AuthWizardPage.enterValidNino()
    AuthWizardPage.clickSubmit()
  }

}
