#!/bin/sh
echo "Please, enter:1 CONSOLE 2 ANT 3 MAVEN"
read   n
if [ $n == 1 ]
then
cd console
sh STARTERall.sh
elif [ $n == 2 ]
then
cd ant/ant_compile
sh startAnt.sh
elif [ $n == 3 ]
then
cd maven
sh startMaven.sh
else
   echo "not one two three!!!"
fi






