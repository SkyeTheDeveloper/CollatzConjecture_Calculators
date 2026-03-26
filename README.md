# Collatz Conjecture Calculators
This project contains multiple implementations of Collatz Conjecture calculators
across various programming languages, demonstrating both non-arbitrary and
arbitrary precision integer arithmetic techniques..

## Implementations Included

### Non-Arbitrary Precision Implementations:
- **Bash**: Uses native 64-bit signed integers with overflow checking
- **C**: Uses native uint64_t datatype with overflow checking
- **C++**: Uses native uint64_t datatype with overflow checking
- **Fortran**: Uses iso_c_binding to add C's int64_t datatype with overflow checking
- **Rust**: Uses native u64 datatype with overflow checking

### Arbitrary Precision Implementations:
- **C#**: Uses native BigInteger library
- **Go**: Uses native math/big library
- **Java**: Uses native BigInteger library
- **JavaScript**: Uses native bigint datatype
- **Kotlin**: Uses Java's BigInteger library
- **Python**: Uses native int datatype
- **Ruby**: Uses native integer datatype
- **TypeScript**: Uses native bigint datatype

# NOTICE
The Creative Commons 0 License (`LICENSE-CC0`) only applies to the file `build.sh`. All other files are under your choice of Apache 2.0 or LGPL 3.0.