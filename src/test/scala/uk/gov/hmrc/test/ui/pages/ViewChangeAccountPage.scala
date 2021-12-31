package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.WebElement
import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.content.EnglishContent
import uk.gov.hmrc.test.ui.testdata.TestData
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object ViewChangeAccountPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/view-change-account"

  def expectedPageTitle = "Your payment details - Request a Self Assessment Refund - GOV.UK"
  def expectedPageHeader = "What you owe"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def claimRefund: WebElement = id("claim-a-refund").webElement
  def totalRefund: WebElement = xpath("//*[@id=\"main-content\"]/div/div/div[1]/div[1]/p[2]").webElement
  def creditAmount: WebElement = xpath("//*[@id=\"main-content\"]/div/div/div[1]/div[2]/p[2]").webElement
  def pageContent: String = id("main-content").webElement.getText

  def assertContent(): Assertion =  {
    pageContent should be(EnglishContent.viewChangeAccountPageText())
  }

  def clickClaimRefund(): Unit = {
    click on claimRefund
  }

  def refundCreditAmount(): Unit = {
    val totalRefunds: String = TestData.totalRefunds
//    val amount: String = TestData.maxRefundAmount
    val amount: String = "545.32"
    totalRefund.getText should be("£" + totalRefunds)
    //TODO should this be in the same element? "Claim a refund"
    creditAmount.getText should be("+£" + amount + "\nClaim a refund")
  }

}

