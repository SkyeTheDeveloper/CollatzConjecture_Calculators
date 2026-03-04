 /*
  * SPDX-License-Identifier: Apache-2.0 OR MPL-2.0
  *
  * This Source Code Form is subject to the terms of the Apache License,
  * Version 2.0. If a copy of the Apache License, Version 2.0 was not
  * distributed with this file, You can obtain one at
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Alternatively, the contents of this file may be used under the terms
  * of the Mozilla Public License, v. 2.0, in which case the provisions of
  * the MPL are applicable instead of those above.
  */
 
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.math.BigInteger;

public class CollatzCalculator {
     
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        BigInteger collatz; 
        long steps = 0;
        final Path collatzFile = Paths.get("Java-CollatzFile.txt");
        Scanner input = new Scanner(System.in);
         
        do {
            System.out.print("What number would you like to run through the Collatz Conjecture: ");
            collatz = new BigInteger(input.next());
            if (collatz.compareTo(BigInteger.ONE) < 0) {
                collatz = BigInteger.ZERO;
                System.out.println("The Collatz Conjecture has strange and emergent behavior with numbers less than 1");
            } else {
                break;
            }
             
        } while (collatz.compareTo(BigInteger.ONE) < 0);
        final BigInteger START = collatz;
        BigInteger peak = START;
        input.close();
        CCExtras.writeToFile(collatzFile, "Start: " + START + "\n", false);
         
        while (collatz.compareTo(BigInteger.ONE) > 0) {
            steps++;
            if (collatz.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                collatz = collatz.divide(BigInteger.TWO);
            } else {
                collatz = collatz.multiply(BigInteger.valueOf(3)).add(BigInteger.ONE);
                if (collatz.compareTo(peak) > 0) {
                    peak = collatz;
                }
            }
            CCExtras.writeToFile(collatzFile, "Step " + steps + ": " + collatz + "\n", true);
        }
         
        System.out.println(START + " reached 1 in " + steps + " steps\nIts peak was " + peak + "\n\nThe full path is in a file named \"" + collatzFile + "\"");
        CCExtras.writeToFile(collatzFile, START + " reached 1 in " + steps + " steps\nIts peak was " + peak, true);
    }
}