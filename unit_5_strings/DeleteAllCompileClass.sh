#!/bin/sh

find . -name "*.class" -type f -print0 | xargs -0 /bin/rm -f
rm ./files/*.xls
rm -r out