#!/bin/bash

mkdir -p mysql/data
mkdir -p mysql/conf
mkdir -p mysql/logs

docker run -v "$PWD/mysql/data":/var/lib/mysql \
           -v "$PWD/mysql/conf":/etc/mysql  \
           -v "$PWD/mysql/logs":/var/log  \
           --user 1000:1000 \
           --name "$1" \
           -p "$2":3306\
           -e MYSQL_ROOT_PASSWORD="$3" \
           -d mysql:5.7.29
