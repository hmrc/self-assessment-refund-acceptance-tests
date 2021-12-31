package uk.gov.hmrc.test.ui.testdata

case class UserDetails(accType: String)

object UserDetails {

  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val PersonalUserDetails: UserDetails = environment match {
    case "local" | "dev" | "staging" => UserDetails("personal")
    case "qa"                        => UserDetails("personal")
  }

  lazy val BusinessUserDetails: UserDetails = environment match {
    case "local" | "dev" | "staging" => UserDetails("business")
    case "qa"                        => UserDetails("business")
  }

}

