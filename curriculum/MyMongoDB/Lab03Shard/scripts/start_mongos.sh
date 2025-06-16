#!/bin/bash

LOG_DIR=~/mongodb/log

echo "Starting mongos router..."

mongos --configdb CRS/localhost:27011,localhost:27012,localhost:27013 \
       --port 27021 \
       --bind_ip localhost \
       --logpath "$LOG_DIR/mongos.log" \
       --fork

echo "Mongos started."
