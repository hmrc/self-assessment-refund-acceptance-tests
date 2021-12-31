package uk.gov.hmrc.test.ui.pages.testonly

import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig


object ReturnUrlPage extends BasePage {

  val url = s"${testConfig.selfAssessmentRefundFrontendUrl}/change-bank-account/test-only/show-return-url"
  def expectedPageTitle = "Return url"
  def expectedPageHeader = "Return Url page"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle
}
