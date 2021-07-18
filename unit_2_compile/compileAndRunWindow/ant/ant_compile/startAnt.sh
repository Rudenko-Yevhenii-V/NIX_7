#!/bin/sh
rm -r build/classes
rm -r build/jar
sh setantenv.sh

ant clean
ant compile
ant jar
ant run

ant clean compile jar run