#!/usr/bin/env bash

sm --stop BANK_ACCOUNT_VERIFICATION_FRONTEND
sleep 10
sm --start BANK_ACCOUNT_VERIFICATION_FRONTEND -r --appendArgs '{
      "BANK_ACCOUNT_VERIFICATION_FRONTEND": [
        "-J-Dmicroservice.services.access-control.enabled=true",
        "-J-Dmicroservice.services.access-control.allow-list.0=self-assessment-refund-frontend"
      ]
    }'
sleep 10
sbt -Denvironment=local -Dbrowser=remote-chrome clean 'testOnly uk.gov.hmrc.test.ui.runner.Runner'
