import com.timushev.sbt.updates.UpdatesKeys.dependencyUpdates
import com.timushev.sbt.updates.UpdatesPlugin.autoImport.{dependencyUpdatesFailBuild, dependencyUpdatesFilter, moduleFilterRemoveValue}
import sbt.{moduleFilter, _}
import sbt.Keys._

object SbtUpdatesSettings {

  lazy val sbtUpdatesSettings = Seq(
    dependencyUpdatesFailBuild := false,
    (Compile / compile) := ((Compile / compile) dependsOn dependencyUpdates).value,
    dependencyUpdatesFilter -= moduleFilter("org.scala-lang"),
    dependencyUpdatesFilter -= moduleFilter("com.typesafe.play"),
    // later versions result in this error:
    // ---
    // java.lang.UnsupportedClassVersionError: com/vladsch/flexmark/util/ast/Node has been
    // compiled by a more recent version of the Java Runtime (class file version 55.0), this
    // version of the Java Runtime only recognizes class file versions up to 52.0
    // ---
    dependencyUpdatesFilter -= moduleFilter("com.vladsch.flexmark", "flexmark-all"),
    dependencyUpdatesFilter -= moduleFilter("org.mongodb.scala", "mongo-scala-driver")
    // updating to mongo-driver 5.2.0 not recommended as requires Mongo version 7 when MDTP uses version 5
    // https://docs.tax.service.gov.uk/mdtp-handbook/documentation/developer-set-up/set-up-mongodb.html
  )

}
