#!/usr/bin/env bash

sbt -Denvironment=local -Dbrowser=chrome clean 'testOnly uk.gov.hmrc.test.ui.runner.Runner'
