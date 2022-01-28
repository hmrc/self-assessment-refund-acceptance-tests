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

object VRNs {

  val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  object CommunicationPreference {
    val digitalVerified: String = environment match {
      case "local" | "dev" | "staging" => "101747696"
      case "qa" => "101747696"
    }

    val digitalUnverified: String = environment match {
      case "local" | "dev" | "staging" => "999964805"
      case "qa" => "999964805"
    }

    val paper: String = environment match {
      case "local" | "dev" | "staging" => "774142430"
      case "qa" => "774142430"
    }

    val unknown: String = environment match {
      case "local" | "dev" | "staging" => "774142528"
      case "qa" => "774142528"
    }
  }

  object ChangeInProgress {
    val changeIsInProgress: String = environment match {
      case "local" | "dev" | "staging" => "999900155"
      case "qa" => "ADDME"
    }
    val changeIsNotInProgress: String = environment match {
      case "local" | "dev" | "staging" => "774142430"
      case "qa" => "ADDME"
    }
  }


}

