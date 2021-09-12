#!/bin/bash
mvn clean install -Plife -DskipTests
java -jar target/app.jar

