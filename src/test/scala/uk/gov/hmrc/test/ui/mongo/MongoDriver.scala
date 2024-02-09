/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
