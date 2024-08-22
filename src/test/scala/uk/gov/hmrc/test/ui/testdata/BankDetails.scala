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

package uk.gov.hmrc.test.ui.testdata

case class BankDetails(accName: String, sortcode: String, accNumber: String, roll: String)

object BankDetails {

  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val validPersonalAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Melvin Loper", "20-71-06", "44311677", "0")
    case "qa" => BankDetails("TBC", "40-47-84", "70872490", "0")
  }

  lazy val invalidNameAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("INVALID NAME", "20-71-06", "44311677", "0")
    case "qa" => BankDetails("TBC", "40-47-84", "70872490", "0")
  }

  lazy val amendedAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Felipa Doherty", "20-71-06", "44344677", "0")
    case "qa" => BankDetails("TBC", "40-47-84", "70872490", "0")
  }

  lazy val invalidAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Tester", "00-00-00", "12345678", "0")
    case "qa" => BankDetails("TBC", "40-47-84", "12345678", "0")
  }

  lazy val indeterminateAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Nichole Cartwright", "40 51 25", "54377677", "0")
    case "qa" => BankDetails("TBC", "09 06 66", "42553011", "0")
  }

  lazy val partialNameAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Melvin", "20 71 06", "44311677", "0")
    case "qa" => BankDetails("TBC", "09 06 66", "42553011", "0")
  }

  lazy val validBusinessAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Security Engima", "20 71 06", "86473611", "0")
    case "qa" => BankDetails("TBC", "09 06 66", "42553011","0")
  }

  lazy val invalidBusinessAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Tester", "00-00-00", "12345678", "0")
    case "qa" => BankDetails("TBC", "09 06 66", "42553011", "0")
  }

  lazy val invalidBusinessNameAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Invalid Name", "20 71 06", "86473611", "0")
    case "qa" => BankDetails("TBC", "09 06 66", "42553011", "0")
  }

  lazy val amendedBusinessAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Megacorp", "20 71 06", "86563611", "0")
    case "qa" => BankDetails("TBC", "40-47-84", "70872490", "0")
  }

  lazy val indeterminateBusinessAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Zanetti Office Supplies", "40 51 25", "96473611", "0")
    case "qa" => BankDetails("TBC", "40-47-84", "70872490", "0")
  }

  lazy val partialNameBusinessAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Security", "20 71 06", "86473611", "0")
    case "qa" => BankDetails("TBC", "09 06 66", "42553011", "0")
  }

  //Other Scenarios

  lazy val wellFormattedNoAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Not well formatted", "609593", "44311611", "0")
    case "qa" => BankDetails("TBC", "TBC", "TBC", "0")
  }

  lazy val supportsDirectCreditNoAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Doesnt support Direct Credit", "207102", "44344655", "0")
    case "qa" => BankDetails("TBC", "TBC", "TBC", "0")
  }

  lazy val onEISCDNoAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Not on EISCD", "309696", "44311611", "0")
    case "qa" => BankDetails("TBC", "TBC", "TBC", "0")
  }

  lazy val denyListAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Deny List", "201147", "44311611", "0")
    case "qa" => BankDetails("TBC", "TBC", "TBC", "0")
  }

  lazy val personalRollRequiredAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Tinisha Bussey", "609593", "91661500", "0")
    case "qa" => BankDetails("TBC", "TBC", "TBC", "0")
  }

  lazy val businessRollRequiredAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("O'Connor Construction", "609593", "96863604", "0")
    case "qa" => BankDetails("TBC", "TBC", "TBC", "0")
  }


}
