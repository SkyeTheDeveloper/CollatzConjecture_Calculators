#include "collatz_calculator.h"

int main()
{
    printf("\x1b[H\x1b[2J");
    uint64_t collatz;
    int steps = 0;
    const char* COLLATZ_FILE = "C-CollatzFile.txt";
    FILE *cf_pointer;
    cf_pointer = fopen(COLLATZ_FILE, "w");
    if (cf_pointer == NULL) {
        fprintf(stderr, "ERR: File is read-only");
    }

    do {
        printf("What number would you like to run through the Collatz Conjecture: ");
        if (scanf(" %" PRIu64, &collatz) < 1) {
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
    fprintf(cf_pointer, "Start: %" PRIu64 "\n", START);

    while (collatz > 1) {
        if (collatz % 2 == 0) {
            collatz /= 2;
        } else {
            if (collatz > (ULLONG_MAX - 1) / 3) {
                printf("%" PRIu64 " overflowed on step %i\nExiting...\n\n", START, ++steps);
                fprintf(cf_pointer, "%" PRIu64 " overflowed on step %i\nProgram exited with error: ULong Integer Overflow", START, steps);
                fclose(cf_pointer);
                return EXIT_FAILURE;
            } else {
                collatz = collatz * 3 + 1;
                if (collatz > peak) {
                    peak = collatz;
                }
            }
        }
        fprintf(cf_pointer, "Step %i: %" PRIu64 "\n", ++steps, collatz);
    }

    printf("%" PRIu64 " reached 1 in %i steps\nIts peak was %" PRIu64 "\n\nFull path is in the file named \"%s\"\n", START, steps, peak, COLLATZ_FILE);
    fprintf(cf_pointer, "%" PRIu64 " reached 1 in %i steps\nIts peak was %" PRIu64, START, steps, peak);

    fclose(cf_pointer);
    return EXIT_SUCCESS;
}