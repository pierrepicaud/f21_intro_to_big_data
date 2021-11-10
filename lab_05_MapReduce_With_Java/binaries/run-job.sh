#!/bin/bash

echo "Running modified WordCount Job"
HADOOP_USER_NAME=vagrant hadoop jar WordCount.jar WordCount alice.txt output
echo $(hdfs dfs -cat output/part-r-00000) >> WordCountResult.txt
mv WordCountResult.txt ..


echo "Running Sort Job"
HADOOP_USER_NAME=vagrant hadoop jar WordCount_sortByFreq.jar WordCount_sortByFreq output/part-r-00000 sort-out
echo $(hdfs dfs -cat sort-out/part-r-00000) >> WordCount_sortByFreqResult.txt
mv WordCount_sortByFreqResult.txt ..
