#!/bin/bash

SHARD_BASE=~/mongodb
LOG_DIR=~/mongodb/log

echo "Starting RS2 shard servers..."

mongod --shardsvr --replSet RS2 --dbpath "$SHARD_BASE/mydata04" --port 27040 --logpath "$LOG_DIR/shard4.log" --fork
mongod --shardsvr --replSet RS2 --dbpath "$SHARD_BASE/mydata05" --port 27041 --logpath "$LOG_DIR/shard5.log" --fork
mongod --shardsvr --replSet RS2 --dbpath "$SHARD_BASE/mydata06" --port 27042 --logpath "$LOG_DIR/shard6.log" --fork

echo "RS2 shard servers started."
