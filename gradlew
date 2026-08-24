#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a symlink
app_path=$0

# Need this for daisy-chained symlinks.
while
    APP_HOME=${app_path%"${app_path##*/}"}
    [ -h "$app_path" ]
do
    ls=$( ls -ld "$app_path" )
    link=${ls#*' -> '}
    case $link in
    /*) app_path=$link ;;
    *) app_path=$APP_HOME$link ;;
    esac
done

APP_HOME=$( cd "${APP_HOME}." && pwd -P ) || exit

app_name="Gradle"
app_jar_name=gradle-wrapper.jar
app_jar_path="$APP_HOME/gradle/wrapper/$app_jar_name"

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='" "-Xmx64m" "-Xms64m"'

# Use the maximum available, or set MAX_FD != maximum.
MAX_FD=maximum

warn () {
    echo "$*" >&2
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
darwin=false
nix=false
cygwin=false
msys=false
freebsd=false
case "$( uname )" in                #(
  Darwin* )         darwin=true  ;; #(
  Linux* )          nix=true     ;; #(
  CYGWIN* )         cygwin=true  ;; #(
  MSYS* )           msys=true    ;; #(
  FreeBSD* )        freebsd=true ;;
esac

if [ "$nix" = true ]; then
    PR_SET_DUMPABLE=1
fi

# For Cygwin or MSYS, switch paths to Windows format before running java
if [ "$cygwin" = true ] || [ "$msys" = true ] ; then
    APP_HOME=$( cygpath --path --mixed "$APP_HOME" )
    APP_JAR_PATH=$( cygpath --path --mixed "$app_jar_path" )
fi

# We build the pattern for arguments to be converted via cygpath
CONVERT_VAR_PATTERN="^-D(?:java|user)(?:\.|-_)(?:.*)\/(?:.*)$"

# Now convert the arguments - kludge to limit ourselves to /bin/sh
count=0
for arg in "$@" ; do
    CHECK=$( echo "$arg" | egrep -c "$CONVERT_VAR_PATTERN" ) 2>/dev/null
    CHECK2=$( echo "$arg" | egrep -c "^-" ) 2>/dev/null
    ( if [ $CHECK -ne 0 ] && [ $CHECK2 -eq 0 ] ; then
        arg=$( echo "$arg" | sed "s/^\(-D[^.]*\)[.\\-_]\(.*\)\/\(..*\)$/\1=\2:\3/g" )
    fi
    echo "$arg"
    done ) |
    tr '\n' ' ' | tr -d '\r'

# Trailing space matters for cmd.exe parser.
echo ""

exec "$JAVACMD" $JAVA_OPTS $GRADLE_OPTS -classpath "$app_jar_path" org.gradle.wrapper.GradleWrapperMain "$@"
