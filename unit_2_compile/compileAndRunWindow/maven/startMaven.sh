#!/bin/sh
rm ./src/main/resources/NIX7ExeleFile.xls
mvn -f pom.xml clean install -U
java -jar target/app.jar
