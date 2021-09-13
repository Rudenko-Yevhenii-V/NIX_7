#!/bin/bash
echo "FindFirstUniqueName"
mvn -f pom.xml clean install -U
java -jar target/appFirst.jar

