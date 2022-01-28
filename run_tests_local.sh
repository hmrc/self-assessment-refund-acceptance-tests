#!/usr/bin/env bash

sbt -Denvironment=local -Dbrowser=headless-chrome clean 'testOnly uk.gov.hmrc.test.ui.runner.Runner'
