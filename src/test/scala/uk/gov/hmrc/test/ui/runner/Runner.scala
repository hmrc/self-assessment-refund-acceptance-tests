package uk.gov.hmrc.test.ui.runner

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("uk.gov.hmrc.test.ui.stepdefs"),
  plugin = Array("pretty", "html:target/cucumber", "json:target/cucumber.json"),
  tags = Array("~@wip", "~@ignore")
)
class Runner {}
