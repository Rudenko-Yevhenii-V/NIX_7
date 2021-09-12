#!/bin/bash
# shellcheck disable=SC2164
cd ../unit_9_NIXson_lib/
sh run_life.sh
# shellcheck disable=SC2164
cd ../unit_9_ionio/
sh run_test.sh
sh run_life.sh
printf 'press [ENTER] to continue...'
read _