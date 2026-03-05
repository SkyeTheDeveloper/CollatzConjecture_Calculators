# SPDX-License-Identifier: Apache-2.0 OR MPL-2.0
#
# This Source Code Form is subject to the terms of the Apache License,
# v. 2.0. If a copy of the Apache License was not distributed with this
# file, You can obtain one at http://www.apache.org/licenses/LICENSE-2.0.
#
# Alternatively, this Source Code Form is subject to the terms of the 
# Mozilla Public License, v. 2.0. If a copy of the MPL was not 
# distributed with this file, You can obtain one at 
# https://mozilla.org/MPL/2.0/.
#
# Copyright 2026 Skylar Koningin

print("\x1b[H\x1b[2J", end="", flush=True)
collatz = 0
steps = 0
collatz_file = "Python-CollatzFile.txt"

with open(collatz_file, "w") as file:
    while True:
        collatz = int(input("What number would you like to run through the Collatz Conjecture: "))
        if collatz < 1:
            print("The Collatz Conjecture has strange and emergent behavior with numbers less than 1")
        else:
            break
    start = peak = collatz
    file.write(f"Start: {start}\n")
    
    while collatz > 1:
        if collatz % 2 == 0:
            collatz //= 2
        else:
            collatz = collatz * 3 + 1
            if collatz > peak:
                peak = collatz
        steps += 1
        file.write(f"Step {steps}: {collatz}\n")
    
    print(f"{start} reached 1 in {steps} steps\nIts peak was {peak}\n\nFull path is in the file named \"{collatz_file}\"\n")
    file.write(f"{start} reached 1 in {steps} steps\nIts peak was {peak}")