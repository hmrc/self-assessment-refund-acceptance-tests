package uk.gov.hmrc.test.ui.stepdefs.other

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import uk.gov.hmrc.webdriver.SingletonDriver

import scala.util.Try

trait Steps extends ScalaDsl with EN with Matchers {

  Before { _ ⇒
    ScenarioVariables.resetScenarioVariables()
  }

  After { _ ⇒
//   Try(SingletonDriver.closeInstance)
  }

}
