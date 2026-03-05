/*
 * SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
 *
 * This Source Code Form is subject to the terms of the Apache License,
 * v. 2.0.
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


import java.math.BigInteger

fun main() {
    print("\u001b[H\u001b[2J")
    var collatz = BigInteger.ZERO
    var steps = 0L
    val collatzFile = "Kotlin-CollatzFile.txt"
    
    do {
        print("What number would you like to run through the Collatz Conjecture: ")
        collatz = readln().toBigInteger()
        if (collatz < BigInteger.ONE) {
            println("The Collatz Conjecture has strange and emergent behavior with numbers less than 1")
            collatz = BigInteger.ZERO
        } else {
            break
        }
    } while (collatz < BigInteger.ONE)
    val start = collatz
    var peak = start
    writeToFile(collatzFile, "Start: $start\n", false)
    
    while (collatz > BigInteger.ONE) {
        steps++
        if (collatz % BigInteger.TWO == BigInteger.ZERO) {
            collatz /= BigInteger.TWO
        } else {
            collatz = collatz * 3.toBigInteger() + BigInteger.ONE
            if (collatz > peak) {
                peak = collatz
            }
        }
        writeToFile(collatzFile, "Step $steps: $collatz \n", true)
    }
    
    println("$start reached 1 in $steps steps\nIts peak was $peak\n\nThe full path is in a file named \"$collatzFile\"")
    writeToFile(collatzFile, "$start reached 1 in $steps steps\nIts peak was $peak", true)
}