#!/bin/sh

find . -name "*.class" -type f -print0 | xargs -0 /bin/rm -f
rm ./files/*.xls
rm -r "*target"
# shellcheck disable=SC2185
find . -name "target" -type d -prune -exec rm -rf '{}' +
