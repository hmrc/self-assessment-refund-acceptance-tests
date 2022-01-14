package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object TypeOfAccountPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/your-account-type"

  def expectedPageTitle = "What type of account details are you providing? - Request a Self Assessment Refund - GOV.UK"
  def expectedPageHeader = "What type of account details are you providing?"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def businessAccountRadio: WebElement = id("accountType").webElement
  def personalAccountRadio: WebElement = id("accountType-2").webElement
  def pageContent: String = id("main-content").webElement.getText
  def errorSummaryTitle: WebElement = id("error-summary-title").webElement
  def errorSummary: WebElement = id("TBC").webElement
  def errorMessage: WebElement = id("TBC").webElement

  override def assertCurrentUrl(): Assertion = {
    currentUrl should fullyMatch regex s"""$url/[a-z0-9]{24}""".r
  }

  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.typeOfAccountPageText())
  }

  def selectRadio(radio: String) {
    radio match {
      case "business" => click on businessAccountRadio
      case "personal" => click on personalAccountRadio
      case "none" => continue()
    }
  }

  def assertError(): Assertion =  {
    assertCurrentPageTitleError()
    errorSummaryTitle.getText should be("There is a problem")
    errorSummary.getText should be("Select a type of account")
    errorMessage.getText should be("Select a type of account")

  }


}
