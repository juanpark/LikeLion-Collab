#!/bin/bash

SHARD_BASE=~/mongodb
LOG_DIR=~/mongodb/log

echo "Starting shard servers..."

mongod --shardsvr --replSet RS --dbpath "$SHARD_BASE/mydata01" --port 27030 --logpath "$LOG_DIR/shard1.log" --fork
mongod --shardsvr --replSet RS --dbpath "$SHARD_BASE/mydata02" --port 27031 --logpath "$LOG_DIR/shard2.log" --fork
mongod --shardsvr --replSet RS --dbpath "$SHARD_BASE/mydata03" --port 27032 --logpath "$LOG_DIR/shard3.log" --fork

echo "Shard servers started."
