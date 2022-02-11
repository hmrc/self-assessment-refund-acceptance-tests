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

APPLE_PHONE="iPhone 12"
APPLE_IPAD="iPad Air 4"
iOS="14.0"

ANDROID_PHONE="Samsung Galaxy S21"
ANDROID_TABLET="Samsung Galaxy Tab S7"
ANDROID_VERSION="10.0"


### SOFTWARE VERSIONS ###

IE_VERSION="11"
CHROME_VERSION="latest"
FIREFOX_VERSION="latest"
EDGE_VERSION="latest"
SAFARI_VERSION="latest"
SAFARI_iOS_VERSION="latest"
SAMSUNG_INTERNET_VERSION="latest"


### Windows ###

#IE11
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version="7" -Dbrowserstack.browser="IE" -Dbrowserstack.browser_version="11" 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version="7" -Dbrowserstack.browser="IE" -Dbrowserstack.browser_version="11" 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
##Edge
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Edge" -Dbrowserstack.browser_version=${EDGE_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Edge" -Dbrowserstack.browser_version=${EDGE_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
##Chrome
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
###Firefox
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Firefox" -Dbrowserstack.browser_version=${FIREFOX_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${WINDOWS} -Dbrowserstack.os_version=${WINDOWS_VERSION} -Dbrowserstack.browser="Firefox" -Dbrowserstack.browser_version=${FIREFOX_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
##

## OS X ###

##Safari
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${MAC} -Dbrowserstack.os_version=${MAC_OS} -Dbrowserstack.browser="Safari" -Dbrowserstack.browser_version=${SAFARI_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${MAC} -Dbrowserstack.os_version=${MAC_OS} -Dbrowserstack.browser="Safari" -Dbrowserstack.browser_version=${SAFARI_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
##Chrome
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${MAC} -Dbrowserstack.os_version=${MAC_OS} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${MAC} -Dbrowserstack.os_version=${MAC_OS} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
###Firefox
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${MAC} -Dbrowserstack.os_version=${MAC_OS} -Dbrowserstack.browser="Firefox" -Dbrowserstack.browser_version=${FIREFOX_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${MAC} -Dbrowserstack.os_version=${MAC_OS} -Dbrowserstack.browser="Firefox" -Dbrowserstack.browser_version=${FIREFOX_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'

### iOS ###

##Safari iOS iPhone
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${APPLE_PHONE} -Dbrowserstack.os_version=${iOS} -Dbrowserstack.browser="iphone" -Dbrowserstack.browser_version=${SAFARI_iOS_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${APPLE_PHONE} -Dbrowserstack.os_version=${iOS} -Dbrowserstack.browser="iphone" -Dbrowserstack.browser_version=${SAFARI_iOS_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
###Safari iOS iPad
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${APPLE_IPAD} -Dbrowserstack.os_version=${iOS} -Dbrowserstack.browser="ipad" -Dbrowserstack.browser_version=${SAFARI_iOS_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${APPLE_IPAD} -Dbrowserstack.os_version=${iOS} -Dbrowserstack.browser="ipad" -Dbrowserstack.browser_version=${SAFARI_iOS_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
###Chrome iPhone
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${APPLE_PHONE} -Dbrowserstack.os_version=${iOS} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${APPLE_PHONE} -Dbrowserstack.os_version=${iOS} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
###Chrome iPad
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${APPLE_IPAD} -Dbrowserstack.os_version=${iOS} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${APPLE_IPAD} -Dbrowserstack.os_version=${iOS} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'

#### Android ###
###Chrome Phone
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${ANDROID_PHONE} -Dbrowserstack.os_version=${ANDROID_VERSION} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} -Dbrowserstack.real_mobile=true 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${ANDROID_PHONE} -Dbrowserstack.os_version=${ANDROID_VERSION} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
###Chrome Tablet
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${ANDROID_TABLET} -Dbrowserstack.os_version=${ANDROID_VERSION} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${ANDROID_TABLET} -Dbrowserstack.os_version=${ANDROID_VERSION} -Dbrowserstack.browser="Chrome" -Dbrowserstack.browser_version=${CHROME_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
###Samsung Internet Phone
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${ANDROID_PHONE} -Dbrowserstack.os_version=${ANDROID_VERSION} -Dbrowserstack.browser="android" -Dbrowserstack.browser_version=${SAMSUNG_INTERNET_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${ANDROID_PHONE} -Dbrowserstack.os_version=${ANDROID_VERSION} -Dbrowserstack.browser="android" -Dbrowserstack.browser_version=${SAMSUNG_INTERNET_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
###Samsung Internet Tablet
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${HISTORY} -Dbrowserstack.os=${ANDROID_TABLET} -Dbrowserstack.os_version=${ANDROID_VERSION} -Dbrowserstack.browser="android" -Dbrowserstack.browser_version=${SAMSUNG_INTERNET_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeHistoryRunner'
#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.project=${PROJECT_NAME} -Dbrowserstack.build=${PROJECT_NAME}" "${DATE} -Dbrowserstack.name=${JOURNEY} -Dbrowserstack.os=${ANDROID_TABLET} -Dbrowserstack.os_version=${ANDROID_VERSION} -Dbrowserstack.browser="android" -Dbrowserstack.browser_version=${SAMSUNG_INTERNET_VERSION} 'testOnly uk.gov.hmrc.test.ui.runner.SmokeJourneyRunner'
#

killall BrowserStackLocal
