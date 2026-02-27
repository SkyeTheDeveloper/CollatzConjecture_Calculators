#!/usr/bin/env bash

clear
readonly MAX_INT=$((2**63 - 1))
declare collatz
steps=0
readonly COLLATZ_FILE="Shell-CollatzFile.txt"

while true; do
    printf 'What number would you like to run through the Collatz Conjecture: '
    read -r collatz
    if [[ ! "$collatz" =~ ^[+-]?[0-9]+$ ]]; then
        echo "ERR: Input is not a number"
        exit 1
    elif (( collatz < 1 )); then
        echo "The Collatz Conjecture has strange and emergent behavior with numbers less than one."
        collatz=0
    else
        break
    fi
done

readonly START=$collatz
peak=$collatz
echo "Start: $START" > "$COLLATZ_FILE"

while (( collatz > 1 )); do
    ((steps++))
    if (( collatz % 2 == 0 )); then
        ((collatz /= 2))
    else
        if (( collatz > (MAX_INT - 1) / 3 )); then
            printf '%s overflowed on step %s\nExiting...\n' "$START" "$steps"
            exit 1
        else
            ((collatz=collatz * 3 + 1))
            if (( collatz > peak)); then
                peak=$collatz
            fi
        fi
    fi
    echo "Step $steps: $collatz" >> "$COLLATZ_FILE"
done

printf '%s reached 1 in %s steps\nIts peak was %s\n\nFull path is in the file "%s"\n' "$START" "$steps" "$peak" "$COLLATZ_FILE"
printf '%s reached 1 in %s steps\nIts peak was %s' "$START" "$steps" "$peak" >> "$COLLATZ_FILE"
