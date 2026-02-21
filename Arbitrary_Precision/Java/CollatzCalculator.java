 import java.util.Scanner;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.math.BigInteger;
 
 class CollatzCalculator {
     
     public static void main(String[] args) {
         CCExtras.clear();
         BigInteger collatz, peak; 
         int steps = 0;
         final Path collatzFile = Paths.get("Java-CollatzFile.txt");
         Scanner input = new Scanner(System.in);
         
         do {
             System.out.print("What number would you like to run through the Collatz Conjecture: ");
             collatz = new BigInteger(input.next());
             if (collatz.compareTo(BigInteger.ONE) != 0) {
                 if (collatz.compareTo(BigInteger.ONE) < 0) {
                     collatz = BigInteger.ZERO;
                     System.out.println("The Collatz Conjecture has strange and emergent behavior with numbers less than 1");
                 } else {
                     break;
                 }
             }
         } while (collatz.compareTo(BigInteger.ONE) < 0);
         final BigInteger start = peak = collatz;
         input.close();
         CCExtras.writeToFile(collatzFile, "Start: " + start + "\n", false);
         
         while (collatz.compareTo(BigInteger.ONE) > 0) {
             if (collatz.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                 collatz = collatz.divide(BigInteger.TWO);
             } else {
                 collatz = (collatz.multiply((BigInteger.TWO.add(BigInteger.ONE)))).add(BigInteger.ONE);
                 if (collatz.compareTo(peak) > 0) {
                     peak = collatz;
                 }
             }
             CCExtras.writeToFile(collatzFile, "Step " + ++steps + ": " + collatz + "\n", true);
         }
         
         System.out.println(start + " reached 1 in " + steps + " steps\nIts peak was " + peak + "\n\nThe full path is in a file named \"Java-CollatzFile.txt\"");
         CCExtras.writeToFile(collatzFile, start + " reached 1 in " + steps + " steps\nIts peak was " + peak, true);
     }
 }