package uk.gov.hmrc.test.ui.pages

import uk.gov.hmrc.test.ui.utils.Configuration.testConfig

object SurveyPage extends BasePage {

  val urlRedirect: String = s"${testConfig.selfAssessmentRefundFrontendUrl}/user-panel"
  val url: String = s"${testConfig.paymentsSurveyUrl}/survey"

  def expectedPageTitle = "How was our payment service? - Request a Self Assessment refund - GOV.UK"
  def expectedPageHeader = "How was our payment service?"
  def expectedPageTitleError: String = "Error: " + expectedPageTitle


}
