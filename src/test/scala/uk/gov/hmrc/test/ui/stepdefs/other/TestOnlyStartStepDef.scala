/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.stepdefs.other

import uk.gov.hmrc.test.ui.pages.AuthWizardPage
import uk.gov.hmrc.test.ui.pages.testonly.TestOnlyStartPage
import uk.gov.hmrc.test.ui.testdata.{ScenarioContext, TestData}

class TestOnlyStartStepDef extends Steps with DriverActions {

  And("""^The user starts a (.*) journey with Nino (.*)$""") { (accType: String, nino: String) =>
    // Have to go through this twice as the first time takes you to Auth Login
    //    ScenarioVariables.personalOrBusiness = accType
    ScenarioContext.set("personalOrBusiness", accType)
    go to TestOnlyStartPage.url
    nino match {
      case "AA111111A" => TestOnlyStartPage.clickRadio(TestData.nino)
        ScenarioContext.set("nino", TestData.nino)
      case "AC111111A" => TestOnlyStartPage.clickRadio(TestData.nino2)
        ScenarioContext.set("nino", TestData.nino2)
      case _ => TestOnlyStartPage.clickRadio(TestData.nino)
    }
    AuthWizardPage.enterValidNino()
    AuthWizardPage.setConfidenceLevel("250")
    AuthWizardPage.clickSubmit()
    nino match {
      case "AA111111A" => TestOnlyStartPage.clickRadio(TestData.nino)
      case "AC111111A" => TestOnlyStartPage.clickRadio(TestData.nino2)
      case _ => TestOnlyStartPage.clickRadio(TestData.nino)
    }
  }

  And("""^The user starts a (.*) journey with confidence level < 250$""") { (accType: String, nino: String) =>
    // Have to go through this twice as the first time takes you to Auth Login
    //    ScenarioVariables.personalOrBusiness = accType
    ScenarioContext.set("personalOrBusiness", accType)
    go to TestOnlyStartPage.url
    nino match {
      case "AA111111A" => TestOnlyStartPage.clickRadio(TestData.nino)
        ScenarioContext.set("nino", TestData.nino)
      case "AC111111A" => TestOnlyStartPage.clickRadio(TestData.nino2)
        ScenarioContext.set("nino", TestData.nino2)
      case _ => TestOnlyStartPage.clickRadio(TestData.nino)
    }
    AuthWizardPage.enterValidNino()
    AuthWizardPage.setConfidenceLevel("200")
    AuthWizardPage.clickSubmit()
    nino match {
      case "AA111111A" => TestOnlyStartPage.clickRadio(TestData.nino)
      case "AC111111A" => TestOnlyStartPage.clickRadio(TestData.nino2)
      case _ => TestOnlyStartPage.clickRadio(TestData.nino)
    }
  }

  And("""^The user starts a history journey""") { () =>
    // Have to go through this twice as the first time takes you to Auth Login
    //    ScenarioVariables.personalOrBusiness = accType
    go to TestOnlyStartPage.url
    TestOnlyStartPage.clickRadio("history")
    AuthWizardPage.enterValidNino()
    AuthWizardPage.setConfidenceLevel("250")
    AuthWizardPage.clickSubmit()
    TestOnlyStartPage.clickRadio("history")
  }


}
