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


#include <iostream>
#include <fstream>
#include <cstdlib>
#include <cstdint>
#include <string>

int main()
{
    std::cout << "\x1b[H\x1b[2J";
    uint64_t collatz;
    uint64_t steps = 0;
    const std::string collatzFile = "CPlusPLus-CollatzFile.txt";
    std::ofstream cf_fp(collatzFile);
    if (!cf_fp) {
        std::cerr << "ERR: File is read-only" << std::endl;
        return EXIT_FAILURE;
    }

    do {
        std::cout << "What number would you like to run through the Collatz Conjecture: ";
        if (!(std::cin >> collatz)) {
            std::cout << "ERR: Input is not a number" << std::endl;
            return EXIT_FAILURE;
        } else if (collatz == 0) {
            std::cout << "The Collatz Conjecture has strange and emergent behavior with numbers less than one." << std::endl;
        }
    } while (collatz == 0);
    const uint64_t start = collatz;
    uint64_t peak = start;
    cf_fp << "Start: " << start << "\n";

    while (collatz > 1) {
        steps++;
        if (collatz % 2 == 0) {
            collatz /= 2;
        } else {
            if (collatz > (UINT64_MAX - 1) / 3) {
                std::cout << start << " overflowed on step " << steps << "\nExiting...\n" << std::endl;
                cf_fp << start << " overflowed on step " << steps << "\nProgram exited with error: ULong Integer Overflow";
                return EXIT_FAILURE;
            } else {
                collatz = collatz * 3 + 1;
                if (collatz > peak) {
                    peak = collatz;
                }
            }
        }
        cf_fp << "Step " << steps << ": " << collatz << "\n";
    }

    std::cout << start << " reached 1 in " << steps << " steps\nIts peak was " << peak << "\n\nFull path is in the file named \"" << collatzFile << "\"" << std::endl;
    cf_fp << start << " reached 1 in " << steps << " steps\nIts peak was " << peak;

    return EXIT_SUCCESS;
}