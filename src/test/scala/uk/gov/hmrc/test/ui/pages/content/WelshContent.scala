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

package uk.gov.hmrc.test.ui.pages.content

import uk.gov.hmrc.test.ui.testdata.BankDetails.{businessAccount, validAccount}
import uk.gov.hmrc.test.ui.testdata.{BankDetails, Language, ScenarioContext, TestData}

import java.time.{LocalDate, LocalDateTime}
import java.time.format.DateTimeFormatter

object WelshContent {

  def accountOnFilePageText(): String = {
    s"""Mae angen i ni gael eich manylion banc
       |Os gwnaethoch dalu’ch Hunanasesiad â cherdyn credyd neu ddebyd, byddwn yn ceisio ad-dalu’r arian i’ch cerdyn. Mae angen eich manylion banc arnom rhag ofn na allwn wneud hyn.
       |Dewiswch ‘Yn eich blaen’ i roi’ch manylion banc.
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def checkDetailsPageNoRollText(): String = {
    var accType: String = ScenarioContext.get("personalOrBusiness")
    val amount: String = ScenarioContext.get("amount")
    def bankDetails: BankDetails = ScenarioContext.get("bankDetails")
    var sortCode = ""

    accType match {
      case "personal" =>
        accType = "Personol"
      case "business" =>
        accType = "Busnes"
    }
    sortCode = bankDetails.sortcode.replace("-", "").replace(" ", "")

    s"""Gwiriwch eich manylion
       |Math o Gyfrif
       |$accType Newid
       |y math o gyfrif
       |Enw ar y cyfrif ${bankDetails.accName} Newid
       |y manylion banc
       |Cod didoli $sortCode
       |Rhif y cyfrif ${bankDetails.accNumber}
       |Swm i’w ad-dalu
       |£$amount Newid
       |swm yr ad-daliad
       |Cadarnhewch eich manylion er mwyn cwblhau’ch cais am ad-daliad.
       |Cadarnhau ac yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }


