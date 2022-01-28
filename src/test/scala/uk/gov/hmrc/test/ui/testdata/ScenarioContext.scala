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

object ScenarioContext {

  private var variables: Map[String, Any] = Map.empty

  def set(key: String, value: Any): Unit = variables = variables + (key -> value)

  def get[T](key: String): T = {
    variables
      .get(key)
      .fold(throw new NoSuchElementException(s"Scenario variable is not found: [$key]"))(_.asInstanceOf[T])
  }

  def getOrElse[T](key: String, elseResult: T): T = {
    variables
      .get(key)
      .fold(elseResult)(_.asInstanceOf[T])
  }

  def remove(key: String): Unit = variables = variables - key

  def reset(): Unit = variables.foreach { case (key, _) => remove(key) }

}
