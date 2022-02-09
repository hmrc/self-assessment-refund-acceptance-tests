#!/bin/sh

echo $browserStackAutomateKey

echo "BrowserStackLocal instances:"
pidof BrowserStackLocal

if pidof BrowserStackLocal; then
  echo "BrowserStackLocal running already"
  fi
else
    echo "None, starting BrowserStack"
    if [ ! -e BrowserStackLocal ]; then
        echo "Downloading BrowserStackLocal"
        curl -O https://www.browserstack.com/browserstack-local/BrowserStackLocal-darwin-x64.zip
        unzip BrowserStackLocal-darwin-x64.zip
        rm BrowserStackLocal-darwin-x64.zip
    fi
    file="./src/test/resources/browserStackConfig.properties"
    if [ -f "$file" ]
    then
        echo "***********File : $file found ***************."
        . ./src/test/resources/browserStackConfig.properties
        echo $browserStackAutomateKey
       ./BrowserStackLocal --key $browserStackAutomateKey
        echo "BSServer started in local"
        if ! pidof BrowserStackLocal; then
            echo "Could not connect. Please check your automate key"
        fi
    else
       echo "****************$file Not found ,Warning: Sorry BrowserStack wont work,provide a file with your credentials***************."
       exit 1
    fi
fi