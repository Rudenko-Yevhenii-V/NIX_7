#!/bin/bash
mvn -f pom.xml clean install -U
java -jar target/unit_7_exception_consoleCalendar.jar
printf 'press [ENTER] to continue...'
read _