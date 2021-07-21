#!/bin/sh
mvn -f pom.xml clean install -U
java -jar target/app.jar