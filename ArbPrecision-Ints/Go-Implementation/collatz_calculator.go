package main

import (
	"fmt"
	"math/big"
)

func main() {
	Clear()
	one := big.NewInt(1)
	two := big.NewInt(2)
	three := big.NewInt(3)
	collatz := big.NewInt(0)
	start := big.NewInt(0)
	peak := new(big.Int).Set(collatz)
	steps := int(0)
	const collatzFile = "Go-CollatzFile.txt"
	
	for ok := true; ok; ok = (collatz.Cmp(one) <= 0) {
		var input string
		fmt.Print("What number would you like to run through the Collatz Conjecture: ")
		_, err := fmt.Scanln(&input)
		if err != nil {
			fmt.Println("Error reading input:", err)
        	return
		}
		collatz.SetString(input, 10)
		
		if (collatz.Cmp(one) < 0) {
			fmt.Println("The Collatz Conjecture has strange and emergent behavior with numbers below 1")
		}
	}
	start.Set(collatz)
	peak.Set(collatz)
	WriteToFile(collatzFile, fmt.Sprintf("Start: %s\n", start), false)
	
	temp := new(big.Int)
	for ok := true; ok; ok = (collatz.Cmp(one) > 0) {
		temp.Mod(collatz, two)
		if (temp.Cmp(one) < 0) {
			collatz.Div(collatz, two)
		} else {
			collatz.Mul(collatz, three)
			collatz.Add(collatz, one)
			if (collatz.Cmp(peak) > 0) {
				peak.Set(collatz)
			}
		}
		steps += 1
		WriteToFile(collatzFile, fmt.Sprintf("Step %d: %s\n", steps, collatz), true)
	}
	
	fmt.Printf("%s reached 1 in %d steps\nIts peak was %s\n\nFull path is in the file named \"Go-CollatzFile.txt\"\n", start, steps, peak)
	WriteToFile(collatzFile, fmt.Sprintf("%s reached 1 in %d steps\nIts peak was %s", start, steps, peak), true)
}
