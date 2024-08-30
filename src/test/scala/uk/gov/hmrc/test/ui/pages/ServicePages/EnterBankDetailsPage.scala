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

package uk.gov.hmrc.test.ui.pages.ServicePages

import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.testdata.{BankDetails, Language, ScenarioContext}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object EnterBankDetailsPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/enter-bank-details"

  def expectedPageTitle =
    if (langToggle == Language.welsh)
      "Nodwch fanylion y cyfrif banc neu’r cyfrif cymdeithas adeiladu - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else "Enter bank or building society account details - Request a Self Assessment refund - GOV.UK"

  def expectedPageHeader =
    if (langToggle == Language.welsh) "Nodwch fanylion y cyfrif banc neu’r cyfrif cymdeithas adeiladu"
    else "Enter bank or building society account details"

  def accType: String = ScenarioContext.get("personalOrBusiness")

  def accountName: WebElement        = id("accountName").webElement(driver)
  def sortCode: WebElement           = id("sortCode").webElement(driver)
  def accountNumber: WebElement      = id("accountNumber").webElement(driver)
  def buildingRollNumber: WebElement = id("rollNumber").webElement(driver)
  def pageContent: String            = id("main-content").webElement(driver).getText
  def sortCodeHint: WebElement       = id("sortCode-hint").webElement(driver)
  def accountNumberHint: WebElement  = id("accountNumber-hint").webElement(driver)
  def rollNumberHint: WebElement     = id("rollNumber-hint").webElement(driver)

  def errorSummaryTitle: WebElement            = id("error-summary-title").webElement(driver)
  def errorSummary(number: String): WebElement =
    cssSelector("div > ul > li:nth-child(" + number + ") > a").webElement(driver)
  def errorSummaryAccountName: WebElement      = id("accountName-error-summary").webElement(driver)
  def errorSummarySortCode: WebElement         = id("sortCode-error-summary").webElement(driver)
  def errorSummaryAccountNumber: WebElement    = id("accountNumber-error-summary").webElement(driver)
  def errorSummaryRollNumber: WebElement       = id("rollNumber-error-summary").webElement(driver)
  def errorMessageAccountName: WebElement      = id("accountName-error").webElement(driver)
  def errorMessageSortCode: WebElement         = id("sortCode-error").webElement(driver)
  def errorMessageAccountNumber: WebElement    = id("accountNumber-error").webElement(driver)
  def errorMessageRollNumber: WebElement       = id("rollNumber-error").webElement(driver)

//  override def assertCurrentUrl(): Assertion = {
//    currentUrl should fullyMatch regex s"""$url/$accType/[a-z0-9]{24}""".r
//  }

  def assertNoDetailsError(): Unit = {
    clearBankDetails()
    continue()
    assertCurrentPageTitleError()
    if (langToggle == Language.welsh) {
      errorSummaryTitle.getText         should be("Mae problem wedi codi")
      errorSummaryAccountName.getText   should be("Nodwch yr enw sydd ar y cyfrif")
      errorSummarySortCode.getText      should be("Nodwch god didoli")
      errorSummaryAccountNumber.getText should be("Nodwch rif cyfrif")
      errorMessageAccountName.getText   should be("Gwall:\nNodwch yr enw sydd ar y cyfrif")
      errorMessageSortCode.getText      should be("Gwall:\nNodwch god didoli")
      errorMessageAccountNumber.getText should be("Gwall:\nNodwch rif cyfrif")

    } else {
      errorSummaryTitle.getText         should be("There is a problem")
      errorSummaryAccountName.getText   should be("Enter the name on the account")
      errorSummarySortCode.getText      should be("Enter sort code")
      errorSummaryAccountNumber.getText should be("Enter account number")
      errorMessageAccountName.getText   should be("Error:\nEnter the name on the account")
      errorMessageSortCode.getText      should be("Error:\nEnter sort code")
      errorMessageAccountNumber.getText should be("Error:\nEnter account number")

    }
  }

  def assertHintText(): Unit =
    if (langToggle == Language.welsh) {
      sortCodeHint.getText      should be("Mae’n rhaid iddo fod yn 6 digid o hyd")
      accountNumberHint.getText should be("Mae’n rhaid iddo fod rhwng 6 ac 8 digid o hyd")
      rollNumberHint.getText    should be("Gallwch ddod o hyd iddo ar eich cerdyn, cyfriflen neu baslyfr")
    } else {
      sortCodeHint.getText      should be("Must be 6 digits long")
      accountNumberHint.getText should be("Must be between 6 and 8 digits long")
      rollNumberHint.getText    should be("You can find it on your card, statement or passbook")
    }

  def enterBankDetails(bankDetails: BankDetails): Unit = {
    accountName.sendKeys(bankDetails.accName)
    sortCode.sendKeys(bankDetails.sortcode)
    accountNumber.sendKeys(bankDetails.accNumber)
  }

  def enterBankDetailsWithRoll(bankDetails: BankDetails): Unit = {
    accountName.sendKeys(bankDetails.accName)
    sortCode.sendKeys(bankDetails.sortcode)
    accountNumber.sendKeys(bankDetails.accNumber)
    buildingRollNumber.sendKeys(bankDetails.roll)
  }

  def enterAccountName(input: String): Unit   = accountName.sendKeys(input)
  def enterSortcode(input: String): Unit      = sortCode.sendKeys(input)
  def enterAccountNumber(input: String): Unit = accountNumber.sendKeys(input)
  def enterRollNumberNew(input: String): Unit = buildingRollNumber.sendKeys(input)

  def clearAccountName(): Unit   = accountName.clear()
  def clearSortcode(): Unit      = sortCode.clear()
  def clearAccountNumber(): Unit = accountNumber.clear()
  def clearRollNumber(): Unit    = buildingRollNumber.clear()

  def clearBankDetails(): Unit = {
    clearAccountName()
    clearSortcode()
    clearAccountNumber()
    clearRollNumber()
  }
}
