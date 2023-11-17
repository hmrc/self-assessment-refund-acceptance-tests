#!/usr/bin/env bash


sm --stop ASSETS_FRONTEND
sleep 5
sm --start ASSETS_FRONTEND -r 4.22.0

sbt -Denvironment=local -Dbrowser=remote-chrome clean 'testOnly uk.gov.hmrc.test.ui.runner.A11yRunner'

