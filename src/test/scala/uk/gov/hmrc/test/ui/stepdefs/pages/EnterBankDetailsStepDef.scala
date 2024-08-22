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

package uk.gov.hmrc.test.ui.stepdefs.pages

import uk.gov.hmrc.test.ui.pages.EnterBankDetailsPage
import uk.gov.hmrc.test.ui.pages.support.HelperFunctions
import uk.gov.hmrc.test.ui.testdata.{BankDetails, Language, ScenarioContext}
import java.lang.Thread.sleep

import uk.gov.hmrc.test.ui.stepdefs.DriverActions

class EnterBankDetailsStepDef extends DriverActions {

//  And("""^the user enter valid (personal|business) bank details (with|without) roll number$""") { (accType: String, roll: String) =>
//    ScenarioContext.set("bankDetails", roll match {
//      case "with" => accType match {
//        case "personal" => BankDetails.rollRequiredAccount
//        case "business" => BankDetails.businessRollRequiredAccount
//      }
//      case "without" => accType match {
//        case "personal" => BankDetails.validAccount
//        case "business" => BankDetails.businessAccount
//      }
//    })
//
//    val bankDetails: BankDetails = ScenarioContext.get[BankDetails]("bankDetails")
//
//    roll match {
//      case "with" => EnterBankDetailsPage.enterBankDetailsWithRoll(bankDetails)
//      case _ => EnterBankDetailsPage.enterBankDetails(bankDetails)
//    }
//  }

  When("""^the User enters (.*) bank details$""") { state: String =>
    EnterBankDetailsPage.clearBankDetails()
//    ScenarioContext.set("bankDetails", state match {
////      case "amended" => BankDetails.amendedAccount
////      case "invalid" => BankDetails.invalidAccount
////      case "invalidName" => BankDetails.invalidNameAccount
////      case "indeterminate" => BankDetails.indeterminateAccount
////      case "validBusiness" => BankDetails.businessAccount
////      case "invalidBusiness" => BankDetails.invalidBusinessAccount
////      case "invalidNameBusiness" => BankDetails.invalidBusinessNameAccount
////      case "amendedBusiness" => BankDetails.amendedBusinessAccount
////      case "indeterminateBusiness" => BankDetails.indeterminateBusinessAccount
////      case "wellFormatted=No" => BankDetails.wellFormattedNoAccount
////      case "supportsDirectCredit=No" => BankDetails.supportsDirectCreditNoAccount
////      case "onEISCD=No" => BankDetails.onEISCDNoAccount
////      case "denyList" => BankDetails.denyListAccount
////      case "partialNameBusiness" => BankDetails.partialNameBusinessAccount
////      case "partialName" => BankDetails.partialNameAccount
////      case "rollNumberRequired" => BankDetails.rollRequiredAccount
////      case "noRollNumberButRequired" => BankDetails.rollRequiredAccount
////      case "businessRollNumberRequired" => BankDetails.businessRollRequiredAccount
////      case _ => BankDetails.validAccount
//    })

    val bankDetails: BankDetails = ScenarioContext.get[BankDetails]("bankDetails")

    state match {
      case "rollNumberRequired" => EnterBankDetailsPage.enterBankDetailsWithRoll(bankDetails)
      case _ => EnterBankDetailsPage.enterBankDetails(bankDetails)
    }
  }

