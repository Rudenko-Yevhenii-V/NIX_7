
call javac -sourcepath ./src -d out -cp ./libs/commons-math3-3.6.1.jar;./libs/MyLibForUnit2Compile-1.0.jar;./libs/poi-5.0.0.jar;. src/nix/ry/rudenko/rOffice/RyExel.java src/nix/ry/rudenko/generators/GeneratorRandom.java src/nix/ry/rudenko/Main.java
call java -cp out;./libs/commons-math3-3.6.1.jar;./libs/MyLibForUnit2Compile-1.0.jar;./libs/poi-5.0.0.jar;. src/nix/ry/rudenko/Main
PAUSE