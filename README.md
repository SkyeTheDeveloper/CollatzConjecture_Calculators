# Collatz Conjecture Calculators
I programmed the same calculator using 2 different techniques. 
The first is using 64-bit precision to store numbers, then before every 3n+1 step, checking if that operation will overflow the number.
The second is using arbitrary precision to store numbers, and since they fill up as much RAM as needed, no overflow check is required.

## Languages used

64-bit Precision:
C
Java (has native library for arbitrary precision, but working with it is annoying)
Kotlin (same since it uses the same library)

Arbitrary Precision:
C# (has a native library for arbitrary precision)
Python
Ruby
Go (has a native library for arbitrary precision)
