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
import uk.gov.hmrc.test.ui.pages.ExternalPages.AuthWizardPage
import uk.gov.hmrc.test.ui.pages.ServicePages.TestOnlyStartPage
import uk.gov.hmrc.test.ui.testdata.BankDetails

class ActionSteps extends BaseSteps {

  Given("""^The (.*) user starts a (.*) journey with Nino (.*), confidence (.*), and urls (.*)$""") {
    (userType: String, journey: String, nino: String, confidence: String, urls: String) =>
      MongoDriver.dropDatabases()
      driver.navigate().to(AuthWizardPage.url)

      singleSel(name("confidenceLevel")).value = confidence
      singleSel(name("affinityGroup")).value = userType
      enterTextById("redirectionUrl", TestOnlyStartPage.url)

      userType match {
        case "Individual" | "Organisation" => enterTextById("nino", nino)
        case "Agent"                       =>
          enterTextById("enrolment[0].name", "HMRC-MTD-IT")
          enterTextById("input-0-0-name", "MTDITID")
          enterTextById("input-0-0-value", "123")
          clickById("js-add-delegated-enrolment")
          enterTextById("delegatedEnrolment[0].key", "HMRC-MTD-IT")
          enterTextById("input-delegated-0-0-name", "MTDITID")
          enterTextById("input-delegated-0-0-value", "123")
          enterTextById("delegatedEnrolment[0].delegatedAuthRule", "mtd-it-auth")
        case _                             => throw new Exception(userType + " not found")
      }
      click on id("submit-top")

      if (isPresent("Gwneud cais am ad-daliad Hunanasesiad")) { clickByCssSelector("nav > ul > li:nth-child(1) > a") }
      journey match {
        case "refund"  =>
          nino match {
            case "AB200111D" => click on id("1")
            case "AB200111C" => click on id("0")
            case _           => click on id("0") // to populate the rest of fields, nino will be changed in next step
          }
        case "history" =>
          nino match {
            case "AB111111C" => click on id("2")
            case _           => throw new Exception(nino + " not expected")
          }
        case _         => throw new Exception(journey + " not found")
      }
      click on cssSelector("#main-content > form:nth-child(5) > button")

      nino match {
        case "AB200111C" | "AB200111D" => ()
        case _                         =>
          id("nino").webElement.clear()
          id("nino").webElement.sendKeys(nino)
      }
      urls match {
        case "not provided"              =>
          id("backUrl").webElement.clear()
          id("returnUrl").webElement.clear()
        case "provided"                  => ()
        case "provided but amount wrong" =>
          id("fullAmount").webElement.clear()
          id("fullAmount").webElement.sendKeys("1000")
        case _                           => throw new Exception(urls + " not found")
      }
      continue()
  }

  When("""^the user selects (.*) and clicks continue$""") { (element: String) =>
    element match {
      case "the full amount"      => clickById("choice-full")
      case "the suggested amount" => clickById("choice-suggested")
      case "a different amount"   =>
        clickById("choice-different")
        enterTextById("different-amount", "100")
      case "business account"     => clickById("accountType")
      case "personal account"     => clickById("accountType-2")
      case _                      => throw new Exception(element + " not found")
    }
    continue()
  }

  When("""^the user clicks (.*)$""") { (element: String) =>
    element match {
      case "back"                  => clickByCssSelector("a.govuk-back-link")
      case "back to tax account"   => clickByCssSelector("a.govuk-button")
      case "contact HMRC"          => clickByCssSelector("p:nth-child(4) > a")
      case "continue"              => continue()
      case "Cymraeg"               => clickByCssSelector("nav > ul > li:nth-child(2) > a")
      case "English"               => clickByCssSelector("nav > ul > li:nth-child(1) > a")
      case "the feedback link"     => clickById("help-us-improve-our-services-link")
      case "the history tab"       => clickById("tab_history")
      case "HMRC online account"   => clickByCssSelector("p:nth-child(6) > a")
      case "lockout return button" => clickById("return-to")
      case "sign out"              => clickByCssSelector("a.govuk-link.hmrc-sign-out-nav__link")
      case "view approved"         => clickByCssSelector("tr:nth-child(2) > td:nth-child(4) > a")
      case "view paid"             => clickByCssSelector("tr:nth-child(1) > td:nth-child(5) > a")
      case "view processing"       => clickByCssSelector("tr:nth-child(1) > td:nth-child(4) > a")
      case "view rejected"         => clickByCssSelector("tr:nth-child(2) > td:nth-child(5) > a")
      case "change amount"         => clickByCssSelector("div:nth-child(1) > dd.govuk-summary-list__actions > a")
      case _                       => throw new Exception(element + " not found")
    }
  }

  When("""^the user enters (.*) bank details (.*) roll number and clicks continue$""") {
    (accountType: String, roll: String) =>
      val bankDetails = {
        accountType match {
          case "denyList"                => BankDetails.denyListAccount
          case "invalid business"        => BankDetails.invalidBusinessAccount
          case "invalid personal"        => BankDetails.invalidPersonalAccount
          case "missingRollNumber"       => BankDetails.businessRollRequiredAccount
          case "onEISCD=No"              => BankDetails.onEISCDNoAccount
          case "supportsDirectCredit=No" => BankDetails.supportsDirectCreditNoAccount
          case "valid business"          =>
            roll match {
              case "with"    => BankDetails.businessRollRequiredAccount
              case "without" => BankDetails.validBusinessAccount
            }
          case "valid personal"          =>
            roll match {
              case "with"    => BankDetails.personalRollRequiredAccount
              case "without" => BankDetails.validPersonalAccount
            }
          case "wellFormatted=No"        => BankDetails.wellFormattedNoAccount
          case "wrong name business"     => BankDetails.invalidNameBusinessAccount
          case "wrong name personal"     => BankDetails.invalidNamePersonalAccount
          case _                         => throw new Exception(accountType + " not found")
        }
      }
      enterTextById("accountName", bankDetails.accName)
      enterTextById("sortCode", bankDetails.sortcode)
      enterTextById("accountNumber", bankDetails.accNumber)
      roll match {
        case "with"    => enterTextById("rollNumber", bankDetails.roll)
        case "without" => ()
        case _         => throw new Exception(roll + " not found")
      }
      continue()
  }

  When("""^the IV uplift user selects (.*)$""") { (result: String) =>
    result match {
      case "IV success" => clickById("Success")
      case "IV failure" => clickById("FailedIV")
      case _            => throw new Exception(result + " not found")
    }
    clickById("submit-continue")
  }

}
