#!/bin/sh

platform=${1:-darwin}

# Run BrowserStackLocal
if ! sh run_dependencies.sh $platform; then
    echo "Failed to start BrowserStack"
    exit 1
fi

browserStackUsername="hmrcteampayments1"
browserStackAutomateKey="M9JhEVpAdz7tKazSJTLN"

PROJECT_NAME="Self Assessment Refund"
DATE=$(date +%d-%m-%Y" "%H:%M)

JOURNEY="Claim Refund Journey"
HISTORY="Refund History"

### HARDWARE ###

WINDOWS="Windows"
WINDOWS_VERSION="10"

MAC="OS X"
MAC_OS="Monterey"

APPLE_PHONE=""
APPLE_IPAD=""
iOS=

ANDROID_PHONE=""
ANDROID_TABLET=""
ANDROID_VERSION=""


### SOFTWARE VERSIONS ###

IE_VERSION="11"
CHROME_VERSION="latest"
FIREFOX_VERSION="latest"
EDGE_VERSION="latest"
SAFARI_VERSION="latest"
SAFARI_iOS_VERSION="latest"


### Windows ###

#IE11
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version="7" -Dbrowserstack.browser="IE" -Dbrowserstack.browser_version="11" 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version="7" -Dbrowserstack.browser="IE" -Dbrowserstack.browser_version="11" 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
##Edge
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Edge" -Dbrowserstack.browser_version=${EDGE_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Edge" -Dbrowserstack.browser_version=${EDGE_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
##Chrome
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
###Firefox
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Firefox" -Dbrowserstack.browser_version=${FIREFOX_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Firefox" -Dbrowserstack.browser_version=${FIREFOX_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
##

### OS X ###

### iOS ###

### Android ###


killall BrowserStackLocal
