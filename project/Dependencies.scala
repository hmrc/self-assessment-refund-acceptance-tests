import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "com.typesafe"         % "config"                 % "1.4.3"    % Test,
    "com.vladsch.flexmark" % "flexmark-all"           % "0.64.6"   % Test,
    "org.scalatest"       %% "scalatest"              % "3.2.19"   % Test,
    "org.scalatestplus"   %% "selenium-4-2"           % "3.2.13.0" % Test,
    "io.cucumber"         %% "cucumber-scala"         % "8.24.0"   % Test,
    "io.cucumber"          % "cucumber-junit"         % "7.20.0"   % Test,
    "io.cucumber"          % "cucumber-picocontainer" % "7.20.0"   % Test,
    "junit"                % "junit"                  % "4.13.2"   % Test,
    "uk.gov.hmrc"         %% "ui-test-runner"         % "0.38.0"   % Test,
    "com.novocode"         % "junit-interface"        % "0.11"     % Test,
    "org.mongodb.scala"   %% "mongo-scala-driver"     % "5.1.4"    % Test,
    "com.typesafe.play"   %% "play-json"              % "2.10.5"   % Test
  )

}
