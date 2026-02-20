 import java.util.Scanner;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 
 class CollatzCalculator {
     
     public static void main(String[] args) {
         CCExtras.clear();
         Long collatz, peak; 
         int steps = 0;
         final Path collatzFile = Paths.get("CollatzFile.txt");
         Scanner input = new Scanner(System.in);
         
         do {
             System.out.print("What number would you like to run through the Collatz Conjecture: ");
             collatz = input.nextLong();
             if (collatz != 1) {
                 if (collatz < 1) {
                     collatz = 0L;
                     System.out.println("The Collatz Conjecture has strange and emergent behavior with numbers less than 1");
                 } else {
                     break;
                 }
             }
         } while (collatz < 1);
         final Long start = peak = collatz;
         input.close();
         CCExtras.writeToFile(collatzFile, "Start: " + start + "\n", false);
         
         while (collatz > 1) {
             if (collatz % 2 == 0) {
                 collatz /= 2;
             } else {
                 if (collatz > (Long.MAX_VALUE - 1) / 3) {
                     System.out.println(start + " overflowed on step " + (++steps) + "\nExiting...");
                     CCExtras.writeToFile(collatzFile, start + " overflowed on step " + steps + "\nProgram exited with error: ULong Integer Overflow", false);
                     System.exit(1);
                 } else {
                     collatz = collatz * 3 + 1;
                     if (collatz > peak) {
                         peak = collatz;
                     }
                 }
             }
             CCExtras.writeToFile(collatzFile, "Step " + ++steps + ": " + collatz + "\n", true);
         }
         
         System.out.println(start + " reached 1 in " + steps + " steps\nIts peak was " + peak + "\n\nThe full path is in a file named \"CollatzFile.txt\"");
         CCExtras.writeToFile(collatzFile, start + " reached 1 in " + steps + " steps\nIts peak was " + peak, true);
     }
 }