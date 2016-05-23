#!/usr/bin/env bash

OLD_DIR=${PWD}
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd $DIR

#build sparkloggerparser
cd sparkloggerparser
mvn clean package -Dmaven.test.skip=true

#build performance-estimator
cd ../performance-estimator
mvn install

#restore dir
cd $OLD_DIR