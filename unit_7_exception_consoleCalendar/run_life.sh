#!/bin/bash

mvn clean install -Plife -DskipTests
java -jar target/unit_7_exception_consoleCalendar.jar

