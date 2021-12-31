package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.stepdefs.other.ScenarioVariables
import uk.gov.hmrc.test.ui.testdata.BankDetails
import uk.gov.hmrc.test.ui.testdata.BankDetails._
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object EnterBankDetailsPage extends BasePage {

  val url: String = s"${testConfig.bankAccountVerificationUrl}/verify"
  def expectedPageTitle = "Bank or building society account details - Request a Self Assessment Refund - GOV.UK"
  def expectedPageHeader = "Bank or building society account details"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle
  def accType: String = ScenarioVariables.personalOrBusiness

  def personalAccountName: WebElement = id("accountName").webElement
  def businessAccountName: WebElement = id("companyName").webElement
  def sortCode: WebElement = id("sortCode").webElement
  def accountNumber: WebElement = id("accountNumber").webElement
  def buildingRollNumber: WebElement = id("rollNumber").webElement
  def pageContent: String = id("main-content").webElement.getText

  override def assertCurrentUrl(): Assertion = {
    currentUrl should fullyMatch regex s"""$url/$accType/[a-z0-9]{24}""".r
  }

  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.enterBankDetailsPageText())
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

  def enterBusinessBankDetailsWithRoll () {
    enterBusinessBankDetails()
    enterRollNumber()
  }


}
