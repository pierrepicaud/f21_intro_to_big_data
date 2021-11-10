#!/bin/bash

javac  -cp $(hadoop classpath) $1
jar -cvf  $2 $3
