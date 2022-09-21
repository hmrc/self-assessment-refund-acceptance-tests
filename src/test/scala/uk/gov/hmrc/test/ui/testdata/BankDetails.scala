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

  lazy val validAccountPersonal: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Melvin Loper", "207106", "44311677", "1234")
    case "qa"                        => BankDetails("Melvin Loper", "207106", "44311677", "1234")
  }

  lazy val validAccountBusiness: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Megacorp", "207106", "86563611", "1234")
    case "qa"                        => BankDetails("Megacorp", "207106", "86563611", "1234")
  }

  lazy val invalidAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Tester!", "010203", "12345678", "1234")
    case "qa"                        => BankDetails("Tester!", "010203", "12345678", "1234")
  }

}
