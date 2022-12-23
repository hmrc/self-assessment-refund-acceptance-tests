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
import uk.gov.hmrc.test.ui.testdata.{BankDetails, Language, ScenarioContext}
import uk.gov.hmrc.test.ui.testdata.BankDetails._
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object EnterBankDetailsPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/enter-bank-details"

  def expectedPageTitle = {
    if (langToggle == Language.welsh) "Nodwch fanylion y cyfrif banc neu'r cyfrif cymdeithas adeiladu - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Enter the bank or building society account details - Request a Self Assessment refund - GOV.UK"
  }

  def expectedPageHeader = {
    if (langToggle == Language.welsh) "Nodwch fanylion y cyfrif banc neu'r cyfrif cymdeithas adeiladu"
    else "Enter the bank or building society account details"
  }

  def expectedPageTitleError = if (langToggle == Language.welsh) "Gwall: " + expectedPageTitle else "Error: " + expectedPageTitle

  def accType: String = ScenarioContext.get("personalOrBusiness")

  def personalAccountName: WebElement = id("accountName").webElement

  def businessAccountName: WebElement = id("accountName").webElement

  def sortCode: WebElement = id("sortCode").webElement

  def accountNumber: WebElement = id("accountNumber").webElement

  def buildingRollNumber: WebElement = id("rollNumber").webElement

  def pageContent: String = id("main-content").webElement.getText

  def sortCodeHint: WebElement = id("sortCode-hint").webElement

  def accountNumberHint: WebElement = id("accountNumber-hint").webElement

  def rollNumberHint: WebElement = id("rollNumber-hint").webElement

  def errorSummaryTitle: WebElement = id("error-summary-title").webElement

  def errorSummary(number: String): WebElement = cssSelector("div > ul > li:nth-child("+number+") > a").webElement

  def errorMessageAccountName: WebElement = id("accountName-error").webElement
  def errorMessageSortCode: WebElement = id("sortCode-error").webElement
  def errorMessageAccountNumber: WebElement = id("accountNumber-error").webElement
  def errorMessageRollNumber: WebElement = id("rollNumber-error").webElement

