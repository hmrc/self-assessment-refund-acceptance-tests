package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.stepdefs.other.ScenarioVariables
import uk.gov.hmrc.test.ui.testdata.BankDetails
import uk.gov.hmrc.test.ui.testdata.BankDetails._
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object EnterBankDetailsPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/enter-bank-details"
  def expectedPageTitle = "Enter the bank or building society account details - Request a Self Assessment refund - GOV.UK"
  def expectedPageHeader = "Enter the bank or building society account details"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle
  def accType: String = ScenarioVariables.personalOrBusiness

  def personalAccountName: WebElement = id("accountName").webElement
  def businessAccountName: WebElement = id("companyName").webElement
  def sortCode: WebElement = id("sortCode").webElement
  def accountNumber: WebElement = id("accountNumber").webElement
  def buildingRollNumber: WebElement = id("rollNumber").webElement
  def pageContent: String = id("main-content").webElement.getText
  def sortCodeHint: WebElement = id("TBC").webElement
  def accountNumberHint: WebElement = id("TBC").webElement
  def errorSummaryTitle: WebElement = id("error-summary-title").webElement
  def errorSummary(number: String): WebElement = id("TBC_"+ number).webElement
  def errorMessage(number: String): WebElement = id("TBC_"+ number).webElement

  override def assertCurrentUrl(): Assertion = {
    currentUrl should fullyMatch regex s"""$url/$accType/[a-z0-9]{24}""".r
  }

  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.enterBankDetailsPageText())
  }

  def assertNoDetailsError(): Unit = {
    clearFields()
    continue()
    assertCurrentPageTitleError()
    errorSummaryTitle.getText should be("There is a problem")
    errorSummary("1").getText should be("Enter the name on the account")
    errorSummary("2").getText should be("Enter an account number")
    errorSummary("3").getText should be("Enter a sort code")
    errorMessage("1").getText should be("Enter the name on the account")
    errorMessage("2").getText should be("Enter an account number")
    errorMessage("3").getText should be("Enter a sort code")
  }

  def assertSortCodeCorrectFormatError(validAccount: BankDetails = validAccountPersonal): Unit = {
    clearFields()
    accType match {
      case "personal" => personalAccountName.sendKeys(validAccount.accName)
      case "business" => businessAccountName.sendKeys(validAccount.accName)
    }
    sortCode.sendKeys("!12312")
    accountNumber.sendKeys(validAccount.accNumber)
    continue()
    assertCurrentPageTitleError()
    errorSummaryTitle.getText should be("There is a problem")
    errorSummary("1").getText should be("Enter a valid sort code like 309430")
    errorMessage("1").getText should be("Enter a valid sort code like 309430")
  }

  def assertAccountNumberCorrectFormatError(validAccount: BankDetails = validAccountPersonal): Unit = {
    clearFields()
    accType match {
      case "personal" => personalAccountName.sendKeys(validAccount.accName)
      case "business" => businessAccountName.sendKeys(validAccount.accName)
    }
    sortCode.sendKeys(validAccount.sortcode)
    accountNumber.sendKeys("!1234567")
    continue()
    assertCurrentPageTitleError()
    errorSummaryTitle.getText should be("There is a problem")
    errorSummary("1").getText should be("Enter a valid account number like 00733445")
    errorMessage("1").getText should be("Enter a valid account number like 00733445")
  }

  def assertAccountNumberCorrectLengthError(validAccount: BankDetails = validAccountPersonal): Unit = {
    clearFields()
    accType match {
      case "personal" => personalAccountName.sendKeys(validAccount.accName)
      case "business" => businessAccountName.sendKeys(validAccount.accName)
    }
    sortCode.sendKeys(validAccount.sortcode)
    accountNumber.sendKeys("12345")
    continue()
    assertCurrentPageTitleError()
    errorSummaryTitle.getText should be("There is a problem")
    errorSummary("1").getText should be("Account number must be between 6 and 8 digits")
    errorMessage("1").getText should be("Account number must be between 6 and 8 digits")
    accountNumber.clear()
    accountNumber.sendKeys("123456789")
    continue()
    assertCurrentPageTitleError()
    errorSummaryTitle.getText should be("There is a problem")
    errorSummary("1").getText should be("Account number must be between 6 and 8 digits")
    errorMessage("1").getText should be("Account number must be between 6 and 8 digits")
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

  def enterPersonalBankDetailsWithRoll () {
    enterPersonalBankDetails()
    enterRollNumber()
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

  def enterBusinessBankDetailsWithRoll () {
    enterBusinessBankDetails()
    enterRollNumber()
  }


}
