package uk.gov.hmrc.test.ui.pages

import org.scalatest.Assertion
import uk.gov.hmrc.test.ui.pages.StatusCompletedPage.{be, langToggle, pageContent}
import uk.gov.hmrc.test.ui.pages.content.{EnglishContent, WelshContent}
import uk.gov.hmrc.test.ui.testdata.{Language, TestData}
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object StatusPendingPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/refund-status/0"

  val inProgressAmount1: String = TestData.inProgessAmount1

  def expectedPageTitle = {
    if (langToggle == Language.welsh) s"Mae’ch ad-daliad o £$inProgressAmount1 ar y gweill - Gwneud cais am ad-daliad Hunanasesiad - GOV.UK"
    else s"Your refund of £$inProgressAmount1 is in progress - Request a Self Assessment refund - GOV.UK"
  }

  def expectedPageHeader = {
    if (langToggle == Language.welsh) s"Mae’ch ad-daliad o £$inProgressAmount1 ar y gweill"
    else s"Your refund of £$inProgressAmount1 is in progress"
  }

  def expectedPageTitleError: String = "Error: " + expectedPageTitle

  def pageContent: String = id("main-content").webElement.getText


  def assertContent(): Assertion = {
    if (langToggle == Language.welsh) pageContent should be(WelshContent.statusPendingPageText())
    else pageContent should be(EnglishContent.statusPendingPageText())
  }
}