//  override def assertCurrentUrl(): Assertion = {
//    currentUrl should fullyMatch regex s"""$url/$accType/[a-z0-9]{24}""".r
//  }

  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.enterBankDetailsPageText())
    else pageContent should be(EnglishContent.enterBankDetailsPageText())
  }

  def clearFields() {
    accType match {
      case "personal" => personalAccountName.clear()
      case "business" => businessAccountName.clear()
    }
    sortCode.clear()
    accountNumber.clear()
    buildingRollNumber.clear()
  }

  def enterPersonalBankDetails(validAccount: BankDetails = validAccount) {
    personalAccountName.sendKeys(validAccount.accName)
    sortCode.sendKeys(validAccount.sortcode)
    accountNumber.sendKeys(validAccount.accNumber)
  }

  //TODO get bank details that are suitable when all the BARS stuff is sorted.
  def enterInvalidBankDetails(invalidAccount: BankDetails = invalidAccount) {
    personalAccountName.sendKeys(invalidAccount.accName)
    sortCode.sendKeys(invalidAccount.sortcode)
    accountNumber.sendKeys(invalidAccount.accNumber)
  }

  def enterBusinessBankDetails(validAccount: BankDetails = businessAccount) {
    businessAccountName.sendKeys(validAccount.accName)
    sortCode.sendKeys(validAccount.sortcode)
    accountNumber.sendKeys(validAccount.accNumber)
  }

  def enterRollNumber(rollNumber1: BankDetails = validAccount) {
    buildingRollNumber.sendKeys(rollNumber1.roll)
  }

  def enterPersonalBankDetailsWithRoll() {
    enterPersonalBankDetails()
    enterRollNumber()
  }

  def enterBusinessBankDetailsWithRoll() {
    enterBusinessBankDetails()
    enterRollNumber()
  }

  def assertNoDetailsError(): Unit = {
    clearFields()
    continue()
    assertCurrentPageTitleError()
    if (langToggle == Language.welsh) {
      errorSummaryTitle.getText should be("Mae problem wedi codi")
      errorSummary("1").getText should be("Nodwch yr enw sydd ar y cyfrif")
      errorSummary("2").getText should be("Nodwch god didoli")
      errorSummary("3").getText should be("Nodwch rif cyfrif")
      errorMessageAccountName.getText should be("Gwall:\nNodwch yr enw sydd ar y cyfrif")
      errorMessageSortCode.getText should be("Gwall:\nNodwch god didoli")
      errorMessageAccountNumber.getText should be("Gwall:\nNodwch rif cyfrif")

    }
    else {
      errorSummaryTitle.getText should be("There is a problem")
      errorSummary("1").getText should be("Enter the name on the account")
      errorSummary("2").getText should be("Enter a sort code")
      errorSummary("3").getText should be("Enter an account number")
      errorMessageAccountName.getText should be("Error:\nEnter the name on the account")
      errorMessageSortCode.getText should be("Error:\nEnter a sort code")
      errorMessageAccountNumber.getText should be("Error:\nEnter an account number")

    }
  }

  def assertSortCodeCorrectFormatError(sortCodeValue: String, validAccount: BankDetails = validAccount): Unit = {
    clearFields()
    accType match {
      case "personal" => personalAccountName.sendKeys(validAccount.accName)
      case "business" => businessAccountName.sendKeys(validAccount.accName)
    }
    sortCode.sendKeys(sortCodeValue)
    accountNumber.sendKeys(validAccount.accNumber)
    continue()
    assertCurrentPageTitleError()
    if (langToggle == Language.welsh) {
      errorSummaryTitle.getText should be("Mae problem wedi codi")
      errorSummary("1").getText should be("Nodwch god didoli dilys, megis 309430")
      errorMessageSortCode.getText should be("Gwall:\nNodwch god didoli dilys, megis 309430")
    }
    else {
      errorSummaryTitle.getText should be("There is a problem")
      errorSummary("1").getText should be("Sort code must be 6 digits")
      errorMessageSortCode.getText should be("Error:\nSort code must be 6 digits")
    }
  }

  def assertAccountNumberCorrectFormatError(accountNumberValue: String, validAccount: BankDetails = validAccount): Unit = {
    clearFields()
    accType match {
      case "personal" => personalAccountName.sendKeys(validAccount.accName)
      case "business" => businessAccountName.sendKeys(validAccount.accName)
    }
    sortCode.sendKeys(validAccount.sortcode)
    accountNumber.sendKeys(accountNumberValue)
    continue()
    assertCurrentPageTitleError()
    if (langToggle == Language.welsh) {
      errorSummaryTitle.getText should be("Mae problem wedi codi")
      errorSummary("1").getText should be("Nodwch rif cyfrif dilys, megis 00733445")
      errorMessageAccountNumber.getText should be("Gwall:\nNodwch rif cyfrif dilys, megis 00733445")
    }
    else {
      errorSummaryTitle.getText should be("There is a problem")
      errorSummary("1").getText should be("Account number must be between 6 and 8 digits")
      errorMessageAccountNumber.getText should be("Error:\nAccount number must be between 6 and 8 digits")

    }
  }

    def assertAccountNumberCorrectLengthError(accountNumberValue: String, validAccount: BankDetails = validAccount): Unit = {
      clearFields()
      accType match {
        case "personal" => personalAccountName.sendKeys(validAccount.accName)
        case "business" => businessAccountName.sendKeys(validAccount.accName)
      }
      sortCode.sendKeys(validAccount.sortcode)
      accountNumber.sendKeys(accountNumberValue)
      continue()
      assertCurrentPageTitleError()
      if (langToggle == Language.welsh) {
        errorSummaryTitle.getText should be("Mae problem wedi codi")
        errorSummary("1").getText should be("Mae’n rhaid i rif y cyfrif fod rhwng 6 ac 8 digid")
        errorMessageAccountNumber.getText should be("Gwall:\nMae’n rhaid i rif y cyfrif fod rhwng 6 ac 8 digid")
      }
      else {
        errorSummaryTitle.getText should be("There is a problem")
        errorSummary("1").getText should be("Account number must be between 6 and 8 digits")
        errorMessageAccountNumber.getText should be("Error:\nAccount number must be between 6 and 8 digits")
      }
    }

    def assertHintText(): Unit = {
      if (langToggle == Language.welsh) {
        sortCodeHint.getText should be("Mae’n rhaid iddo fod yn 6 digid o hyd")
        accountNumberHint.getText should be("Mae’n rhaid iddo fod rhwng 6 ac 8 digid o hyd")
        rollNumberHint.getText should be("Gallwch ddod o hyd iddo ar eich cerdyn, cyfriflen neu baslyfr")
      }
      else {
        sortCodeHint.getText should be("Must be 6 digits long")
        accountNumberHint.getText should be("Must be between 6 and 8 digits long")
        rollNumberHint.getText should be("You can find it on your card, statement or passbook")
      }
    }

  def enterBankDetails(bankDetails: BankDetails): Unit = {
    personalAccountName.sendKeys(bankDetails.accName)
    sortCode.sendKeys(bankDetails.sortcode)
    accountNumber.sendKeys(bankDetails.accNumber)
  }

  def enterBankDetailsWithRoll(bankDetails: BankDetails): Unit = {
    personalAccountName.sendKeys(bankDetails.accName)
    sortCode.sendKeys(bankDetails.sortcode)
    accountNumber.sendKeys(bankDetails.accNumber)
    buildingRollNumber.sendKeys(bankDetails.roll)
  }

  def clearBankDetails(): Unit = {
    personalAccountName.clear()
    sortCode.clear()
    accountNumber.clear()
  }
}
