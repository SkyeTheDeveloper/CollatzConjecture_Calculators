#include "collatz_calculator.h"

int main()
{
    clear();
    uint64_t collatz, peak;
    int steps = 0;
    FILE *collatz_file;
    collatz_file = fopen("CollatzFile.txt", "w");
    if (collatz_file == NULL) {
        fprintf(stderr, "File read-only or inacessible");
    }

    do {
        printf("What number would you like to run through the Collatz Conjecture: ");
        if (scanf(" %llu", &collatz) != 1) {
            while(getchar() != '\n') {
                collatz = 0;
                continue;
            }
        }
    } while (collatz < 1 && printf("The Collatz Conjecture has strange and emergent behavior with numbers less than 1 and non-integers\n"));
    const uint64_t start = peak = collatz;
    fprintf(collatz_file, "Start: %llu\n", start);

    while (collatz > 1) {
        if (collatz % 2 == 0) {
            collatz /= 2;
        } else {
            if (collatz > (ULLONG_MAX - 1) / 3) {
                printf("%llu overflowed on step %i\nExiting...\n\n", start, ++steps);
                fprintf(collatz_file, "%llu overflowed on step %i\nProgram exited with error: ULong Integer Overflow", start, steps);
                goto exit_collatz;
            } else {
                collatz = collatz * 3 + 1;
                if (collatz > peak) {
                    peak = collatz;
                }
            }
        }
        fprintf(collatz_file, "Step %i: %llu\n", ++steps, collatz);
    }

    printf("%llu reached 1 in %i steps\nIts peak was %llu\n\nFull path is in the file named \"CollatzFile.txt\"\n", start, steps, peak);
    fprintf(collatz_file, "%llu reached 1 in %i steps\nIts peak was %llu", start, steps, peak);

exit_collatz:
    fclose(collatz_file);
    return EXIT_SUCCESS;
}