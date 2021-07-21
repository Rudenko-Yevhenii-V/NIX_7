echo "START"
call mvn clean package
call java -jar target/app.jar
pause


