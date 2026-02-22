#include "collatz_calculator.h"

int main()
{
    printf("\x1b[H\x1b[2J");
    uint64_t collatz;
    int steps = 0;
    FILE *collatz_file;
    collatz_file = fopen("C-CollatzFile.txt", "w");
    if (collatz_file == NULL) {
        fprintf(stderr, "ERR: File is read-only");
    }

    do {
        printf("What number would you like to run through the Collatz Conjecture: ");
        if (scanf(" %lu", &collatz) < 1) {
            while (getchar() != '\n') {
                printf("ERR: Input is not a number\n");
                return EXIT_FAILURE;
            }
        } else if (collatz < 1) {
            printf("The Collatz Conjecture has strange and emergent behavior with numbers less than one.\n");
            collatz = 0;
        }
    } while (collatz < 1);
    const uint64_t START = collatz;
    uint64_t peak = START;
    fprintf(collatz_file, "Start: %lu\n", START);

    while (collatz > 1) {
        if (collatz % 2 == 0) {
            collatz /= 2;
        } else {
            if (collatz > (ULLONG_MAX - 1) / 3) {
                printf("%lu overflowed on step %i\nExiting...\n\n", START, ++steps);
                fprintf(collatz_file, "%lu overflowed on step %i\nProgram exited with error: ULong Integer Overflow", START, steps);
                fclose(collatz_file);
                return EXIT_FAILURE;
            } else {
                collatz = collatz * 3 + 1;
                if (collatz > peak) {
                    peak = collatz;
                }
            }
        }
        fprintf(collatz_file, "Step %i: %lu\n", ++steps, collatz);
    }

    printf("%lu reached 1 in %i steps\nIts peak was %lu\n\nFull path is in the file named \"C-CollatzFile.txt\"\n", START, steps, peak);
    fprintf(collatz_file, "%lu reached 1 in %i steps\nIts peak was %lu", START, steps, peak);

    fclose(collatz_file);
    return EXIT_SUCCESS;
}