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

