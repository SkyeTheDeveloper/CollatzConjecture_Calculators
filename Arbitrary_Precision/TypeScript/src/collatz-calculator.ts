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


import readline from "node:readline/promises";
import { writeToFile } from "./cc-extras.mjs";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

process.stdout.write("\x1b[H\x1b[2J");
let collatz = 0n;
let steps = 0;
const COLLATZ_FILE = "TypeScript-CollatzFile.txt";

do {
  const answer = await rl.question(
    "What number would you like to run through the Collatz Conjecture: ",
  );
  try {
    collatz = BigInt(answer);
    if (collatz < 1n) {
      console.log(
        "The Collatz Conjecture has strange and emergent behavior with numbers less than one.\nTry again...",
      );
      collatz = 0n;
    }
  } catch {
    console.log("Invalid input. Please enter a valid integer.");
    collatz = 0n;
  }
} while (collatz < 1n);
rl.close();
const START = collatz;
let peak = START;
writeToFile(COLLATZ_FILE, `Start: ${START}\n`, false);

while (collatz > 1n) {
  steps++;
  if (collatz % 2n === 0n) {
    collatz /= 2n;
  } else {
    collatz = collatz * 3n + 1n;
    if (collatz > peak) {
      peak = collatz;
    }
  }
  writeToFile(COLLATZ_FILE, `Step ${steps}: ${collatz}\n`, true);
}

console.log(
  `${START} reached 1 in ${steps} steps\nIts peak was ${peak}\n\nFull path is in the file named "${COLLATZ_FILE}"`,
);
writeToFile(
  COLLATZ_FILE,
  `${START} reached 1 in ${steps} steps\nIts peak was ${peak}`,
  true,
);
