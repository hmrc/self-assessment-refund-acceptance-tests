name := "self-assessment-refund-acceptance-tests"

version := "0.5"

scalaVersion := "2.13.10"

credentials += Credentials(Path.userHome / ".sbt" / ".credentials")

resolvers ++= Seq(
  Resolver.bintrayRepo("hmrc", "releases"),
  "hmrc-releases" at "https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/"
)

libraryDependencies ++= Seq(
  "org.scalatest"           %% "scalatest"              % "3.2.16" excludeAll ExclusionRule(organization = "org.seleniumhq.selenium"),
  "org.scalatestplus"   %% "selenium-3-141"     % "3.2.10.0",
  "org.seleniumhq.selenium" %  "selenium-java"          % "4.8.1",
//  "org.seleniumhq.selenium" %  "selenium-http-jdk-client"          % "4.8.1",
  "io.cucumber"             %% "cucumber-scala"         % "8.15.0",
  "io.cucumber"             % "cucumber-junit"          % "7.12.1",
  "io.cucumber"             % "cucumber-picocontainer"  % "7.12.1",
  "uk.gov.hmrc"             %% "webdriver-factory"      % "0.44.0" % "test",
  "org.typelevel"           %% "cats-core"                   % "2.9.0",
  "com.novocode"            %  "junit-interface"        % "0.11",
  "org.mongodb.scala"       %% "mongo-scala-driver"     % "2.7.0"
  //  "uk.gov.hmrc"             %% "zap-automation"         % "2.10.0" % "test" exclude("org.slf4j", "slf4j-api")
)
