mod cc_extras;

use cc_extras::write_to_file;
use std::{io, io::Write, process::exit};

fn main() {
    print!("\x1b[H\x1b[2J");
    let mut collatz: u64;
    let mut steps = 0;
    let collatz_file = "Rust-CollatzFile.txt";

    loop {
        print!("What number would you like to run through the Collatz Conjecture: ");
        io::stdout().flush().unwrap();

        let mut input = String::new();
        io::stdin()
            .read_line(&mut input)
            .expect("Failed to read line");
        collatz = input.trim().parse().expect("Not a number");

        if collatz >= 1 {
            break;
        }
        println!(
            "The Collatz Conjecture has strange and emergent behavior with numbers less than one."
        );
    }
    let start = collatz;
    let mut peak = collatz;
    write_to_file(collatz_file, &format!("Start: {start}"), false).ok();

    while collatz > 1 {
        steps += 1;
        if collatz % 2 == 0 {
            collatz /= 2;
        } else {
            if collatz > (u64::MAX - 1) / 3 {
                println!("{start} overflowed on step {steps}\nExiting...");
                write_to_file(collatz_file, &format!("{start} overflowed on step {steps}\nProgram exited with error: u64 Variable Overflow"), true).ok();
                exit(1);
            } else {
                collatz = collatz * 3 + 1;
                if collatz > peak {
                    peak = collatz;
                }
            }
        }
        write_to_file(collatz_file, &format!("Step {steps}: {collatz}"), true).ok();
    }

    println!(
        "{start} reached 1 in {steps} steps\nIts peak was {peak}\n\nFull path is in the file named\"{collatz_file}\""
    );
    write_to_file(collatz_file, &format!("{start} reached 1 in {steps} steps\nIts peak was {peak}"), true).ok();
}
