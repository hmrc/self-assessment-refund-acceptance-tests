package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object SelectAmountPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-amount"

  def expectedPageTitle = "How much do you want to be refunded? - Request a Self Assessment refund - GOV.UK"
  def expectedPageHeader = "How much do you want to be refunded?"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText
  def refundFullRadio: WebElement = id("choice-full").webElement
  def refundDiffRadio: WebElement = id("choice-different").webElement
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
      case "full" => click on refundFullRadio
      case "other" => click on refundDiffRadio
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
      case "enter amount" => errorSummaryAmount.getText should be("Enter an amount to be refunded")
      case "choice required" => errorSummaryChoice.getText should be("Select how much you want to be refunded")
      case "invalid amount" => errorSummaryAmount.getText should be(s"Amount to be refunded must be an amount of money, like 11.50 or 12")
      case "amount of 0" => errorSummaryAmount.getText should be(s"Amount must be one pence or more")
      case "exceeded maximum amount" => errorSummaryAmount.getText should be(s"Amount to be refunded must be £$amount or less")
    }
  }

  //TODO error scenarios to be finalised.
  def errorMessageValidation(error: String) {
    //TODO - Link this to test data values
    val amount: String = TestData.maxRefundAmount
    error match {
      case "enter amount" => errorMessageAmount.getText should be("Error:\nEnter an amount to be refunded")
      case "choice required" => errorMessageChoice.getText should be("Error:\nSelect how much you want to be refunded")
      case "invalid amount" => errorMessageAmount.getText should be(s"Error:\nAmount to be refunded must be an amount of money, like 11.50 or 12")
      case "amount of 0" => errorMessageAmount.getText should be(s"Error:\nAmount must be one pence or more")
      case "exceeded maximum amount" => errorMessageAmount.getText should be(s"Error:\nAmount to be refunded must be £$amount or less")
    }
  }

}

