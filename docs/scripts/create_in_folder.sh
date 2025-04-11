#!/bin/bash

BASE_DIR="$1"

# If no argument is provided, print usage
if [ -z "$BASE_DIR" ]; then
    echo "❗ Usage: $0 /path/to/target-folder"
    exit 1
fi

for dir in "$BASE_DIR"/*/; do
    if [ -d "$dir" ]; then
        if [ ! -f "$dir/README.md" ]; then
            FOLDER_NAME=$(basename "$dir")
            echo "# $FOLDER_NAME" > "$dir/README.md"
            echo "✅ Created README.md in $dir"
        else
            echo "⚠️  README.md already exists in $dir — skipped"
        fi
    fi
done
