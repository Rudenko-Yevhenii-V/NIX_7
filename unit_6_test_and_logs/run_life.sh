#!/bin/bash
mvn clean install -Plife -DskipTests
java -jar target/unit_6_test_and_logs.jar

