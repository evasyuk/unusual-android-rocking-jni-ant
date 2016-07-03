#!/usr/bin/env bash
#
# this script is intend to automize routine of creating file header
#   with main aim of avoiding errors

SCRIPT_PATH=`pwd -P`

SUBMODULE="submodule"

SRC_PATH="${SCRIPT_PATH}/src"
HEADER_OUTPUT_PATH="${SCRIPT_PATH}/jni/submodule1/${SUBMODULE}.h"

echo "generate_jni_headers"
echo ""
echo "SCRIPT_PATH IS ${SCRIPT_PATH}"
echo "SRC_PATH IS ${SRC_PATH}"
echo "HEADER_OUTPUT_PATH IS ${HEADER_OUTPUT_PATH}"
echo ""

echo "create directory[${SCRIPT_PATH}/jni/headers_st] if not exists.."
mkdir -p $SRC_PATH

#######################################
# javac
#echo "compile"
#start=`date +%s`
#end=`date +%s`

#javac -d obj src/com/jv/example/RockingJNI/FileDumper.java

#runtime=$((end-start))
#echo "done in ${runtime}"
# javac
#######################################

#######################################
# javah
echo "executing javah..."
start=`date +%s`
javah -jni -classpath $SRC_PATH -o $HEADER_OUTPUT_PATH com.jv.example.RockingJNI.FileDumper
end=`date +%s`

runtime=$((end-start))
echo "done in ${runtime} second(s)"
# javah
#######################################