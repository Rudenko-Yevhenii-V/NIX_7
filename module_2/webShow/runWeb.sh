#!/bin/bash
echo "WEB"
mvn clean package
java -jar target/appMain.jar

