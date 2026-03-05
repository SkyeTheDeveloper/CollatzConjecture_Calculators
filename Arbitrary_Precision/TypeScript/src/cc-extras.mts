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


import * as fs from "node:fs";

export function writeToFile(filePath: string, text: string, append: boolean) {
  if (append) {
    try {
      fs.appendFileSync(filePath, text, "utf-8");
    } catch (err) {
      console.error(err);
    }
  } else {
    try {
      fs.writeFileSync(filePath, text, "utf-8");
    } catch (err) {
      console.error(err);
    }
  }
}
