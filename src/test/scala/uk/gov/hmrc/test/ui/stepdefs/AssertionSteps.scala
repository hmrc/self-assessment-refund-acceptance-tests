/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.stepdefs

import uk.gov.hmrc.test.ui.pages.ExternalPages._
import uk.gov.hmrc.test.ui.pages.ServicePages._

class AssertionSteps extends BaseSteps {

  Then("""^the user is on the (.*)$""") { page: String =>
    page match {
      case "AccountOnFilePage"         =>
        AccountOnFilePage.shouldBeLoaded()
      case "BackUrlPage"               => BackUrlPage.shouldBeLoaded()
      case "CheckDetailsPage"          =>
        CheckDetailsPage.shouldBeLoaded()
      case "DesErrorPage"              =>
        DesErrorPage.shouldBeLoaded()
      case "DummyReauthenticationPage" =>
        DummyReauthenticationPage.shouldBeLoaded()
      case "EnterBankDetailsPage"      =>
        EnterBankDetailsPage.shouldBeLoaded()
      case "IvKickoutPage"             => IvKickoutPage.shouldBeLoaded()
      case "IvUpliftPage"              => IvUpliftPage.shouldBeLoaded()
      case "LockoutPage"               =>
        LockoutPage.shouldBeLoaded()
      case "LoggedOutPage"             => LoggedOutPage.shouldBeLoaded()
      case "RefundAmountPage"          =>
        RefundAmountPage.shouldBeLoaded()
      case "RefundAmountPage in Welsh" => RefundAmountPageWelsh.shouldBeLoaded()
      case "RefundHistoryPage"         =>
        RefundsHistoryPage.shouldBeLoaded()
      case "RequestReceivedPage"       =>
        RequestReceivedPage.shouldBeLoaded()
        findTextByCssSelector("div.govuk-panel.govuk-panel--confirmation > div") should include regex """Your refund reference is
            |[a-z0-9]{12}""".stripMargin.r
      case "ReturnUrlPage"             => ReturnUrlPage.shouldBeLoaded()
      case "SaEnquiresPage"            => SaEnquiresPage.shouldBeLoaded()
      case "StatusApprovedPage"        =>
        StatusApprovedPage.shouldBeLoaded()
      case "StatusPaidPage"            =>
        StatusPaidPage.shouldBeLoaded()
      case "StatusProcessingPage"      =>
        StatusProcessingPage.shouldBeLoaded()
      case "StatusRejectedPage"        =>
        StatusRejectedPage.shouldBeLoaded()
      case "SurveyPage"                =>
        SurveyPage.shouldBeLoaded()
      case "TypeOfAccountPage"         =>
        TypeOfAccountPage.shouldBeLoaded()
      case "V&CPage"                   => VandCPage.shouldBeLoaded()
      case "WelshEnquiresPage"         => WelshEnquiresPage.shouldBeLoaded()
      case _                           => throw new Exception(page + " not found")
    }
  }

  Then("""^the page shows (.*) and (.*) the roll number$""") { (amount: String, roll: String) =>
    roll match {
      case "shows"        =>
        isPresent("//*[@id=\"main-content\"]/div/div/dl/div[5]/dt")
        amount match {
          case "the full amount"      =>
            findTextByCssSelector("div:nth-child(6) > dd.govuk-summary-list__value") shouldBe "£987.65"
          case "the suggested amount" =>
            findTextByCssSelector("div:nth-child(6) > dd.govuk-summary-list__value") shouldBe "£641.98"
          case "the amount typed"     =>
            findTextByCssSelector("div:nth-child(6) > dd.govuk-summary-list__value") shouldBe "£100.00"
          case _                      => throw new Exception(amount + " not found")
        }
      case "doesn't show" =>
        !isPresent("//*[@id=\"main-content\"]/div/div/dl/div[5]/dt")
        amount match {
          case "the full amount"      =>
            findTextByCssSelector("div:nth-child(5) > dd.govuk-summary-list__value") shouldBe "£987.65"
          case "the suggested amount" =>
            findTextByCssSelector("div:nth-child(5) > dd.govuk-summary-list__value") shouldBe "£641.98"
          case "the amount typed"     =>
            findTextByCssSelector("div:nth-child(5) > dd.govuk-summary-list__value") shouldBe "£100.00"
          case _                      => throw new Exception(amount + " not found")
        }
      case _              => throw new Exception(roll + " not found")
    }
  }

  Then("""^the Start Again link is correct$""") { () =>
    cssSelector("#main-content > div > div > a").webElement(driver).getAttribute("href") should be(
      "https://www.tax.service.gov.uk/report-quarterly/income-and-expenses/view/claim-refund"
    )
  }

  Then("""^the user sees the BARS error for (.*)$""") { (error: String) =>
    error match {
      case "an unsupported account"  =>
        findTextById("sortCode-error-summary") should be(
          "You have entered a sort code which does not accept this type of payment. Check you have entered a valid sort code or enter details for a different account"
        )
      case "failing validate checks" =>
        findTextById("sortCode-error-summary") should be(
          "Enter a valid combination of bank account number and sort code"
        )
      case "failing verify checks"   =>
        findTextById("accountName-error-summary") should be(
          "Enter the name on the account as it appears on bank statements. Do not copy and paste it"
        )
      case "missing roll number"     =>
        findTextById("rollNumber-error-summary") should be(
          "Building society roll number must be entered if you have one. It may also be called a reference code"
        )
      case _                         => throw new Exception(error + " not found")
    }
  }

}
