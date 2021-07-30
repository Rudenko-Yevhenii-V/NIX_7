cd console
call javac -sourcepath ./src -d out -cp ./libs/reversestring.jar;. src/nix/ry/rudenko/Main.java
call java -cp out;./libs/reversestring.jar;. src/nix/ry/rudenko/Main
cd ../
PAUSE

