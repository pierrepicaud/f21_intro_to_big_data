#!/bin/bash

sudo clear
stop-yarn.sh
stop-dfs.sh
sleep .5
start-dfs.sh
sleep .5
hdfs dfsadmin -report
start-yarn.sh
sleep 3
yarn node -list


