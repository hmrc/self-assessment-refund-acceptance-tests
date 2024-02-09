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

package uk.gov.hmrc.test.ui.stepdefs.pages

import uk.gov.hmrc.test.ui.pages.DesErrorPage
import uk.gov.hmrc.test.ui.stepdefs.other.DriverActions
import uk.gov.hmrc.test.ui.testdata.Language

class DesErrorPageStepDef extends DriverActions {

  And("""^the Start Again link is correct$""") { () =>
    DesErrorPage.startAgainHref()
  }

  And("""^the user selects the contact us link and is taken to the correct url$""") { () =>
    DesErrorPage.clickContactLink()
    if (langToggle == Language.welsh) {
      currentUrl == "https://www.gov.uk/government/organisations/hm-revenue-customs/contact/welsh-language-helplines"
    }
    else {
      currentUrl == "https://www.gov.uk/government/organisations/hm-revenue-customs/contact/self-assessment"
    }
    driver.navigate().back()
  }

}
