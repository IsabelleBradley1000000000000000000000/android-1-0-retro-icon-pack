#!/usr/bin/env sh

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

APP_HOME=`pwd`

exec java -jar "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" "$@"
