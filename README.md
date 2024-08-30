
# self-assessment-refund-acceptance-tests

### This is the acceptance test suite for online payments Income Tax Self-Assessment (self-assessment-refund) service.

## Running the tests

Prior to executing the tests ensure you have the appropriate [drivers installed](#installing-local-driver-binaries), install [MongoDB](https://docs.mongodb.com/manual/installation/) and install/configure [service manager](https://github.com/hmrc/service-manager).  

Run the following command to start services locally:

    sudo mongod
    sm --start SELF_ASSESSMENT_REFUND
    
All tests are run against dockerised environments.

Execute the `run_tests.sh` script in the self-assessment-refund-acceptance-tests repo:

    ./run_tests.sh <environment> <browser-driver>

The `run_tests.sh` script defaults to the `local` environment with the dockerised `chrome` browser.


