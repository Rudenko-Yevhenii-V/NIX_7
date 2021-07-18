#!/bin/sh
echo "Please, enter:1 for graphical interface or 2 for console"
read n
if [ $n -eq '1' ]
then
	echo "one  - $n!!!"
cd compileAndRunWindow
sh STARTERgui.sh
sleep 10
elif [ $n -eq '2' ]
then
	echo "two  - $n!!!"
cd compileAndRunWindow
sh STARTER.sh
echo "PAUSE 10 sec"
sleep 10
else
   echo "not one two  - $n!!!"
fi







