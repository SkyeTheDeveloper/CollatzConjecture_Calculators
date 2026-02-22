#pragma warning disable IDE0130

using System;
using System.Numerics;
using CollatzCalculatorExtras;

namespace CollatzCalculator
{
    class CollatzCalculator
    {
        static void Main()
        {
            Console.Clear();
            BigInteger collatz = 0;
            int steps = 0;
            const string collatzFile = "CSharp-CollatzFile.txt";

            do
            {
                Console.Write("What number would you like to run through the Collatz Conjecture: ");
                string input = Console.ReadLine() ?? "";
                
                try
                {
                    collatz = BigInteger.Parse(input);
                }
                catch (FormatException)
                {
                    Console.WriteLine($"ERR: Input is not a number");
                }

                if (collatz < 1)
                {
                    Console.WriteLine("The Collatz Conjecture has strange and emergent behavior with numbers less than 1 and non-integers.");
                    collatz = 0;
                }
            } while (collatz < 1);
            BigInteger start = collatz;
            BigInteger peak = start;
            CCExtras.WriteToFile(collatzFile, $"Start: {start}\n", false);

            while (collatz > 1)
            {
                if (collatz % 2 == 0)
                {
                    collatz /= 2;
                }
                else
                {
                    collatz = (collatz * 3) + 1;
                    if (collatz > peak)
                    {
                        peak = collatz;
                    }
                }
                steps++;
                CCExtras.WriteToFile(collatzFile, $"Step {steps}: {collatz}\n", true);
            }

            Console.WriteLine($"{start} reached 1 in {steps} steps\nIts peak was {peak}\n\nFull path is in the file named \"CSharp-CollatzFile.txt\"");
            CCExtras.WriteToFile(collatzFile, $"{start} reached 1 in {steps} steps\nIts peak was {peak}", true);
        }
    }
}