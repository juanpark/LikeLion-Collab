#!/bin/bash

BASE_DIR="."

for dir in "$BASE_DIR"/*/; do
    if [ -d "$dir" ]; then
        echo "# README" > "$dir/README.md"
        echo "README.md created in $dir"
    fi
done
