#!/bin/bash
cd ../
mvn clean install -Plife -DskipTests
cd unit_6_test_and_logs/
java -jar target/unit_6_test_and_logs.jar

