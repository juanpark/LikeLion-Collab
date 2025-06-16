#!/bin/bash

CONFIG_BASE=~/mongodb
LOG_DIR=~/mongodb/log

echo "Starting config servers..."

mongod --configsvr --replSet CRS --dbpath "$CONFIG_BASE/mongoc1" --port 27011 --logpath "$LOG_DIR/mongoc1.log" --fork
mongod --configsvr --replSet CRS --dbpath "$CONFIG_BASE/mongoc2" --port 27012 --logpath "$LOG_DIR/mongoc2.log" --fork
mongod --configsvr --replSet CRS --dbpath "$CONFIG_BASE/mongoc3" --port 27013 --logpath "$LOG_DIR/mongoc3.log" --fork

echo "Config servers started."
