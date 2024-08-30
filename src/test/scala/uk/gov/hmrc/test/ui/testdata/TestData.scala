/*
 * Copyright 2022 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.testdata

import uk.gov.hmrc.test.ui.pages.ExternalPages.SurveyPage.langToggle

import java.time.LocalDate
import java.time.format.DateTimeFormatter

case class TestData(nino: String, maxRefundAmount:String, inProgressDate1: Option[String] = None, inProgessAmount1: Option[String] = None, approvedDate1: Option[String] = None, approvedAmount1: Option[String] = None,
                    requestedOnDate1: Option[String] = None, requestedOnDate2: Option[String] = None, paidOnDate1: Option[String] = None, rejectedDate2: Option[String] = None, paidAmount1: Option[String] = None, rejectedAmount1: Option[String] = None)


object TestData {

  //Test Users
  lazy val AB111111D: TestData = TestData("AB111111D", "123.45")
  lazy val AB111111C: TestData = TestData("AB111111C", "987.65")


  //Shared variables
  val refundType = if (langToggle == Language.welsh) "Hunanasesiad" else "Self Assessment"





  //TODO sort out test users and data when stubs are created - similar to the bank details class/object

  //Test User 1 details
  val nino = "AB111111D"
  val refundAmount = "987.65"
  var referenceNumber = ""
  val totalRefunds = "13,029.68"
  val maxRefundAmount = "123.45"
  val amountValue = "545.80"
  val dateValue: String = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))

  //In Progress Tab
  def inProgessDate1 = if (langToggle == Language.welsh) "7 Mehefin 2022" else "7 June 2022"
  def inProgessDate2 = if (langToggle == Language.welsh) "7 Mehefin 2022" else "7 June 2022"
  def inProgessDate3 = if (langToggle == Language.welsh) "5 Gorffennaf 2021" else "5 July 2021"
  def inProgessDate4 = if (langToggle == Language.welsh) "21 Mai 2021" else "21 May 2021"
  val inProgessAmount1 = "123.00"
  val inProgessAmount2 = "123.00"
  val inProgessAmount3 = "20,000.00"
  val inProgessAmount4 = "30,000.00"
  def approvedDate1 = if (langToggle == Language.welsh) "21 Gorffennaf 2020" else "21 July 2020"
  def approvedDate2 = if (langToggle == Language.welsh) "1 Mai 2019" else "1 May 2019"
  def approvedDate3 = if (langToggle == Language.welsh) "13 Medi 2018" else "13 September 2018"
  def approvedDate4 = if (langToggle == Language.welsh) "13 Mehefin 2015" else "13 June 2015"
  val approvedAmount1 = "12,000.00"
  val approvedAmount2 = "4,000.00"
  val approvedAmount3 = "8,000.00"
  //TODO Shouldnt be there as over 6 years ago
  val approvedAmount4 = "8,000.00"


  //History Tab
  def requestedOnDate1 = if (langToggle == Language.welsh) "1 Hydref 2019" else "1 October 2019"
  def requestedOnDate2 = if (langToggle == Language.welsh) "1 Ebrill 2019" else "1 April 2019"
  def paidOnDate1 = if (langToggle == Language.welsh) "4 Hydref 2019" else "4 October 2019"
  def rejectedDate2 = if (langToggle == Language.welsh) "4 Ebrill 2019" else "4 April 2019"
  val paidAmount1 = "4,000.00"
  val rejectedAmount1 = "4,000.00"


  val nino2 = "AB111111C"
  val maxRefundAmount2 = "987.65"


  //NINO AB111111D

//  val nino3 = "AB111111D"
  def inProgessDate1AB111111C = if (langToggle == Language.welsh) "3 Mawrth 2022" else "3 March 2022"
  def approvedDate1AB111111C = if (langToggle == Language.welsh) "1 Ionawr 2022" else "1 January 2022"
  val inProgessAmount1AB111111C = "3,000.00"
  val approvedAmount1AB111111C = "1,000.00"
  def requestedOnDate1AB111111C = if (langToggle == Language.welsh) "4 Ebrill 2022" else "4 April 2022"
  def requestedOnDate2AB111111C = if (langToggle == Language.welsh) "2 Chwefror 2022" else "2 February 2022"
  def paidOnDate1AB111111C = if (langToggle == Language.welsh) "14 Ebrill 2022" else "14 April 2022"
  def rejectedDate2AB111111C = if (langToggle == Language.welsh) "12 Chwefror 2022" else "12 February 2022"
  val paidAmount1AB111111C = "4,000.00"
  val rejectedAmount1AB111111C = "2,000.00"
}
