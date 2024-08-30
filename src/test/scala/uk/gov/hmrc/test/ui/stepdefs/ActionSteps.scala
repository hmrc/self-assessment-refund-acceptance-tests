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

  Given("""^The user starts a (.*) journey with Nino (.*), confidence (.*), and urls (.*)$""") { (journey: String, nino: String, confidence: String, urls: String) =>
    MongoDriver.dropDatabases()
    driver.navigate().to(AuthWizardPage.url)
    enterTextById("nino", nino)
    singleSel(name("confidenceLevel")).value = confidence
//    AuthWizardPage.setConfidenceLevel("250")
    enterTextById("redirectionUrl", TestOnlyStartPage.url)
//    AuthWizardPage.enterRedirectUrl(TestOnlyStartPage.url)
    click on id("submit-top")
    if (isPresent("Gwneud cais am ad-daliad Hunanasesiad")) {clickByCssSelector("nav > ul > li:nth-child(1) > a")}
//    AuthWizardPage.clickSubmit()
    journey match {
      case "refund" =>
    nino match {
    case "AB111111D" => click on id ("1")
    case "AB111111C" | "AB111111B" => click on id ("0")
    case _ => click on id ("0") // to populate the rest of fields, nino will be changed in next step
    }
      case "history" => nino match {
        case "AB111111C" => click on id ("2")
      }
    }
//    if (nino == "AB111111C" || nino == "AB111111D") {
//      TestOnlyStartPage.clickRadio(nino)
//    }
//    else {
//      TestOnlyStartPage.clickRadio(nino)
//      TestOnlyStartPage.overwriteNino(nino)
//    }
    click on cssSelector("#main-content > form:nth-child(5) > button")
    nino match {
      case "AB111111B" =>
      id("nino").webElement.clear()
      id("nino").webElement.sendKeys(nino)
      case _ => ()
    }
    urls match {
      case "not provided" =>
        id("backUrl").webElement.clear()
        id("returnUrl").webElement.clear()
      case "provided" =>
    }
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
    case "back" => clickByCssSelector("a.govuk-back-link")
    case "back to tax account" => clickByCssSelector("a.govuk-button")
    case "contact HMRC" => clickByCssSelector("p:nth-child(4) > a")
    case "continue" => continue()
    case "Cymraeg"                                          => clickByCssSelector("nav > ul > li:nth-child(2) > a")
    case "English"                                          => clickByCssSelector("nav > ul > li:nth-child(1) > a")
    case "the feedback link" => clickById("help-us-improve-our-services-link")
    case "the history tab" => clickById("tab_history")
    case "HMRC online account" => clickByCssSelector("p:nth-child(6) > a")
    case "lockout return button" => clickById("return-to")
    case "sign out" => clickByCssSelector("a.govuk-link.hmrc-sign-out-nav__link")
    case "view approved" => clickByCssSelector("tr:nth-child(2) > td:nth-child(4) > a")
    case "view paid" => clickByCssSelector("tr:nth-child(1) > td:nth-child(5) > a")
    case "view processing" => clickByCssSelector("tr:nth-child(1) > td:nth-child(4) > a")
    case "view rejected" => clickByCssSelector("tr:nth-child(2) > td:nth-child(5) > a")
    }
  }

  When("""^the user enters (.*) bank details (.*) roll number and clicks continue$""") { (accountType: String, roll: String) =>
   val bankDetails = {
          accountType match {
            case "denyList" => BankDetails.denyListAccount
            case "invalid business" => BankDetails.invalidBusinessAccount
            case "invalid personal" => BankDetails.invalidPersonalAccount
            case "missingRollNumber" => BankDetails.businessRollRequiredAccount
            case "onEISCD=No" => BankDetails.onEISCDNoAccount
            case "supportsDirectCredit=No" => BankDetails.supportsDirectCreditNoAccount
            case "valid business" => roll match {
              case "with" => BankDetails.businessRollRequiredAccount
              case "without" => BankDetails.validBusinessAccount
            }
            case "valid personal" => roll match {
              case "with" => BankDetails.personalRollRequiredAccount
              case "without" => BankDetails.validPersonalAccount
            }
            case "wellFormatted=No" => BankDetails.wellFormattedNoAccount
            case "wrong name business" => BankDetails.invalidNameBusinessAccount
            case "wrong name personal" => BankDetails.invalidNamePersonalAccount
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

  When("""^the IV uplift user selects (.*)$""") { (element: String) =>
    element match {
      case "IV success" => clickById("Success")
      case "IV failure" => clickById("FailedIV")
    }
    clickById("submit-continue")
  }

}
