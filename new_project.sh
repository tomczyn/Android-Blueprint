#!/bin/bash

# exit when any command fails
set -e

if [[ $# -lt 2 ]]; then
   echo "Usage: ./new_project.sh my.new.package ApplicationName" >&2
   exit 2
fi

PACKAGE=$1
APPNAME=$2
SUBDIR=${PACKAGE//.//} # Replaces . with /

#app_dirs=("app/src/androidTest" "app/src/main" "app/src/test")
for n in $(find . -type d \( -path './app/src/androidTest' -or -path './app/src/main' -or -path './app/src/test' \) )
do
  echo "Creating $n/kotlin/$SUBDIR"
  mkdir -p $n/kotlin/$SUBDIR
  echo "Moving files to $n/kotlin/$SUBDIR"
  rm -rf $n/kotlin/$SUBDIR/*
  mv $n/kotlin/blueprint/* $n/kotlin/$SUBDIR
  echo "Removing old $n/kotlin/blueprint"
  rm -rf mv $n/kotlin/blueprint
done


# Rename package and imports
echo "Renaming packages to $PACKAGE"
find ./ -type f -name "*.kt" -exec sed -i.bak "s/package blueprint/package $PACKAGE/g" {} \;
find ./ -type f -name "*.kt" -exec sed -i.bak "s/import blueprint/import $PACKAGE/g" {} \;
find ./ -type f -name "*.kt" -exec sed -i.bak "s/BlueprintApp/${APPNAME}App/g" {} \;
find ./ -name "BlueprintApp.kt" | sed "p;s/BlueprintApp/${APPNAME}App/" | tr '\n' '\0' | xargs -0 -n 2 mv
find ./ -type f -name "*.kt" -exec sed -i.bak "s/BlueprintTheme/${APPNAME}Theme/g" {} \;
find ./ -type f -name "*.kt" -exec sed -i.bak "s/BlueprintNavHost/${APPNAME}NavHost/g" {} \;
find ./ -name "BlueprintNavHost.kt" | sed "p;s/BlueprintNavHost/${APPNAME}NavHost/" | tr '\n' '\0' | xargs -0 -n 2 mv
find ./ -type f -name "*.kt" -exec sed -i.bak "s/BlueprintFlavor/${APPNAME}Flavor/g" {} \;
find ./ -name "BlueprintFlavor.kt" | sed "p;s/BlueprintFlavor/${APPNAME}Flavor/" | tr '\n' '\0' | xargs -0 -n 2 mv
find ./ -type f -name "*.kt" -exec sed -i.bak "s/BlueprintBuildType/${APPNAME}BuildType/g" {} \;
find ./ -name "BlueprintBuildType.kt" | sed "p;s/BlueprintBuildType/${APPNAME}BuildType/" | tr '\n' '\0' | xargs -0 -n 2 mv

# Gradle files
find ./ -type f -name "*.kts" -exec sed -i.bak "s/blueprint/$PACKAGE/g" {} \;
find ./ -type f -name "*.kts" -exec sed -i.bak "s/Blueprint/$APPNAME/g" {} \;
find ./ -type f -name "*.kt" -exec sed -i.bak "s/blueprint/$PACKAGE/g" {} \;
find ./ -type f -name "*.xml" -exec sed -i.bak "s/BlueprintApp/${APPNAME}App/g" {} \;
find ./ -type f -name "*.xml" -exec sed -i.bak "s/blueprint./${PACKAGE}./g" {} \;
find ./ -type f -name "*.xml" -exec sed -i.bak "s/Blueprint/$APPNAME/g" {} \;


echo "Cleaning up"
find . -name "*.bak" -type f -delete
rm -rf LICENSE README.md new_project.sh
rm -rf .git/
git init
git add --all
git commit -m 'init'
git tag -a 1.0 -m 'v1.0'

echo "Done!"
