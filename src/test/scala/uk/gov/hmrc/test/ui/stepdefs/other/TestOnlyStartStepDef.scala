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
import uk.gov.hmrc.test.ui.testdata.ScenarioContext

import java.lang.Thread.sleep

class TestOnlyStartStepDef extends DriverActions {

  And("""^The user starts a (.*) journey with Nino (.*)$""") { (accType: String, nino: String) =>
    //    ScenarioVariables.personalOrBusiness = accType
    ScenarioContext.set("personalOrBusiness", accType)
    ScenarioContext.set("nino", nino)
    driver.navigate().to(TestOnlyStartPage.url)
    ScenarioContext.set("nino", nino)
    if (nino == "AB111111C" || nino == "AB111111D") {
      TestOnlyStartPage.clickRadio(nino)
    }
    else {
      TestOnlyStartPage.clickRadio(nino)
      TestOnlyStartPage.overwriteNino(nino)
    }
    continue()
    AuthWizardPage.enterValidNino()
    AuthWizardPage.setConfidenceLevel("250")
    AuthWizardPage.clickSubmit()
    sleep(500)
    continue()
  }

  And("""^The user starts a (.*) journey for (.*) with confidence level < 250$""") { (accType: String, nino: String) =>
    ScenarioContext.set("personalOrBusiness", accType)
    driver.navigate().to(TestOnlyStartPage.url)
    TestOnlyStartPage.clickRadio(nino)
    continue()
    AuthWizardPage.enterValidNino()
    AuthWizardPage.setConfidenceLevel("200")
    AuthWizardPage.clickSubmit()
    sleep(500)
    continue()
  }

  And("""^The user starts a history journey for (.*)""") { (nino: String) =>
    driver.navigate().to(TestOnlyStartPage.url)
    ScenarioContext.set("nino", nino)
    nino match {
      case "AB111111C" => TestOnlyStartPage.clickRadio("AB111111C_history")
      case "AB111111D" => TestOnlyStartPage.clickRadio("AB111111D_history")
    }
    continue()
    AuthWizardPage.enterValidNino()
    AuthWizardPage.setConfidenceLevel("250")
    AuthWizardPage.clickSubmit()
    sleep(500)
    continue()
  }


}
