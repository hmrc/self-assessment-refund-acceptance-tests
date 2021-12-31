package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object AuthenticationPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/TBC"

  def expectedPageTitle = "TBC"
  def expectedPageHeader = "TBC"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle
}
