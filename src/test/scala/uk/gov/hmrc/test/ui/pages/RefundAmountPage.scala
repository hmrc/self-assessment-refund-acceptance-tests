package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.{Language, TestData}
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

  def expectedPageTitleError: String = if (langToggle == Language.welsh) "Gwall: " + expectedPageTitle else "Error: " + expectedPageTitle

    def pageContent: String = id("main-content").webElement.getText

    def refundFullRadio: WebElement = id("choice-full").webElement

    def refundDiffRadio: WebElement = id("choice-different").webElement

    def enterAmountInput: WebElement = id("different-amount").webElement

    def errorSummaryTitle: WebElement = id("error-summary-title").webElement

    def errorSummaryAmount: WebElement = id("error-amount").webElement

    def errorSummaryChoice: WebElement = id("error-choice").webElement

    def errorMessageChoice: WebElement = id("").webElement

    def errorMessageAmount: WebElement = id("different-amount-error").webElement

    def assertContent(): Assertion = {
      if (langToggle == Language.welsh) pageContent should be(WelshContent.refundAmountPageText())
      else pageContent should be(EnglishContent.refundAmountPageText())
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
          case "exceeded maximum amount" => errorSummaryAmount.getText should be(s"Amount to be refunded must be £$amount or less")
        }
      }
    }

    def errorMessageValidation(error: String) {
      val amount: String = TestData.maxRefundAmount

      if (langToggle == Language.welsh) {
        error match {
          case "enter amount" => errorSummaryAmount.getText should be("Gwall:\nNodwch y swm i’w ad-dalu")
          case "choice required" => errorSummaryChoice.getText should be("Gwall:\nDewiswch faint o ad-daliad yr hoffech ei gael")
          case "invalid amount" => errorSummaryAmount.getText should be(s"Gwall:\nMae’n rhaid i’r swm sydd i’w ad-dalu fod yn swm o arian, megis 22.50 neu 23")
          case "amount of 0" => errorSummaryAmount.getText should be(s"Gwall:\nRhaid i’r swm fod yn un geiniog neu’n fwy")
          case "exceeded maximum amount" => errorSummaryAmount.getText should be(s"Gwall:\nMae’n rhaid i’r swm sydd i’w ad-dalu fod yn £$amount neu lai")
        }
      }
      else {
        error match {
          case "enter amount" => errorMessageAmount.getText should be("Error:\nEnter an amount to be refunded")
          case "choice required" => errorMessageChoice.getText should be("Error:\nSelect how much you want to be refunded")
          case "invalid amount" => errorMessageAmount.getText should be(s"Error:\nAmount to be refunded must be an amount of money, like 11.50 or 12")
          case "amount of 0" => errorMessageAmount.getText should be(s"Error:\nAmount must be one pence or more")
          case "exceeded maximum amount" => errorMessageAmount.getText should be(s"Error:\nAmount to be refunded must be £$amount or less")
        }
      }
    }
  }

