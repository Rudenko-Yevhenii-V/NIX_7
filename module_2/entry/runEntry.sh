#!/bin/bash
echo "entry"
mvn -f pom.xml clean install -U
java -jar target/appEntry.jar

