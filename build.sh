#!/usr/bin/env bash

# SPDX-License-Identifier: CC0-1.0
#
# Written in 2026 by Skylar Koningin
#
# To the extent possible under law, the author(s) have dedicated all 
# copyright and related and neighboring rights to this software to 
# the public domain worldwide. This software is distributed without 
# any warranty.
#
# You should have received a copy of the CC0 Public Domain Dedication 
# along with this software. If not, see:
# http://creativecommons.org/publicdomain/zero/1.0/

# Script Dependency Check
package_exists() {
  command -v "$1" >/dev/null 2>&1
}
dependencies=("clang" "dotnet" "flang" "go" "java" "kotlin" "cargo")
missing_dependencies=0
declare -a missing
for dependency in "${dependencies[@]}"; do
    if ! package_exists "$dependency"; then
        missing_dependencies=1
        missing+="$dependency"
    fi
done
if [[ "$missing_dependencies" == 1 ]]; then
    printf "You are missing " && printf "%s, " "${missing[@]}" && printf "please install all missing packages."
    exit 1
fi

# Folder Creation
mkdir -p build
cd build
rm -rf ./*
for name in Bash C CXX CSharp Fortran Go Java JavaScript Kotlin Python Ruby Rust TypeScript; do
    mkdir -p "$name"
done
cd ..

# Bash Compilation
cp NonArbitrary_Precision/Bash/collatz_calculator.sh build/Bash

# C Compilation
cd NonArbitrary_Precision/C
clang -o ../../build/C/C-CollatzCalculator *.c
cd ../..

# C++ Compilation
cd NonArbitrary_Precision/CXX
clang++ -o ../../build/CXX/CXX-CollatzCalculator *.cpp
cd ../..

# CSharp Compilation
cd Arbitrary_Precision/CSharp/
dotnet publish --sc -o ../../build/CSharp -p:PublishSingleFile=true
rm -r bin obj
cd ../../build/CSharp
rm *.pdb
cd ../..

#Fortran Compilation
cd NonArbitrary_Precision/Fortran
flang -o ../../build/Fortran/Fortran-CollatzCalculator *.f95
cd ../..

# Go Compilation
cd Arbitrary_Precision/Go/
go build -o ../../build/Go/Go-CollatzCalculator
cd ../..

# Java Compilation
cd Arbitrary_Precision/Java/
javac -J-Xmx512m -J-Xms512m -d ../../build/Java/class *.java
cd ../../build/Java/class
jar -J-Xmx512m -J-Xms512m -cvfm ../Java-CollatzCalculator.jar ../../../Arbitrary_Precision/Java/META-INF/MANIFEST.MF *.class
cd ../../..

# JavaScript Compilation
cp Arbitrary_Precision/JavaScript/collatz-calculator.js Arbitrary_Precision/JavaScript/cc-extras.mjs build/JavaScript

# Kotlin Compilation
cd Arbitrary_Precision/Kotlin/
kotlinc -include-runtime -d ../../build/Kotlin/Kotlin-CollatzCalculator.jar *.kt
cd ../..

# Python Compilation
cp Arbitrary_Precision/Python/collatz_calculator.py build/Python

# Ruby Compilation
cp Arbitrary_Precision/Ruby/collatz_calculator.rb Arbitrary_Precision/Ruby/cc_extras.rb build/Ruby

# Rust Compilation
cd NonArbitrary_Precision/Rust
cargo clean
cargo build --release
cd target/release
cp Rust-CollatzCalculator ../../../../build/Rust
cd ../../../..

# TypeScript Compilation
cp Arbitrary_Precision/TypeScript/src/collatz-calculator.ts Arbitrary_Precision/TypeScript/src/cc-extras.mts build/TypeScript