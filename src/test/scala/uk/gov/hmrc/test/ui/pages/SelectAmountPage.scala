package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object SelectAmountPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/select-amount"

  def expectedPageTitle = "Your payment details - Request a Self Assessment Refund - GOV.UK"
  def expectedPageHeader = "How much do you want to be repaid?"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText
  def repayFullRadio: WebElement = id("choice-full").webElement
  def repayDiffRadio: WebElement = id("choice-different").webElement
  def enterAmountInput: WebElement = id("different-amount").webElement
  def errorSummaryTitle: WebElement = id("error-summary-title").webElement
  def errorSummaryAmount: WebElement = id("error-amount").webElement
  def errorSummaryChoice: WebElement = id("error-choice").webElement
  def errorMessageChoice: WebElement = id("").webElement
  def errorMessageAmount: WebElement = id("different-amount-error").webElement

  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.selectAmountPageText())
  }

  def selectRadio(radio: String, amount: String) {
    radio match {
      case "full" => click on repayFullRadio
      case "other" => click on repayDiffRadio
                      enterAmount(amount)
    }
  }

  def enterAmount(amount: String) {
    enterAmountInput.sendKeys(amount)
  }

  //TODO error scenarios to be finalised.
  def errorSummaryValidation(error: String) {
    //TODO - Link this to test data values
    val amount: String = TestData.maxRefundAmount
    assertCurrentPageTitleError()
    errorSummaryTitle.getText should be("There is a problem")
    error match {
      case "enter amount" => errorSummaryAmount.getText should be("Enter payment amount")
      case "choice required" => errorSummaryChoice.getText should be("Choice is required")
      case "invalid amount" => errorSummaryAmount.getText should be(s"Payment amount must be between £0.01 and £$amount")
    }
  }

  //TODO error scenarios to be finalised.
  def errorMessageValidation(error: String) {
    //TODO - Link this to test data values
    val amount: String = TestData.maxRefundAmount
    error match {
      case "enter amount" => errorMessageAmount.getText should be("Error:\nEnter payment amount")
//      case "choice required" => errorMessageChoice.getText should be("Error:\nChoice is required")
      case "invalid amount" => errorMessageAmount.getText should be(s"Error:\nPayment amount must be between £0.01 and £$amount")
    }
  }

}

