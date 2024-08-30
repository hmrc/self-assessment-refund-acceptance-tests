#!/bin/bash -e
DEFAULT_BROWSER=chrome
BROWSER_TYPE=$1
ENV=$2
TEARDOWN=$3

if [ -z "$BROWSER_TYPE" ]; then
    echo "BROWSER_TYPE value not set, defaulting to $DEFAULT_BROWSER..."
    echo ""
fi

# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
sbt scalafmtAll scalafmtSbt scalafmtCheckAll scalafmtSbtCheck

sbt clean -Dbrowser="${BROWSER_TYPE:=$DEFAULT_BROWSER}" -Denvironment="${ENV:=local}" -Dteardown="${TEARDOWN:=true}" "testOnly uk.gov.hmrc.test.ui.runner.WipRunner" testReport
