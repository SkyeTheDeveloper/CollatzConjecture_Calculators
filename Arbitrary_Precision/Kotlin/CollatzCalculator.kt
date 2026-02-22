import java.math.BigInteger;

fun main() {
    print("\u001b[H\u001b[2J");
    var collatz = BigInteger.ZERO;
    var steps = 0;
    val collatzFile = "Kotlin-CollatzFile.txt";
    
    do {
        print("What number would you like to run through the Collatz Conjecture: ");
        collatz = readln().toBigInteger();
        if (collatz < BigInteger.ONE) {
            println("The Collatz Conjecture has strange and emergent behavior with numbers less than 1");
            collatz = BigInteger.ZERO
        } else {
            break;
        }
    } while (collatz < BigInteger.ONE);
    val start = collatz;
    var peak = start;
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
    
    println("$start reached 1 in $steps steps\nIts peak was $peak\n\nThe full path is in a file named \"Kotlin-CollatzFile.txt\"");
    writeToFile(collatzFile, "$start reached 1 in $steps steps\nIts peak was $peak", true);
}