package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.AccountOnFilePage.{be, langToggle, pageContent}
import uk.gov.hmrc.test.ui.pages.RefundAmountPage.langToggle
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.stepdefs.other.ScenarioVariables
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

  def personalAccountName: WebElement = id("companyName").webElement

  def businessAccountName: WebElement = id("companyName").webElement

  def sortCode: WebElement = id("sortCode").webElement

  def accountNumber: WebElement = id("accountNumber").webElement

  def buildingRollNumber: WebElement = id("rollNumber").webElement

  def pageContent: String = id("main-content").webElement.getText

  def sortCodeHint: WebElement = id("sortCode-hint").webElement

  def accountNumberHint: WebElement = id("accountNumber-hint").webElement

  def rollNumberHint: WebElement = id("rollNumber-hint").webElement

  def errorSummaryTitle: WebElement = id("error-summary-title").webElement

  def errorSummary(number: String): WebElement = id("TBC_" + number).webElement

  def errorMessage(number: String): WebElement = id("TBC_" + number).webElement

  override def assertCurrentUrl(): Assertion = {
    currentUrl should fullyMatch regex s"""$url/$accType/[a-z0-9]{24}""".r
  }

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

  def enterPersonalBankDetails(validAccount: BankDetails = validAccountPersonal) {
    personalAccountName.sendKeys(validAccount.accName)
    sortCode.sendKeys(validAccount.sortcode)
    accountNumber.sendKeys(validAccount.accNumber)
  }

  def enterBusinessBankDetails(validAccount: BankDetails = validAccountBusiness) {
    businessAccountName.sendKeys(validAccount.accName)
    sortCode.sendKeys(validAccount.sortcode)
    accountNumber.sendKeys(validAccount.accNumber)
  }

  def enterRollNumber(rollNumber1: BankDetails = validAccountPersonal) {
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
      errorSummary("2").getText should be("Nodwch rif cyfrif")
      errorSummary("3").getText should be("Nodwch god didoli")
      errorMessage("1").getText should be("Gwall:\nNodwch yr enw sydd ar y cyfrif")
      errorMessage("2").getText should be("Gwall:\nNodwch rif cyfrif")
      errorMessage("3").getText should be("Gwall:\nNodwch god didoli")
    }
    else {
      errorSummaryTitle.getText should be("There is a problem")
      errorSummary("1").getText should be("Enter the name on the account")
      errorSummary("2").getText should be("Enter an account number")
      errorSummary("3").getText should be("Enter a sort code")
      errorMessage("1").getText should be("Error:\nEnter the name on the account")
      errorMessage("2").getText should be("Error:\nEnter an account number")
      errorMessage("3").getText should be("Error:\nEnter a sort code")
    }
  }

  def assertSortCodeCorrectFormatError(sortCodeValue: String, validAccount: BankDetails = validAccountPersonal): Unit = {
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
      errorMessage("1").getText should be("Gwall:\nNodwch god didoli dilys, megis 309430")
    }
    else {
      errorSummaryTitle.getText should be("There is a problem")
      errorSummary("1").getText should be("Enter a valid sort code like 309430")
      errorMessage("1").getText should be("Error:\nEnter a valid sort code like 309430")
    }
  }

  def assertAccountNumberCorrectFormatError(accountNumberValue: String, validAccount: BankDetails = validAccountPersonal): Unit = {
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
      errorMessage("1").getText should be("Gwall:\nNodwch rif cyfrif dilys, megis 00733445")
    }
    else {
      errorSummaryTitle.getText should be("There is a problem")
      errorSummary("1").getText should be("Enter a valid account number like 00733445")
      errorMessage("1").getText should be("Error:\nEnter a valid account number like 00733445")

    }
  }

    def assertAccountNumberCorrectLengthError(accountNumberValue: String, validAccount: BankDetails = validAccountPersonal): Unit = {
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
        errorMessage("1").getText should be("Gwall:\nMae’n rhaid i rif y cyfrif fod rhwng 6 ac 8 digid")
      }
      else {
        errorSummaryTitle.getText should be("There is a problem")
        errorSummary("1").getText should be("Account number must be between 6 and 8 digits")
        errorMessage("1").getText should be("Error:\nAccount number must be between 6 and 8 digits")
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
}
