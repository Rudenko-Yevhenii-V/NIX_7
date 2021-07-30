#!/bin/sh

mkdir out
COMPILE="javac -d out -cp libs/reversestring.jar  -sourcepath ./src  src/nix/ry/rudenko/Main.java"
RUN="java -cp out:libs/reversestring.jar src/nix/ry/rudenko/Main"

$COMPILE
$RUN

