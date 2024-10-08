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

package uk.gov.hmrc.test.ui.utils

case class TestConfig(
  authLoginStubUrl: String,
  selfAssessmentRefundFrontendUrl: String,
  paymentsSurveyUrl: String,
  ivStubUrl: String,
  basGateway: String,
  viewAndChange: String,
  saRequestRefundJourneyFrontendUrl: String,
  saTrackRefundJourneyFrontendUrl: String
)

object Configuration {
  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val testConfig: TestConfig = environment match {
    case "local" =>
      TestConfig(
        authLoginStubUrl = "http://localhost:9949",
        selfAssessmentRefundFrontendUrl = "http://localhost:9171/self-assessment-refund",
        paymentsSurveyUrl = "http://localhost:9966/payments-survey",
        ivStubUrl = "http://localhost:9948/iv-stub",
        basGateway = "http://localhost:9553/bas-gateway",
        viewAndChange = "http://localhost:9081",
        saRequestRefundJourneyFrontendUrl = "http://localhost:9171/request-a-self-assessment-refund",
        saTrackRefundJourneyFrontendUrl = "http://localhost:9171/track-a-self-assessment-refund"
      )

    case "dev" =>
      TestConfig(
        authLoginStubUrl = "https://www.development.tax.service.gov.uk",
        selfAssessmentRefundFrontendUrl = "https://www.development.tax.service.gov.uk/self-assessment-refund",
        paymentsSurveyUrl = "https://www.development.tax.service.gov.uk/payments-survey",
        ivStubUrl = "https://www.development.tax.service.gov.uk/iv-stub",
        basGateway = "https://www.development.tax.service.gov.uk/bas-gateway",
        viewAndChange = "https://www.development.tax.service.gov.uk",
        saRequestRefundJourneyFrontendUrl =
          "https://www.development.tax.service.gov.uk/request-a-self-assessment-refund",
        saTrackRefundJourneyFrontendUrl = "https://www.development.tax.service.gov.uk/track-a-self-assessment-refund"
      )

    case "qa" =>
      TestConfig(
        authLoginStubUrl = "https://www.qa.tax.service.gov.uk",
        selfAssessmentRefundFrontendUrl = "https://www.qa.tax.service.gov.uk/self-assessment-refund",
        paymentsSurveyUrl = "https://www.qa.tax.service.gov.uk/payments-survey",
        ivStubUrl = "https://www.qa.tax.service.gov.uk/iv-stub",
        basGateway = "https://www.qa.tax.service.gov.uk/bas-gateway",
        viewAndChange = "https://www.qa.tax.service.gov.uk",
        saRequestRefundJourneyFrontendUrl = "https://www.qa.tax.service.gov.uk/request-a-self-assessment-refund",
        saTrackRefundJourneyFrontendUrl = "https://www.qa.tax.service.gov.uk/track-a-self-assessment-refund"
      )

    case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
  }
}
