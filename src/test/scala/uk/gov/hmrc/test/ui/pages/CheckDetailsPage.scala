package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object CheckDetailsPage extends BasePage {

  val url: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/check-your-details"

  def expectedPageTitle = "Check your details - Request a Self Assessment Refund - GOV.UK"
  def expectedPageHeader = "Check your details"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle


}
