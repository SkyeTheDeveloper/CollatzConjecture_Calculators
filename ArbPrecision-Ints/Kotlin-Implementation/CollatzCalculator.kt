import java.math.BigInteger;

fun main() {
    clear();
    var collatz = BigInteger.ZERO;
    var peak = collatz;
    var steps = 0;
    val collatzFile = "CollatzFile.txt";
    
    do {
        print("What number would you like to run through the Collatz Conjecture: ");
        collatz = readln().toBigInteger();
        if (collatz != BigInteger.ONE) {
            if (collatz < BigInteger.ONE) {
                collatz = BigInteger.ZERO
                println("The Collatz Conjecture has strange and emergent behavior with numbers less than 1");
            } else {
                break;
            }
        }
    } while (collatz < BigInteger.ONE);
    val start = collatz;
    peak = collatz;
    writeToFile(collatzFile, "Start: $start\n", false);
    
    while (collatz > BigInteger.ONE) {
        if (collatz % BigInteger.TWO == BigInteger.ZERO) {
            collatz /= BigInteger.TWO;
        } else {
            collatz = collatz * (BigInteger.TWO + BigInteger.ONE) + BigInteger.ONE;
            if (collatz > peak) {
                peak = collatz;
            }
        }
        writeToFile(collatzFile, "Step ${++steps}: $collatz \n", true);
    }
    
    println("$start reached 1 in $steps steps\nIts peak was $peak\n\nThe full path is in a file named \"CollatzFile.txt\"");
    writeToFile(collatzFile, "$start reached 1 in $steps steps\nIts peak was $peak", true);
}