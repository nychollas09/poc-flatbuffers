#!/bin/bash

FINAL_BUILD_PATH=./infrastructure/src/main/java

rm -rf ./infrastructure/src/main/java/com/flatbuffers/poc/infrastructure/fbs/*

flatc --java -o $FINAL_BUILD_PATH ./infrastructure/fbs/*.fbs