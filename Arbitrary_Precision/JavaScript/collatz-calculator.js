import readline from 'node:readline/promises';
import { writeToFile } from './cc-extras.mjs';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

console.log("\x1b[H\x1b[2J");
let collatz = 0n;
let steps = 0;
const COLLATZ_FILE = "JavaScript-CollatzFile.txt";

do {
  const answer = await rl.question('What number would you like to run through the Collatz Conjecture: ');
  if (answer < 1) {
    console.log("The Collatz Conjecture has strage and emergent behavior with numbers less than one.\nTry again...");
    collatz = 0n;
  } else {
    collatz = BigInt(answer);
  }
} while (collatz < 1n);
rl.close();

rl.close();
const START = collatz;
let peak = START;
writeToFile(COLLATZ_FILE, `Start: ${START}\n`, false);

while (collatz > 1) {
  if (collatz % 2n === 0n) {
    collatz /= 2n;
  } else {
    collatz = collatz * 3n + 1n;
    if (collatz > peak) {
      peak = collatz;
    }
  }
  steps++;
  writeToFile(COLLATZ_FILE, `Step ${steps}: ${collatz}\n`, true);
}

console.log(`${START} reached 1 in ${steps} steps\nIts peak was ${peak}\n\nFull path is in the file named "JavaScript-CollatzFile.txt"`);
writeToFile(COLLATZ_FILE, `${START} reached 1 in ${steps} steps\nIts peak was ${peak}`, true);