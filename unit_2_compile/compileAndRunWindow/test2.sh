#!/bin/sh

n=2

if [ $n -eq '1' ]
then
	echo "one  - $n!!!"
cd console
sh STARTERall.shtest1.sh
elif [ $n -eq '2' ]
then
	echo "two  - $n!!!"
cd ant/ant_compile
sh startAnt.sh
elif [ $n -eq '3' ]
then
	echo " three - $n!!!"
cd maven
sh startMaven.sh
else
   echo "not one two three - $n!!!"
fi