  Then("""^the (.*) field should display "(.*)"$""") {
    (elem: String, message: String) =>
      val elemId = elem.replaceAll(" ", "-").toLowerCase

      sleep(400) //To see if prevents issues with false negative tests.

      def prependError: String = if (langToggle == Language.welsh) "Gwall:" else "Error:"

      if (langToggle == Language.welsh) HelperFunctions.errorSummaryHeading() matches("Mae problem wedi codi")
      else HelperFunctions.errorSummaryHeading() matches("There is a problem")

      elem match {

        case "BARS Invalid" =>
          EnterBankDetailsPage.errorSummarySortCode.getText matches(message)
          HelperFunctions.id(elemId + "-error").webElement.getText matches(s"$prependError\n$message")

        case "Sortcode Error" =>
          EnterBankDetailsPage.errorSummarySortCode.getText matches(message)
          EnterBankDetailsPage.errorMessageSortCode.getText matches(s"$prependError\n$message")

        case "Sortcode" =>
          EnterBankDetailsPage.errorSummarySortCode.getText matches(message)
          EnterBankDetailsPage.errorMessageSortCode.getText matches(s"$prependError\n$message")

        case "Name Invalid" =>
          EnterBankDetailsPage.errorSummaryAccountName.getText matches(message)
          EnterBankDetailsPage.errorMessageAccountName.getText matches(s"$prependError\n$message")

        case "Account Name" =>
          EnterBankDetailsPage.errorSummaryAccountName.getText matches(message)
          EnterBankDetailsPage.errorMessageAccountName.getText matches(s"$prependError\n$message")

        case "Account Number Error" =>
          EnterBankDetailsPage.errorSummaryAccountNumber.getText matches(message)
          EnterBankDetailsPage.errorMessageAccountNumber.getText matches(s"$prependError\n$message")

        case "Account Number" =>
          EnterBankDetailsPage.errorSummaryAccountNumber.getText matches(message)
          EnterBankDetailsPage.errorMessageAccountNumber.getText matches(s"$prependError\n$message")

        case "Roll Number Error" =>
          EnterBankDetailsPage.errorSummaryRollNumber.getText matches(message)
          EnterBankDetailsPage.errorMessageRollNumber.getText matches(s"$prependError\n$message")

        case "Roll Number" =>
          EnterBankDetailsPage.errorSummaryRollNumber.getText matches(message)
          EnterBankDetailsPage.errorMessageRollNumber.getText matches(s"$prependError\n$message")

        case "No details entered" =>
          EnterBankDetailsPage.assertNoDetailsError()

        case _ =>
          EnterBankDetailsPage.errorSummary("1").getText matches(message)
          HelperFunctions.id(elemId + "-error").webElement.getText matches(s"$prependError\n$message")
      }
  }

  When("""^the user enters (.*) into the (.*) field$""") {
    (input: String, field: String) =>
      def field1: String = field.toLowerCase
//
//      input match {
//        case "none" => field1 match {
//          case "account name" =>
//            EnterBankDetailsPage.enterBankDetails(BankDetails.validAccount)
//            EnterBankDetailsPage.clearAccountName()
//          case "sortcode" =>
//            EnterBankDetailsPage.enterBankDetails(BankDetails.validAccount)
//            EnterBankDetailsPage.clearSortcode()
//          case "account number" =>
//            EnterBankDetailsPage.enterBankDetails(BankDetails.validAccount)
//            EnterBankDetailsPage.clearAccountNumber()
//          case "roll number" =>
//            EnterBankDetailsPage.enterBankDetails(BankDetails.rollRequiredAccount)
//            EnterBankDetailsPage.clearRollNumber()
//        }
//        case _ =>
//          field1 match {
//            case "account name" =>
//              EnterBankDetailsPage.enterBankDetails(BankDetails.validAccount)
//              EnterBankDetailsPage.clearAccountName()
//              EnterBankDetailsPage.enterAccountName(input)
//            case "sortcode" =>
//              EnterBankDetailsPage.enterBankDetails(BankDetails.validAccount)
//              EnterBankDetailsPage.clearSortcode()
//              EnterBankDetailsPage.enterSortcode(input)
//            case "account number" =>
//              EnterBankDetailsPage.enterBankDetails(BankDetails.validAccount)
//              EnterBankDetailsPage.clearAccountNumber()
//              EnterBankDetailsPage.enterAccountNumber(input)
//            case "roll number" =>
//              EnterBankDetailsPage.enterBankDetails(BankDetails.rollRequiredAccount)
//              EnterBankDetailsPage.clearRollNumber()
//              EnterBankDetailsPage.enterRollNumberNew(input)
//          }
//      }
  }
}
