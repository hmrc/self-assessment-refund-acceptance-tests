package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.StatusCompletedPage.{completedAmount1, langToggle}
import uk.gov.hmrc.test.ui.pages.StatusPendingPage.{be, langToggle, pageContent}
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.{Language, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object StatusRejectedPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-status/4"
  val rejectedAmount1: String = TestData.rejectedAmount1

  def expectedPageTitle =  {
    if (langToggle == Language.welsh) s"Mae’ch ad-daliad o £$rejectedAmount1 wedi’i wrthod - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else s"Your refund of £$rejectedAmount1 has been rejected - Request a Self Assessment refund - GOV.UK"
  }
  def expectedPageHeader = {
    if (langToggle == Language.welsh) s"Mae’ch ad-daliad o £$rejectedAmount1 wedi’i wrthod"
    else s"Your refund of £$rejectedAmount1 has been rejected"
  }

  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText


  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.statusRejectedPageText())
    else pageContent should be(EnglishContent.statusRejectedPageText())
  }
}
