package uk.gov.hmrc.test.ui.stepdefs.other

import uk.gov.hmrc.test.ui.pages.AuthWizardPage
import uk.gov.hmrc.test.ui.pages.testonly.TestOnlyStartPage
import uk.gov.hmrc.test.ui.testdata.TestData

class TestOnlyStartStepDef extends Steps with DriverActions {

  And("""^The user starts a (.*) journey with Nino (.*)$""") { (accType: String, nino: String) =>
    // Have to go through this twice as the first time takes you to Auth Login
    ScenarioVariables.personalOrBusiness = accType
    go to TestOnlyStartPage.url
    nino match {
        //TODO When various users set up, set up Nino links etc.
      case "AA111111A" => TestOnlyStartPage.clickRadio(TestData.nino)
      case "AC111111A" => TestOnlyStartPage.clickRadio(TestData.nino2)
      case _ => TestOnlyStartPage.clickRadio(TestData.nino)
    }
    AuthWizardPage.clickSubmit()
    nino match {
      //TODO When various users set up, set up Nino links etc.
      case "AA111111A" => TestOnlyStartPage.clickRadio(TestData.nino)
      case "AC111111A" => TestOnlyStartPage.clickRadio(TestData.nino2)
      case _ => TestOnlyStartPage.clickRadio(TestData.nino)
    }
  }

}
