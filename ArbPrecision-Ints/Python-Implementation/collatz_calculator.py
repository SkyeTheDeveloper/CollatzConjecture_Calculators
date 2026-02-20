import cc_extras

cc_extras.clear()
collatz = start = peak = steps = 0

with open("CollatzFile.txt", "w") as file:
    while True:
        collatz = int(input("What number would you like to run through the Collatz Conjecture: "))
        if (collatz != 1):
            if (collatz < 1):
                collatz = 0
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
    
    print(f"{start} reached 1 in {steps} steps\nIts peak was {peak}\n\nFull path is in the file named \"CollatzFile.txt\"\n")
    file.write(f"{start} reached 1 in {steps} steps\nIts peak was {peak}")