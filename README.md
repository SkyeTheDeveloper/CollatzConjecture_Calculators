# Collatz Conjecture Calculators
I programmed the same calculator using 2 different techniques. 
The first is using 64-bit precision to store numbers, then before every 3n+1 step, checking if that operation will overflow the number.
The second is using arbitrary precision to store numbers, and since they fill up as much RAM as needed, no overflow check is required.



## Languages used (grouped by 64-bit or Arbitrary Precision integers)
64-bit Precision:
C

Arbitrary Precision:
C#
Go
Java
Kotlin
Python
Ruby



## Implementation Style (datatye/library used, oveflow check)
C: uses native uint64_t datatype to store 64-bit integers, then before 3n+1 steps, checks if that integer could overflow, causing an incorrect output
C#: uses native BigInteger library to store Arbitrary Precision integers, does not require overflow check
Go: uses native math/big library to store Arbitrary Precision integers, does not require overflow check
Java: uses native BigInteger library to store Arbitrary Precision integers, does not require overflow check
Kotlin: uses Java's BigInteger library to store Arbitrary Precision integers, does not require overflow check
Python: uses native int datatype to store Arbitrary Precsion integers, does not require overflow check
Ruby: uses native integer datatype to store Arbitrary Precision integers, does not require overflow check