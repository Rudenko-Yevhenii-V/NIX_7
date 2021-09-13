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
cd ../
cd entry/
sh runEntry.sh
printf 'press [ENTER] to continue...'
read _