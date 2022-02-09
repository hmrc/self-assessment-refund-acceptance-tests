#!/bin/sh
# Run BrowserStackLocal
if ! sh run_dependencies.sh; then
    echo "Failed to start BrowserStack"
    exit 1
fi

browserStackUsername="hmrcteampayments1"
browserStackAutomateKey="M9JhEVpAdz7tKazSJTLN"

sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="86" -Dbrowserstack.browser="Edge" 'testOnly uk.gov.hmrc.test.ui.runner.A11yRunner'
#sbt -Dbrowser=browserstack -Dlanguage=english -Denvironment=local -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browserName="android" -Dbrowserstack.device="Samsung Galaxy S20" -Dbrowserstack.realMobile="true" -Dbrowserstack.os_version="10.0" 'testOnly Suites.RunCrossBrowser'

#sbt -Dbrowser=browserstack -Denvironment=local -Dbrowserstack.project="PAS" -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browser_version="13.1" -Dbrowserstack.browser="Safari" -Dos="OS X" -Dos_version="Catalina" -Dbrowserstack.idleTimeout="120" -Dbrowserstack.selenium_version="3.14.0" 'testOnly Suites.RunWip'
#sbt -Dbrowser=browserstack -Dbrowserstack.project="PAS" -Denvironment=local -Dforcelocal="true" -Dbrowserstack.local="true" -Dbrowserstack.debug="true" -Dbrowserstack.username=${browserStackUsername} -Dbrowserstack.key=${browserStackAutomateKey} -Dbrowserstack.browserName="safari" -Dbrowserstack.device="iPhone 11 Pro" -Dbrowserstack.real_mobile="true" -Dbrowserstack.os_version="13" 'testOnly Suites.RunWip'

killall BrowserStackLocal