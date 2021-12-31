package uk.gov.hmrc.test.ui.stepdefs.pages

import uk.gov.hmrc.test.ui.pages.{AuthWizardPage, TypeOfAccountPage}
import uk.gov.hmrc.test.ui.stepdefs.other.{DriverActions, ScenarioVariables, Steps}

class TypeOfAccountStepDef extends Steps with DriverActions {

  And("""^the user select (business|personal) account$""") { radio: String =>
    TypeOfAccountPage.selectRadio(radio)
  }


}
