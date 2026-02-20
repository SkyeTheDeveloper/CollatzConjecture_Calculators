# Contributing to Collatz Conjecture Calculators

Thank you for your interest in contributing to this project! This guide will help you understand our coding standards and contribution process.

## Table of Contents
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Language-Specific Style Guides](#language-specific-style-guides)
- [General Guidelines](#general-guidelines)
- [Submission Process](#submission-process)

## Getting Started

This project contains implementations of the Collatz Conjecture calculator in multiple programming languages, divided into two categories:

- **64-bit Precision Implementations**: Using native 64-bit integer types with overflow checking
- **Arbitrary Precision Implementations**: Using BigInteger or equivalent libraries

Before contributing, please:
1. Read our [Code of Conduct](CODE_OF_CONDUCT.md)
2. Review the [README](README.md)
3. Familiarize yourself with the existing implementations in your target language

## Project Structure

```
CollatzConjecture_Calculators/
├── 64bitPrecision-Ints/
│   └── [Language]-Implementation/
└── ArbPrecision-Ints/
    └── [Language]-Implementation/
```

Each implementation should contain:
- Main calculator file
- Extras/utility file (for clear screen, file I/O, etc.)
- Output file named `CollatzFile.txt` (or language-specific variant)

## Language-Specific Style Guides

### C

**File Naming**: `snake_case` (e.g., `collatz_calculator.c`, `collatz_calculator.h`)

**Brace Style**: **C K&R (Kernighan & Ritchie)**
- Opening brace on same line for control structures (`if`, `while`, `for`, `do`)
- Function opening brace on same line (following project style)
- Closing brace on its own line
- **Never omit braces**, even for single-statement blocks

**Code Style**:
- Use `snake_case` for all identifiers
- Use header guards in `.h` files: `#ifndef FILENAME`, `#define FILENAME`
- Use `#define` for macros (e.g., clear screen function)
- Use `uint64_t` for 64-bit integers
- Include overflow checking for arithmetic operations
- Use `goto` for cleanup when appropriate (e.g., `exit_collatz:`)
- Use `fprintf` for file writing
- Check return values and file pointers for errors

**Example**:
```c
#ifndef COLLATZCALCULATOR
    #define COLLATZCALCULATOR
    
    #define clear() printf("\033[2J\033[H")
    
    #include <stdio.h>
    #include <stdlib.h>
    #include <stdint.h>
    #include <limits.h>

#endif

// In .c file:
int main()
{
    uint64_t collatz, peak;
    int steps = 0;
    FILE *collatz_file;
    
    if (collatz % 2 == 0) {
        collatz /= 2;
    } else {
        if (collatz > (ULLONG_MAX - 1) / 3) {
            printf("Overflow detected\n");
            goto exit_collatz;
        }
    }
    
    while (collatz > 1) {
        // processing
    }

exit_collatz:
    fclose(collatz_file);
    return EXIT_SUCCESS;
}
```

**Indentation**: 4 spaces

---

### C#

**File Naming**: `PascalCase` (e.g., `CollatzCalculator.cs`, `CCExtras.cs`)

**Brace Style**: **Allman Style** (also known as BSD style)
- Opening brace always on new line
- Closing brace on its own line, aligned with the statement that opened it
- This is the C# standard style
- **Never omit braces**, even for single-statement blocks

**Code Style**:
- Use `PascalCase` for class and namespace names
- Use `PascalCase` for public methods
- Use `camelCase` for local variables and parameters
- Use meaningful namespace names (e.g., `CollatzCalculatorExtras`)
- Use `BigInteger` from `System.Numerics`
- Use string interpolation with `$` prefix
- Use `Console.Clear()` for clearing screen
- Static utility classes should have `public static` methods
- Use `const` for compile-time constants

**Example**:
```csharp
using System;
using System.Numerics;
using CollatzCalculatorExtras;

class CollatzCalculator
{
    static void Main()
    {
        Console.Clear();
        BigInteger peak, collatz = 0;
        int steps = 0;
        const string collatzFile = "CollatzFile.txt";
        
        if (collatz % 2 == 0)
        {
            collatz /= 2;
        }
        else
        {
            collatz = (collatz * 3) + 1;
        }
        
        while (collatz > 1)
        {
            // processing
        }
        
        Console.WriteLine($"{start} reached 1 in {steps} steps");
    }
}

namespace CollatzCalculatorExtras
{
    public class CCExtras
    {
        public static void WriteToFile(string filePath, string text, bool append)
        {
            if (append)
            {
                File.AppendAllText(filePath, text);
            }
            else
            {
                File.WriteAllText(filePath, text);
            }
        }
    }
}
```

**Indentation**: 4 spaces

---

### Go

**File Naming**: `snake_case` (e.g., `collatz_calculator.go`, `cc_extras.go`)

**Brace Style**: **Go Standard** (enforced by `gofmt`)
- Opening brace must be on same line (will not compile otherwise)
- Closing brace on its own line
- No choice in this - Go enforces this style
- **Never omit braces**, even for single-statement blocks

**Code Style**:
- Use `camelCase` for local variables
- Use `PascalCase` for exported functions (e.g., `Clear`, `WriteToFile`)
- All files in `package main`
- Use `big.Int` for arbitrary precision
- Always check errors from I/O operations
- Use `defer` for cleanup operations
- Use `fmt.Sprintf` for string formatting
- Declare zero values explicitly when appropriate
- Follow `gofmt` and `golint` standards

**Example**:
```go
package main

import (
	"fmt"
	"log"
	"math/big"
	"os"
)

func Clear() {
	fmt.Print("\033[H\033[2J")
}

func WriteToFile(filePath string, text string, append bool) {
	flags := os.O_CREATE | os.O_WRONLY
	if append {
		flags |= os.O_APPEND
	} else {
		flags |= os.O_TRUNC
	}
	
	f, err := os.OpenFile(filePath, flags, 0644)
	if err != nil {
		log.Fatal(err)
	}
	defer f.Close()
}

func main() {
	Clear()
	one := big.NewInt(1)
	collatz := big.NewInt(0)
	steps := int(0)
	const collatzFile = "Go-CollatzFile.txt"
	
	for ok := true; ok; ok = (collatz.Cmp(one) > 0) {
		// processing
	}
}
```

**Indentation**: Tabs (Go standard, enforced by `gofmt`)

---

### Java

**File Naming**: `PascalCase` for class files (e.g., `CollatzCalculator.java`, `CCExtras.java`)

**Brace Style**: **Egyptian K&R / 1TBS (One True Brace Style)**
- Opening brace on same line for everything (classes, methods, control structures)
- Closing brace on its own line
- This differs from C K&R where function braces go on new lines
- **Never omit braces**, even for single-statement blocks

**Code Style**:
- Use `PascalCase` for class names
- Use `camelCase` for variables and methods
- Leading space before imports (aesthetic preference in this project)
- Use `BigInteger` for arbitrary precision
- Use `Scanner` for console input
- Use `Path` and `Files` for file operations
- Empty line after class declaration before first method

**Example**:
```java
 import java.util.Scanner;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.math.BigInteger;
 
 class CollatzCalculator {
     
     public static void main(String[] args) {
         BigInteger collatz, peak;
         int steps = 0;
         final Path collatzFile = Paths.get("CollatzFile.txt");
         Scanner input = new Scanner(System.in);
         
         if (collatz.compareTo(BigInteger.ONE) > 0) {
             // process
         }
         
         while (collatz.compareTo(BigInteger.ONE) > 0) {
             if (collatz.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                 collatz = collatz.divide(BigInteger.TWO);
             } else {
                 collatz = collatz.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
             }
         }
         
         input.close();
     }
 }
```

**Indentation**: 4 spaces

---

### Kotlin

**File Naming**: `PascalCase` (e.g., `CollatzCalculator.kt`, `CCExtras.kt`)

**Brace Style**: **Egyptian K&R / 1TBS (One True Brace Style)**
- Opening brace on same line for functions and control structures
- Closing brace on its own line
- Follows Kotlin coding conventions
- **Never omit braces**, even for single-statement blocks

**Code Style**:
- Use `camelCase` for variables and function names
- Use `PascalCase` for class names
- Use `val` for immutable values, `var` for mutable
- Use string templates with `$` for simple variables, `${}` for expressions
- No semicolons at end of lines
- Use `BigInteger` from Java interop
- Top-level functions are acceptable (no need for class wrapper)
- Prefer concise, idiomatic Kotlin syntax
- Use Kotlin operators with BigInteger (converted via operator overloading)

**Example**:
```kotlin
import java.math.BigInteger
import java.io.File

fun main() {
    clear()
    var collatz = BigInteger.ZERO
    var peak = collatz
    var steps = 0
    val collatzFile = "CollatzFile.txt"
    
    while (collatz > BigInteger.ONE) {
        if (collatz % BigInteger.TWO == BigInteger.ZERO) {
            collatz /= BigInteger.TWO
        } else {
            collatz = collatz * (BigInteger.TWO + BigInteger.ONE) + BigInteger.ONE
            if (collatz > peak) {
                peak = collatz
            }
        }
        writeToFile(collatzFile, "Step ${++steps}: $collatz \n", true)
    }
    
    println("$start reached 1 in $steps steps\nIts peak was $peak")
}

fun clear() {
    print("\u001b[H\u001b[2J")
    System.out.flush()
}

fun writeToFile(path: String, text: String, append: Boolean) {
    if (append) {
        File(path).appendText(text)
    } else {
        File(path).writeText(text)
    }
}
```

**Indentation**: 4 spaces

---

### Python

**File Naming**: `snake_case` (e.g., `collatz_calculator.py`, `cc_extras.py`)

**Brace Style**: N/A (Python uses indentation instead of braces)
- Use colon (`:`) to start blocks
- Indentation defines block scope
- Follow PEP 8 standards

**Code Style**:
- Use `snake_case` for variables, functions, and module names
- No type hints required (keep it simple)
- Use f-strings for string formatting
- Import modules at the top of the file
- Use context managers (`with` statement) for file operations
- Keep code simple and readable
- Use floor division `//` for integer division
- Multiple assignment on one line is acceptable (e.g., `collatz = start = peak = 0`)

**Example**:
```python
import cc_extras

def clear():
    print("\x1b[H\x1b[2J", end="", flush=True)

cc_extras.clear()
collatz = start = peak = steps = 0
file_path = "CollatzFile.txt"

with open(file_path, "w") as file:
    while True:
        collatz = int(input("What number would you like to run through the Collatz Conjecture: "))
        if (collatz != 1):
            if (collatz < 1):
                collatz = 0
                print("The Collatz Conjecture has strange and emergent behavior with numbers less than 1")
            else:
                break
    
    start = peak = collatz
    file.write(f"Start: {start}\n")
    
    while collatz > 1:
        if collatz % 2 == 0:
            collatz //= 2
        else:
            collatz = collatz * 3 + 1
            if collatz > peak:
                peak = collatz
        steps += 1
        file.write(f"Step {steps}: {collatz}\n")
```

**Indentation**: 4 spaces (PEP 8 standard)

---

### Ruby

**File Naming**: `snake_case` (e.g., `collatz_calculator.rb`, `cc_extras.rb`)

**Brace Style**: **Ruby Standard**
- Use `do...end` for multi-line blocks
- Use `{...}` for single-line blocks
- Control structures use `end` keyword (no braces)
- Modules and classes also use `end` keyword

**Code Style**:
- Include `# frozen_string_literal: true` at the top of files
- Use `snake_case` for all identifiers
- Use `Module` for utility collections (e.g., `CCExtras`)
- Use `def self.method_name` for module/class methods
- Use string interpolation with `#{}`
- Predicate methods end with `?` (e.g., `.even?`)
- Use `.freeze` for truly immutable values
- Method calls can omit parentheses when unambiguous
- Use idiomatic Ruby methods (e.g., `gets.to_i`, `.even?`)
- Control structure modifiers for simple conditions (e.g., `peak = collatz if collatz > peak`)

**Example**:
```ruby
# frozen_string_literal: true

require_relative 'cc_extras'

module CCExtras
  def self.clear
    print "\x1b[H\x1b[2J"
    $stdout.flush
  end

  def self.write_to_file(file_path, text, append)
    if append
      File.write file_path, text, mode: 'a'
    else
      File.write file_path, text
    end
  end
end

CCExtras.clear
collatz = steps = 0
collatz_file = 'CollatzFile.txt'

loop do
  print 'What number would you like to run through the Collatz Conjecture: '
  collatz = gets.to_i
  if collatz != 1
    break unless collatz < 1
    
    puts 'The Collatz Conjecture has strange and emergent behavior with numbers less than 1'
  end
  next
end

peak = collatz
start = collatz.freeze
CCExtras.write_to_file collatz_file, "Start: #{start}\n", false

while collatz > 1
  if collatz.even?
    collatz /= 2
  else
    collatz = collatz * 3 + 1
    peak = collatz if collatz > peak
  end
  CCExtras.write_to_file collatz_file, "Step #{steps += 1}: #{collatz}\n", true
end

puts "#{start} reached 1 in #{steps} steps\
\nIts peak was #{peak}\
\n\nFull path is in the file named \"CollatzFile.txt\"\n"
```

**Indentation**: 2 spaces (Ruby standard)

---

## General Guidelines

### All Implementations Must Include

1. **User Input**: Prompt for a number to run through the Collatz Conjecture
2. **Input Validation**: Reject numbers less than 1 with the message: "The Collatz Conjecture has strange and emergent behavior with numbers less than 1"
3. **Algorithm Implementation**:
   - If even: divide by 2
   - If odd: multiply by 3 and add 1
4. **Peak Tracking**: Track the highest value reached during calculation
5. **Step Counting**: Count iterations until reaching 1
6. **File Output**: Write full calculation path to `CollatzFile.txt` (or language-specific variant)
7. **Console Output**: Display start number, steps taken, and peak value
8. **Utility Functions**: 
   - Screen clearing function
   - File writing function (with append mode support)

### Variable Naming Conventions

Across all implementations, use these consistent variable names (following each language's convention):
- `collatz` - current value in the sequence
- `start` - initial input value (should be immutable/final)
- `peak` - highest value reached
- `steps` - iteration counter
- `collatzFile` or `collatz_file` - output file name (follow language convention)

### Code Organization

1. **Main Calculator File**: Contains the main logic and user interaction
2. **Extras/Utilities File**: Contains helper functions (clear screen, file I/O)
3. Keep functions small and focused
4. Avoid overly clever code - prioritize readability
5. Separate concerns appropriately

### Comments

- Use comments sparingly - code should be self-documenting
- Comment complex algorithms or non-obvious optimizations
- Include overflow checks and error handling where appropriate
- Keep comments professional (casual humor is acceptable in utility files, as shown in Ruby example)

### Error Handling

- **64-bit implementations**: Must check for potential overflow before arithmetic operations
- **Arbitrary precision implementations**: Should handle invalid input gracefully
- File I/O should check for errors and handle them appropriately
- Invalid input should result in re-prompting, not crashes
- Use language-appropriate error handling patterns (try/catch, error returns, etc.)

### Testing

Before submitting:
1. Test with small numbers (2, 3, 4, 5)
2. Test with known challenging numbers (27, 97, 871)
3. Test edge cases (1, numbers < 1, non-integer input)
4. Verify output file is created correctly with proper formatting
5. For 64-bit implementations, test overflow detection
6. Verify peak tracking works correctly
7. Confirm step counting is accurate

### Brace Style Summary

| Language | Brace Style | Notes |
|----------|-------------|-------|
| C | C K&R | Same line for control structures and functions (project style). **Never omit braces.** |
| C# | Allman | Braces always on new line. **Never omit braces.** |
| Go | Go Standard | Must be same line (enforced by compiler). **Never omit braces.** |
| Java | Egyptian K&R (1TBS) | Braces always on same line. **Never omit braces.** |
| Kotlin | Egyptian K&R (1TBS) | Braces always on same line. **Never omit braces.** |
| Python | N/A | Uses indentation, not braces |
| Ruby | N/A | Uses `end` keyword |

## Submission Process

### Adding a New Language Implementation

1. **Fork the repository**
2. **Determine precision category**: Will your language use 64-bit or arbitrary precision?
3. **Create implementation directory**: `[64bitPrecision-Ints|ArbPrecision-Ints]/[Language]-Implementation/`
4. **Implement the calculator**: Follow the style guide for your language
5. **Test thoroughly**: Ensure it matches the expected behavior
6. **Update README.md**: Add your implementation to the appropriate list
7. **Submit a Pull Request**

### Improving Existing Implementations

1. **Fork the repository**
2. **Create a feature branch**: `git checkout -b improve-[language]-impl`
3. **Make your changes**: Follow existing style conventions
4. **Test thoroughly**: Ensure no regressions
5. **Submit a Pull Request** with a clear description of improvements

### Pull Request Guidelines

Your PR should:
- Have a clear, descriptive title
- Explain what changes were made and why
- Reference any related issues
- Pass all existing tests (if applicable)
- Follow the style guide for the target language
- Include sample output demonstrating functionality
- Maintain consistency with existing implementations

### Review Process

Maintainers will review for:
- Adherence to style guidelines (including brace style)
- Correctness of algorithm implementation
- Proper error handling
- Code clarity and maintainability
- Consistency with existing implementations
- Appropriate file naming conventions
- Proper indentation

## Questions?

If you have questions about contributing, please:
- Check existing issues for similar questions
- Review the existing implementations for examples
- Open an issue with the `question` label
- Reference this style guide when discussing style choices

---

Thank you for contributing to Collatz Conjecture Calculators! 🎉