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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.{Language, ScenarioContext, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object RefundAmountPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-amount"

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Faint o ad-daliad yr hoffech ei gael? - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "How much do you want to be refunded? - Request a Self Assessment refund - GOV.UK"
  }

  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Faint o ad-daliad yr hoffech ei gael?"
    else "How much do you want to be refunded?"
  }

  def expectedPageTitleError = if (langToggle == Language.welsh) "Gwall: " + expectedPageTitle else "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText

  def refundFullRadio: WebElement = id("choice-full").webElement

  def refundDiffRadio: WebElement = id("choice-different").webElement

  def enterAmountInput: WebElement = id("different-amount").webElement

  def errorSummaryTitle: WebElement = id("error-summary-title").webElement

  def errorSummaryAmount: WebElement = id("error-amount").webElement

  def errorSummaryChoice: WebElement = id("error-choice").webElement

  def errorMessageChoice: WebElement = id("choice-error").webElement

  def errorMessageAmount: WebElement = id("different-amount-error").webElement

  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.refundAmountPageText())
    else pageContent should be(EnglishContent.refundAmountPageText())
  }

  def selectRadio(radio: String, amount: String) {
    radio match {
      case "full" => click on refundFullRadio
        if (ScenarioContext.get[String]("nino") == TestData.nino)
          ScenarioContext.set("amount", TestData.maxRefundAmount)
        else
          ScenarioContext.set("amount", TestData.maxRefundAmount2)
      case "other" => click on refundDiffRadio
        enterAmount(amount)
        ScenarioContext.set("amount", amount)
    }
  }

  def selectOtherAmountRadio() {
    click on refundDiffRadio
  }

  def enterAmount(amount: String) {
    enterAmountInput.sendKeys(amount)
  }

  def errorSummaryValidation(error: String) {
    val amount: String = TestData.maxRefundAmount

    assertCurrentPageTitleError()
    if (langToggle == Language.welsh) {
      errorSummaryTitle.getText should be("Mae problem wedi codi")
      error match {
        case "enter amount" => errorSummaryAmount.getText should be("Nodwch y swm i’w ad-dalu")
        case "choice required" => errorSummaryChoice.getText should be("Dewiswch faint o ad-daliad yr hoffech ei gael")
        case "invalid amount" => errorSummaryAmount.getText should be(s"Mae’n rhaid i’r swm sydd i’w ad-dalu fod yn swm o arian, megis 22.50 neu 23")
        case "amount of 0" => errorSummaryAmount.getText should be(s"Rhaid i’r swm fod yn un geiniog neu’n fwy")
        case "negative number" => errorSummaryAmount.getText should be(s"Rhaid i’r swm fod yn un geiniog neu’n fwy")
        case "exceeded maximum amount" => errorSummaryAmount.getText should be(s"Mae’n rhaid i’r swm sydd i’w ad-dalu fod yn £$amount neu lai")
      }
    }
    else {
      errorSummaryTitle.getText should be("There is a problem")
      error match {
        case "enter amount" => errorSummaryAmount.getText should be("Enter an amount to be refunded")
        case "choice required" => errorSummaryChoice.getText should be("Select how much you want to be refunded")
        case "invalid amount" => errorSummaryAmount.getText should be(s"Amount to be refunded must be an amount of money, like 11.50 or 12")
        case "amount of 0" => errorSummaryAmount.getText should be(s"Amount must be one pence or more")
        case "negative number" => errorSummaryAmount.getText should be(s"Amount must be one pence or more")
        case "exceeded maximum amount" => errorSummaryAmount.getText should be(s"Amount to be refunded must be £$amount or less")
      }
    }
  }

  def errorMessageValidation(error: String) {
    val amount: String = TestData.maxRefundAmount

    if (langToggle == Language.welsh) {
      error match {
        case "enter amount" => errorMessageAmount.getText should be("Gwall:\nNodwch y swm i’w ad-dalu")
        case "choice required" => errorMessageChoice.getText should be("Gwall:\nDewiswch faint o ad-daliad yr hoffech ei gael")
        case "invalid amount" => errorMessageAmount.getText should be(s"Gwall:\nMae’n rhaid i’r swm sydd i’w ad-dalu fod yn swm o arian, megis 22.50 neu 23")
        case "amount of 0" => errorMessageAmount.getText should be(s"Gwall:\nRhaid i’r swm fod yn un geiniog neu’n fwy")
        case "negative number" => errorMessageAmount.getText should be(s"Gwall:\nRhaid i’r swm fod yn un geiniog neu’n fwy")
        case "exceeded maximum amount" => errorMessageAmount.getText should be(s"Gwall:\nMae’n rhaid i’r swm sydd i’w ad-dalu fod yn £$amount neu lai")
      }
    }
    else {
      error match {
        case "enter amount" => errorMessageAmount.getText should be("Error:\nEnter an amount to be refunded")
        case "choice required" => errorMessageChoice.getText should be("Error:\nSelect how much you want to be refunded")
        case "invalid amount" => errorMessageAmount.getText should be(s"Error:\nAmount to be refunded must be an amount of money, like 11.50 or 12")
        case "amount of 0" => errorMessageAmount.getText should be(s"Error:\nAmount must be one pence or more")
        case "negative number" => errorMessageAmount.getText should be(s"Error:\nAmount must be one pence or more")
        case "exceeded maximum amount" => errorMessageAmount.getText should be(s"Error:\nAmount to be refunded must be £$amount or less")
      }
    }
  }
}

