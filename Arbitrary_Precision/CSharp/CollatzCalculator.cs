// SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
//
// This Source Code Form is subject to the terms of the Apache License,
// v. 2.0.
// If a copy of the Apache License was not distributed with this file,
// You can obtain one at http://www.apache.org/licenses/LICENSE-2.0.
//
// Alternatively, this Source Code Form is subject to the terms of the
// GNU Lesser General Public License, v. 3.0 or later. If a copy of the
// LGPL was not distributed with this file, You can obtain one at
// https://www.gnu.org/licenses/lgpl-3.0.html.
//
// Copyright 2026 Skylar Koningin

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
            BigInteger steps = 0;
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
                    Console.WriteLine("ERR: Input is not a number");
                    Environment.Exit(1);
                }
                
                if (collatz < 0)
                {
                    Console.WriteLine("ERR: Input is not a positive number");
                    Environment.Exit(1);
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
                steps++;
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
                CCExtras.WriteToFile(collatzFile, $"Step {steps}: {collatz}\n", true);
            }

            Console.WriteLine($"{start} reached 1 in {steps} steps\nIts peak was {peak}\n\nFull path is in the file named \"{collatzFile}\"");
            CCExtras.WriteToFile(collatzFile, $"{start} reached 1 in {steps} steps\nIts peak was {peak}", true);
        }
    }
}