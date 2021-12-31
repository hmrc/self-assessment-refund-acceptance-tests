package uk.gov.hmrc.test.ui.utils

case class TestConfig(authLoginStubUrl: String,
                      selfAssessmentRefundFrontendUrl: String,
                      bankAccountVerificationUrl: String,
                      paymentsSurveyUrl: String
                     )

object Configuration {
  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val testConfig: TestConfig = environment match {
    case "local" =>
      TestConfig(
        authLoginStubUrl = "http://localhost:9949",
        selfAssessmentRefundFrontendUrl = "http://localhost:9171/self-assessment-refund-frontend",
        bankAccountVerificationUrl = "http://localhost:9903/bank-account-verification",
        paymentsSurveyUrl = "http://localhost:9966/payments-survey"
      )

    case "dev" =>
      TestConfig(
        authLoginStubUrl = "https://www.development.tax.service.gov.uk",
        selfAssessmentRefundFrontendUrl = "https://www.development.tax.service.gov.uk/self-assessment-refund",
        bankAccountVerificationUrl = "https://www.development.tax.service.gov.uk/bank-account-verification",
        paymentsSurveyUrl = "https://www.development.tax.service.gov.uk/payments-survey"
      )

    case "qa" =>
      TestConfig(
        authLoginStubUrl = "https://www.qa.tax.service.gov.uk",
        selfAssessmentRefundFrontendUrl = "https://www.qa.tax.service.gov.uk/self-assessment-refund",
        bankAccountVerificationUrl = "https://www.qa.tax.service.gov.uk/bank-account-verification",
        paymentsSurveyUrl = "https://www.qa.tax.service.gov.uk/payments-survey"
      )

    case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
  }
}
