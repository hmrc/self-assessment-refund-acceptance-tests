    file="./src/test/resources/browserstackdata/BS_Win7_IE_v11.json"
    if [ -f "$file" ]
    then
        echo "***********File : $file found ***************."
        . ./src/test/resources/browserstackdata/BS_Win7_IE_v11.json
        echo $file.browser
fi