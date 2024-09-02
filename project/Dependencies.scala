import sbt._

object Dependencies {

  val test = Seq(
    "com.typesafe"         % "config"                 % "1.4.3"    % Test,
    "com.vladsch.flexmark" % "flexmark-all"           % "0.64.6"   % Test,
    "org.scalatest"       %% "scalatest"              % "3.2.19"   % Test,
    "org.scalatestplus"   %% "selenium-4-2"           % "3.2.13.0" % Test,
    "io.cucumber"         %% "cucumber-scala"         % "8.23.1"   % Test,
    "io.cucumber"          % "cucumber-junit"         % "7.18.1"   % Test,
    "junit"                % "junit"                  % "4.13.2"   % Test,
    "uk.gov.hmrc"         %% "ui-test-runner"         % "0.36.0"   % Test,
    "com.novocode"         % "junit-interface"        % "0.11"     % Test,
    "io.cucumber"          % "cucumber-picocontainer" % "7.18.1"   % Test,
    "org.mongodb.scala"   %% "mongo-scala-driver"     % "5.1.3"    % Test,
    "com.typesafe.play"   %% "play-json"              % "2.9.4"    % Test
  )

}
