name := "self-assessment-refund-acceptance-tests"

version := "0.5"

scalaVersion := "2.12.11"

val scalatestVersion = "3.0.5"
val cucumberVersion = "4.7.1"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

resolvers ++= Seq(
  Resolver.bintrayRepo("hmrc", "releases"),
  "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/"
)

libraryDependencies ++= Seq(
  "org.scalatest"           %% "scalatest"              % scalatestVersion excludeAll ExclusionRule(organization = "org.seleniumhq.selenium"),
  "org.seleniumhq.selenium" %  "selenium-java"          % "3.9.1",
  "io.cucumber"             %% "cucumber-scala"         % cucumberVersion,
  "io.cucumber"             % "cucumber-junit"          % cucumberVersion,
  "io.cucumber"             % "cucumber-picocontainer"  % cucumberVersion,
  "uk.gov.hmrc"             %% "webdriver-factory"      % "0.25.0" % "test",
  "org.typelevel"           %% "cats"                   % "0.9.0",
  "com.novocode"            %  "junit-interface"        % "0.11"
  //  "uk.gov.hmrc"             %% "zap-automation"         % "2.10.0" % "test" exclude("org.slf4j", "slf4j-api")
)
