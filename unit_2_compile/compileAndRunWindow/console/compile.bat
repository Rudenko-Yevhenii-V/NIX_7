
mkdir out
#javac -d out -cp libs/commons-math3-3.6.1.jar:libs/MyLibForUnit2Compile-1.0.jar:libs/poi-5.0.0.jar  -sourcepath ./src src/nix/ry/rudenko/rOffice/RyExel.java src/nix/ry/rudenko/generators/GeneratorRandom.java src/nix/ry/rudenko/Main.java


call javac -sourcepath ./src -d out -cp ./libs/commons-math3-3.6.1.jar;./libs/MyLibForUnit2Compile-1.0.jar;./libs/MyLibForUnit2Compile-1.0.jar:libs/poi-5.0.0.jar;. src/nix/ry/rudenko/rOffice/RyExel.java src/nix/ry/rudenko/generators/GeneratorRandom.java src/nix/ry/rudenko/Main.java
#call java -cp build/classes;./libs/commons-lang3-3.11.jar;./libs/commons-math3-3.6.1. ua.com.alevel.Main