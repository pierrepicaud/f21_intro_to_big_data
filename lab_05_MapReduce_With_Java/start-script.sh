#!/bin/bash

echo "Starting dfs"
start-dfs.sh
sleep 0.5
hdfs dfsadmin -report
sleep 0.5

echo "Starting yarn"
start-yarn.sh
sleep 1
yarn node -list

# echo "Removing /output/"
# hdfs dfs -rm -r /user/vagrant/output/

# echo "Running job"
# HADOOP_USER_NAME=vagrant hadoop jar /vagrant/binaries/WordCount.jar WordCount alice.txt output

