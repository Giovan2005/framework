#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SRC_DIR="$ROOT_DIR/src"
LIB_DIR="$ROOT_DIR/lib"
BUILD_DIR="$ROOT_DIR/build"
CLASS_DIR="$BUILD_DIR/classes"
DIST_DIR="$ROOT_DIR/dist"
JAR_NAME="framework.jar"

mkdir -p "$CLASS_DIR" "$DIST_DIR"

java_files=$(find "$SRC_DIR" -name '*.java' | sort)
if [[ -z "$java_files" ]]; then
  echo "Aucun fichier Java trouvé dans $SRC_DIR" >&2
  exit 1
fi

javac -d "$CLASS_DIR" -cp "$LIB_DIR/*" $java_files

jar cf "$DIST_DIR/$JAR_NAME" -C "$CLASS_DIR" .

echo "JAR généré : $DIST_DIR/$JAR_NAME"
