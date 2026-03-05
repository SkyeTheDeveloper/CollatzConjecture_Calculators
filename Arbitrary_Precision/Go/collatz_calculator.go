/*
 * SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
 *
 * This Source Code Form is subject to the terms of the Apache License,
 * v. 2.0, or the GNU Lesser General Public License, v. 3.0 or later.
 * If a copy of the Apache License was not distributed with this file,
 * You can obtain one at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Alternatively, this Source Code Form is subject to the terms of the
 * GNU Lesser General Public License, v. 3.0 or later. If a copy of the
 * LGPL was not distributed with this file, You can obtain one at
 * https://www.gnu.org/licenses/lgpl-3.0.html.
 *
 * Copyright 2026 Skylar Koningin
 */



package main

import (
	"fmt"
	"math/big"
	"os"
)

func main() {
	fmt.Print("\033[H\033[2J")
	one := big.NewInt(1)
	two := big.NewInt(2)
	three := big.NewInt(3)
	collatz := big.NewInt(0)
	steps := 0
	const collatzFile = "Go-CollatzFile.txt"
	
	for {
		var input string
		fmt.Print("What number would you like to run through the Collatz Conjecture: ")
		_, err := fmt.Scanln(&input)
		if err != nil {
			fmt.Println("Error reading input:", err)
        	return
		}
		if _, ok := collatz.SetString(input, 10); !ok {
		    fmt.Println("ERR: Input is not a number")
		    os.Exit(1)
		}

		
		if (collatz.Cmp(one) < 0) {
			fmt.Println("The Collatz Conjecture has strange and emergent behavior with numbers below 1")
		}
		if collatz.Cmp(one) >= 0 { break }
	}
	start := new(big.Int).Set(collatz)
	peak := new(big.Int).Set(start)
	WriteToFile(collatzFile, fmt.Sprintf("Start: %s\n", start), false)
	
	for collatz.Cmp(one) > 0 {
		steps++
		if collatz.Bit(0) == 0 {
			collatz.Div(collatz, two)
		} else {
			collatz.Mul(collatz, three)
			collatz.Add(collatz, one)
			if (collatz.Cmp(peak) > 0) {
				peak.Set(collatz)
			}
		}
		WriteToFile(collatzFile, fmt.Sprintf("Step %d: %s\n", steps, collatz), true)
	}
	
	fmt.Printf("%s reached 1 in %d steps\nIts peak was %s\n\nFull path is in the file named \"%s\"\n", start, steps, peak, collatzFile)
	WriteToFile(collatzFile, fmt.Sprintf("%s reached 1 in %d steps\nIts peak was %s", start, steps, peak), true)
}
