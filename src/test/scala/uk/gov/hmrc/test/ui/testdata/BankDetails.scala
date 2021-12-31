package uk.gov.hmrc.test.ui.testdata

case class BankDetails(accName: String, sortcode: String, accNumber: String, roll: String)

object BankDetails {

  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val validAccountPersonal: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Tester", "20 71 06", "44344677", "1234")
    case "qa"                        => BankDetails("Tester", "40 47 84", "70872490", "1234")
  }

  lazy val validAccountBusiness: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Tester", "20 71 06", "86563611", "1234")
    case "qa"                        => BankDetails("Tester", "40 47 84", "70872490", "1234")
  }

  lazy val invalidAccount: BankDetails = environment match {
    case "local" | "dev" | "staging" => BankDetails("Tester!", "01 02 03", "12345678", "1234")
    case "qa"                        => BankDetails("Tester!", "01 02 03", "12345678", "1234")
  }

}
