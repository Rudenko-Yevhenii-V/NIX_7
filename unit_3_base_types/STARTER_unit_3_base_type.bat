chcp 1251
echo "FOR COLORFUL DISPLAY RUN SHELL!!!!"
PAUSE
call mvn  clean install
call java -jar target/app.jar
PAUSE
