/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.stepdefs

import uk.gov.hmrc.test.ui.mongo.MongoDriver
import uk.gov.hmrc.test.ui.pages.AuthWizardPage
import uk.gov.hmrc.test.ui.pages.testonly.TestOnlyStartPage
import uk.gov.hmrc.test.ui.testdata.BankDetails

class ActionSteps extends DriverActions {

  Given("""^The user starts a journey with Nino (.*)$""") { (nino: String) =>
    MongoDriver.dropDatabases()
    driver.navigate().to(AuthWizardPage.url)
    enterTextById("nino", nino)
    singleSel(name("confidenceLevel")).value = "250"
//    AuthWizardPage.setConfidenceLevel("250")
    enterTextById("redirectionUrl", TestOnlyStartPage.url)
//    AuthWizardPage.enterRedirectUrl(TestOnlyStartPage.url)
    click on id("submit-top")
//    AuthWizardPage.clickSubmit()
    nino match {
      case "AB111111D" => click on id("1")
      case "AB111111C" => click on id("0")
      case "AB111111C_history" => click on id("2")
      case "AB111111D_history" => click on id("3")
      case _ => click on id("0") // to populate the rest of fields, nino will be changed in next step
    }
//    if (nino == "AB111111C" || nino == "AB111111D") {
//      TestOnlyStartPage.clickRadio(nino)
//    }
//    else {
//      TestOnlyStartPage.clickRadio(nino)
//      TestOnlyStartPage.overwriteNino(nino)
//    }
    click on cssSelector("#main-content > form:nth-child(5) > button")
    continue()
  }

  When("""^the user selects (.*) and clicks continue$""") { (element: String) =>
    element match {
      case "the full amount" => clickById("choice-full")
      case "a different amount" => clickById("choice-different")
        enterTextById("different-amount", "100")
      case "business account" => clickById("accountType")
      case "personal account" => clickById("accountType-2")
    }
    continue()
  }

  When("""^the user clicks (.*)$""") { (element: String) =>
    element match {
    case "continue" => continue()
    case "the feedback link" => clickById("help-us-improve-our-services-link")
    }
  }

  When("""^the user enters valid (.*) bank details (.*) roll number and clicks continue$""") { (accountType: String, roll: String) =>
   val bankDetails = {
          accountType match {
            case "personal" => roll match {
              case "with" => BankDetails.personalRollRequiredAccount
              case "without" => BankDetails.validPersonalAccount
            }
            case "business" => roll match {
              case "with" => BankDetails.businessRollRequiredAccount
              case "without" => BankDetails.validBusinessAccount
            }
          }
   }
   enterTextById("accountName",bankDetails.accName)
    enterTextById("sortCode", bankDetails.sortcode)
    enterTextById("accountNumber", bankDetails.accNumber)
  roll match {
      case "with" => enterTextById("rollNumber", bankDetails.roll)
      case "without" => ()
  }
    continue()
//    case "without" => accType match {
//            case "personal" => BankDetails.validPersonalAccount
//            case "business" => BankDetails.validBusinessAccount
//          }
  }

}
