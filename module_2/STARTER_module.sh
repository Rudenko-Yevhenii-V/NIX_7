#!/bin/sh

# shellcheck disable=SC2164
cd findFirstUniqueName/
sh runfind.sh
cd ../
cd mostProfitableWay/
sh runWay.sh
cd ../
cd returnListOfDates/
sh runDates.sh
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo ""
echo "Please, enter:1 for web interface or 2 for console"
read n
if [ $n -eq '1' ]
then
	echo "for exit CTRL + C!!!!"
	echo  "web app on port 8088     http://localhost:8088/"
	sleep 6
cd ../
cd webShow/
sh runWeb.sh
echo "PAUSE 10 sec"
sleep 10
elif [ $n -eq '2' ]
then
	echo "two  - $n!!!"
cd ../
cd entry/
sh runEntry.sh
echo "PAUSE 10 sec"
sleep 10
else
   echo "not one two  - $n!!!"
fi
printf ''
read _