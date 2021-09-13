#!/bin/sh

# shellcheck disable=SC2164
cd findFirstUniqueName/
sh runfind.sh
cd ../
cd entry/
sh runEntry.sh
#mvn -f pom.xml clean install -U
#java -jar target/app.jar
printf 'press [ENTER] to continue...'
read _