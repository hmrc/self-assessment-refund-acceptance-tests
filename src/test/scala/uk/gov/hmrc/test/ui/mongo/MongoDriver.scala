package uk.gov.hmrc.test.ui.mongo

import uk.gov.hmrc.test.ui.mongo.MongoHelper._
import org.mongodb.scala._

object MongoDriver {

  // Connect to the default server localhost on port 27017
  // Dropping Mongo like this will only work locally, unless you have config for other MongoClients.

  private val mongoClient: MongoClient = MongoClient()

  private val selfAssessmentRefundBackend: MongoDatabase = mongoClient.getDatabase("self-assessment-refund-backend")

  def dropDatabases(): Unit = {
    selfAssessmentRefundBackend.drop().printResults()
  }
}
