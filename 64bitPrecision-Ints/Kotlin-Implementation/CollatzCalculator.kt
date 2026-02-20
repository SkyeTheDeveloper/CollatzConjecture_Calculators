fun main() {
    clear();
    var collatz = 0uL;
    var peak = collatz;
    var steps = 0;
    val collatzFile = "CollatzFile.txt";
    
    do {
        print("What number would you like to run through the Collatz Conjecture: ");
        collatz = readln().toULong();
        if (collatz != 1uL) {
            if (collatz < 1uL) {
                collatz = 0uL
                println("The Collatz Conjecture has strange and emergent behavior with numbers less than 1");
            } else {
                break;
            }
        }
    } while (collatz < 0uL);
    val start = collatz;
    peak = collatz;
    writeToFile(collatzFile, "Start: $start\n", false);
    
    while (collatz > 1uL) {
        if (collatz % 2uL == 0uL) {
            collatz /= 2uL;
        } else {
            if (collatz > (ULong.MAX_VALUE - 1uL) / 3uL) {
                println("$start overflowed on step ${++steps}\nExiting...");
                writeToFile(collatzFile, "$start overflowed on step $steps\nProgram exited with error: ULong Integer Overflow", true);
                kotlin.system.exitProcess(1);
            } else {
                collatz = collatz * 3uL + 1uL;
                if (collatz > peak) {
                    peak = collatz;
                }
            }
        }
        writeToFile(collatzFile, "Step ${++steps}: $collatz \n", true);
    }
    
    println("$start reached 1 in $steps steps\nIts peak was $peak\n\nThe full path is in a file named \"CollatzFile.txt\"");
    writeToFile(collatzFile, "$start reached 1 in $steps steps\nIts peak was $peak", true);
}