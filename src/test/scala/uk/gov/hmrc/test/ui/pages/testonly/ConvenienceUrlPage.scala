package uk.gov.hmrc.test.ui.pages.testonly

import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.utils.Configuration.testConfig


object ConvenienceUrlPage extends BasePage {

  val url = s"${testConfig.selfAssessmentRefundFrontendUrl}/change-bank-account/test-only/show_convenience_url"
  def expectedPageTitle = "Back Page"
  def expectedPageHeader = "Back url page"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle

}
