package uk.gov.hmrc.test.ui.stepdefs.other

object ScenarioVariables {

  var personalOrBusiness: String = ""
  var refundAmountRequested: String = ""

  def resetScenarioVariables(): Unit = {
    personalOrBusiness = ""
    refundAmountRequested = ""
  }

}
