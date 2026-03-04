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

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <inttypes.h>

int main()
{
    printf("\x1b[H\x1b[2J");
    uint64_t collatz;
    uint64_t steps = 0;
    const char* const collatzFile = "C-CollatzFile.txt";
    FILE *cf_fp = fopen(collatzFile, "w");
    if (cf_fp == NULL) {
        perror("ERR: File is read-only");
        return EXIT_FAILURE;
    }

    do {
        printf("What number would you like to run through the Collatz Conjecture: ");
        if (scanf(" %" PRIu64, &collatz) < 1) {
            printf("ERR: Input is not a number\n");
            fclose(cf_fp);
            return EXIT_FAILURE;
        } else if (collatz == 0) {
            printf("The Collatz Conjecture has strange and emergent behavior with numbers less than one.\n");
        }
    } while (collatz == 0);
    const uint64_t start = collatz;
    uint64_t peak = start;
    fprintf(cf_fp, "Start: %" PRIu64 "\n", start);

    while (collatz > 1) {
        steps++;
        if (collatz % 2 == 0) {
            collatz /= 2;
        } else {
            if (collatz > (UINT64_MAX - 1) / 3) {
                printf("%" PRIu64 " overflowed on step %" PRIu64 "\nExiting...\n\n", start, steps);
                fprintf(cf_fp, "%" PRIu64 " overflowed on step %" PRIu64 "\nProgram exited with error: ULong Integer Overflow", start, steps);
                fclose(cf_fp);
                return EXIT_FAILURE;
            } else {
                collatz = collatz * 3 + 1;
                if (collatz > peak) {
                    peak = collatz;
                }
            }
        }
        fprintf(cf_fp, "Step %" PRIu64 ": %" PRIu64 "\n", steps, collatz);
    }

    printf("%" PRIu64 " reached 1 in %" PRIu64 " steps\nIts peak was %" PRIu64 "\n\nFull path is in the file named \"%s\"\n", start, steps, peak, collatzFile);
    fprintf(cf_fp, "%" PRIu64 " reached 1 in %" PRIu64 " steps\nIts peak was %" PRIu64, start, steps, peak);

    fclose(cf_fp);
    return EXIT_SUCCESS;
}