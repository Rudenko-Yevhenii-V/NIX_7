#!/bin/bash
mvn clean install -Plife -DskipTests
java -jar target/unit_9_ionio.jar

