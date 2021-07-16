#!/bin/sh
echo 'hello compile'
find . -name "*.class" -type f -print0 | xargs -0 /bin/rm -f
rm ./files/*.xls
rm -r out
mkdir out
COMPILE="javac -d out -cp libs/commons-math3-3.6.1.jar:libs/MyLibForUnit2Compile-1.0.jar:libs/poi-5.0.0.jar  -sourcepath ./src src/nix/ry/rudenko/rOffice/RyExel.java src/nix/ry/rudenko/generators/GeneratorRandom.java src/nix/ry/rudenko/Main.java"
RUN="java -cp out:libs/commons-math3-3.6.1.jar:libs/MyLibForUnit2Compile-1.0.jar:libs/poi-5.0.0.jar src/nix/ry/rudenko/Main"

$COMPILE
$RUN