  def checkDetailsPageText(): String = {
    var accType: String = ScenarioContext.get("personalOrBusiness")
    val amount: String = ScenarioContext.get("amount")
    def bankDetails: BankDetails = ScenarioContext.get("bankDetails")
    var sortCode = ""

    accType match {
      case "personal" =>
        accType = "Personol"
      case "business" =>
        accType = "Busnes"
    }
    sortCode = bankDetails.sortcode.replace("-","").replace(" ","")

    s"""Gwiriwch eich manylion
       |Math o Gyfrif
       |$accType Newid
       |y math o gyfrif
       |Enw ar y cyfrif ${bankDetails.accName} Newid
       |y manylion banc
       |Cod didoli $sortCode
       |Rhif y cyfrif ${bankDetails.accNumber}
       |Rhif rôl y gymdeithas adeiladu ${bankDetails.roll}
       |Swm i’w ad-dalu
       |£$amount Newid
       |swm yr ad-daliad
       |Cadarnhewch eich manylion er mwyn cwblhau’ch cais am ad-daliad.
       |Cadarnhau ac yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def enterBankDetailsPageText(): String = {
    s"""Nodwch fanylion y cyfrif banc neu'r cyfrif cymdeithas adeiladu
       |Enw ar y cyfrif
       |Fanylion banc
       |Cod didoli
       |Mae’n rhaid iddo fod yn 6 digid o hyd
       |Rhif y cyfrif
       |Mae’n rhaid iddo fod rhwng 6 ac 8 digid o hyd
       |Rhif rôl y gymdeithas adeiladu (os oes gennych un)
       |Gallwch ddod o hyd iddo ar eich cerdyn, cyfriflen neu baslyfr
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def requestReceivedPageText(): String = {
    val reference: String = TestData.referenceNumber
    val refundType: String = TestData.refundType
    val date: String = LocalDate.now().format(DateTimeFormatter.ofPattern("d MMMM yyyy"))
    val amount: String = ScenarioContext.get("amount")
    s"""Cais am ad-daliad wedi dod i law
       |Cyfeirnod eich ad-daliad yw
       |$reference
       |Treth Hunanasesiad
       |Dyddiad $date
       |Swm i’w ad-dalu £$amount
       |Yr hyn sy’n digwydd nesaf
       |Byddwn yn anfon eich ad-daliad i’r cyfrif banc a nodwyd gennych neu i’r cerdyn a ddefnyddiwyd gennych i dalu’ch bil diwethaf.
       |Bwriad CThEM yw anfon ad-daliadau cyn pen pythefnos. Fodd bynnag, er mwyn eich diogelu rhag twyll, mae gan CThEM fesurau diogelwch ar waith a allai achosi oedi. Dylech aros 30 diwrnod cyn cysylltu â ni ynglŷn â’ch cais.
       |Gallwch wirio statws eich ad-daliad yn eich cyfrif CThEM ar-lein.
       |Gallwch argraffu neu lawrlwytho copi o’ch cais am ad-daliad (PDF)
       |
       |Helpu ni i wella ein gwasanaethau
       |Rydym yn defnyddio’ch adborth i wella ein gwasanaethau.
       |Rhowch wybod i ni beth yw eich barn am y gwasanaeth hwn (mae’n cymryd 30 eiliad)
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def refundAmountPageText(): String = {
    def amount: String = if (ScenarioContext.get[String]("nino") == TestData.nino)
      TestData.maxRefundAmount
    else
      TestData.maxRefundAmount2

    s"""Faint o ad-daliad yr hoffech ei gael?
       |Ad-daliad o’r swm llawn, £$amount
       |Ad-daliad am swm gwahanol
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def ivKickoutPageText(): String = {
    s"""Nid oedd modd i ni gadarnhau pwy ydych
       |Rydych wedi nodi gwybodaeth nad yw’n cyd-fynd â’n cofnodion gormod o weithiau. Am resymau diogelwch, mae’n rhaid i chi aros 24 awr ac yna fewngofnodi i roi cynnig arall arni.
       |Yn ôl i’ch cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def lockoutPageText(): String = {
    val date: String = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("d MMMM yyyy"))
    val time: String = LocalDateTime.now().plusHours(1).format(DateTimeFormatter.ofPattern("h:mma")).toLowerCase()

    s"""Rydych wedi ceisio cadarnhau’ch manylion banc gormod o weithiau
       |Nid yw’ch cais am ad-daliad wedi’i gyflwyno.
       |Bydd angen i chi aros tan $date, $time cyn ceisio cadarnhau’ch manylion banc eto.
       |Cysylltwch â CThEF dros y ffôn er mwyn siarad â rhywun ynghylch Hunanasesiad.
       |Ewch i’r cyfrif treth
       |Is this page not working properly? (opens in new tab)""".stripMargin
  }

  def doesNotAcceptPaymentsPageText(): String = {
    s"""Nid yw’ch cyfrif banc yn derbyn taliadau
       |Ni allwn gwblhau’ch cais am ad-daliad.
       |
       |Gallwch roi cynnig arall arni gan ddefnyddio cyfrif banc gwahanol.
       |Rhoi cynnig arall arni
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  //Redirects to Payments Survey Service so content assertion not needed.
  def surveyPageText(): String = {
    s"""
       |
       |""".stripMargin
  }

  def typeOfAccountPageText(): String = {
    s"""Manylion pa fath o gyfrif yr ydych yn eu rhoi?
       |Os ydych yn gwneud cais am ad-daliad i chi’ch hun, gallwch nodi’ch manylion banc eich hun neu fanylion banc eich asiant. Os ydych yn asiant, nodwch fanylion banc eich cleient.
       |Cyfrif banc busnes
       |Cyfrif banc personol
       |Yn eich blaen
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def refundHistoryHistoryPageText(): String = {
    //TODO Confirmed Welsh translation
    val requestedOnDate1: String = TestData.requestedOnDate1AB111111C
    val paidOnDate1: String = TestData.paidOnDate1AB111111C
    val paidAmount1: String = TestData.paidAmount1AB111111C
    val requestedOnDate2: String = TestData.requestedOnDate2AB111111C
    val rejectedDate2: String = TestData.rejectedDate2AB111111C
    val rejectedAmount1: String = TestData.rejectedAmount1AB111111C

    s"""Hanes eich ad-daliad
       |Ar waith
       |Hanes
       |Hanes
       |Gofyn ar Wedi’i gwblhau ar Swm a hawliwyd Statws Gweithredoedd
       |$requestedOnDate1 $paidOnDate1 £$paidAmount1 Talwyd Bwrw golwg dros
       |fanylion yr hawliad dyddiedig $requestedOnDate1
       |$requestedOnDate2 $rejectedDate2 £$rejectedAmount1 Wedi’i wrthod Bwrw golwg dros
       |fanylion yr hawliad dyddiedig $requestedOnDate2
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def refundHistoryInProgressPageText(): String = {
    //TODO Confirmed Welsh translation
    val inProgressDate1: String = TestData.inProgessDate1AB111111C
    val inProgressAmount1: String = TestData.inProgessAmount1AB111111C
    val approvedDate1: String = TestData.approvedDate1AB111111C
    val approvedAmount1: String = TestData.approvedAmount1AB111111C

    s"""Hanes eich ad-daliad
       |Ar waith
       |Hanes
       |Ar waith
       |Gofyn ar Swm a hawliwyd Statws Gweithredoedd
       |$inProgressDate1 £$inProgressAmount1 Wrthi’n prosesu Bwrw golwg dros
       |fanylion yr hawliad dyddiedig $inProgressDate1
       |$approvedDate1 £$approvedAmount1 Cymeradwywyd Bwrw golwg dros
       |fanylion yr hawliad dyddiedig $approvedDate1
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusApprovedPageText(): String = {
    //TODO Confirmed Welsh translation
    val approvedAmountValue: String = TestData.approvedAmount1AB111111C
    s"""Mae’ch ad-daliad o £$approvedAmountValue wedi’i gymeradwyo
       |Byddwn yn anfon eich ad-daliad i’r cyfrif banc a nodwyd gennych neu i’r cerdyn a ddefnyddiwyd gennych i dalu’ch bil diwethaf.
       |Dylech ganiatáu 3 i 5 diwrnod i’r arian gyrraedd eich cyfrif banc neu’ch cerdyn.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusProcessingPageText(): String = {
    val pendingAmountValue: String = TestData.inProgessAmount1AB111111C
    s"""Mae’ch ad-daliad o £$pendingAmountValue ar y gweill
       |Mae’ch cais am ad-daliad wedi dod i law. Bwriad CThEM yw anfon ad-daliadau cyn pen pythefnos, ond mae mesurau diogelwch ar waith a allai achosi oedi.
       |Dylech aros 30 diwrnod cyn cysylltu â ni ynglŷn â’ch cais.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusRejectedPageText(): String = {
    val rejectedAmountValue: String = TestData.rejectedAmount1AB111111C
    s"""Mae’ch ad-daliad o £$rejectedAmountValue wedi’i wrthod
       |Ni allwn ad-dalu’r £$rejectedAmountValue oherwydd bod eich cais am ad-daliad wedi’i wrthod.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def statusPaidPageText(): String = {
    //TODO Welsh Translation
    val paidAmountValue: String = TestData.paidAmount1AB111111C
    val paidOnDate: String = TestData.paidOnDate1AB111111C
    s"""Mae’ch ad-daliad wedi’i dalu
       |Gwnaethom anfon taliad o £$paidAmountValue atoch ar $paidOnDate.
       |Mae’n gallu cymryd 3 i 5 diwrnod i’r arian gyrraedd eich cyfrif banc.
       |Yn ôl i’r cyfrif treth
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

  def requestFailedText(): String = {
    s"""Mae’n ddrwg gennym, mae problem gyda’r gwasanaeth
       |Nid yw’ch cais am ad-daliad wedi’i gyflwyno.
       |Pan fydd y gwasanaeth ar gael, bydd yn rhaid i chi ddechrau eto.
       |Fel arall, gallwch gysylltu â Chyllid a Thollau EM os oes angen i chi siarad â rhywun am eich treth Hunanasesiad neu wneud cais am ad-daliad dros y ffôn.
       |Dechrau eto
       |A yw’r dudalen hon yn gweithio’n iawn? (yn agor mewn tab newydd)""".stripMargin
  }

}
