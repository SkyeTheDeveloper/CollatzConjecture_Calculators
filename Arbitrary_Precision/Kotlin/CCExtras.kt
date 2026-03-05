/*
 * SPDX-License-Identifier: Apache-2.0 OR MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Apache License,
 * v. 2.0. If a copy of the Apache License was not distributed with this
 * file, You can obtain one at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Alternatively, this Source Code Form is subject to the terms of the 
 * Mozilla Public License, v. 2.0. If a copy of the MPL was not 
 * distributed with this file, You can obtain one at 
 * https://mozilla.org/MPL/2.0/.
 *
 * Copyright 2026 Skylar Koningin
 */

import java.io.File

fun writeToFile(path: String, text: String, append: Boolean) {
    if (append) {
        File(path).appendText(text);
    } else {
        File(path).writeText(text);
    }
}