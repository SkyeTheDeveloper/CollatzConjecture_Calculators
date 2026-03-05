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

use std::fs;
use std::fs::OpenOptions;
use std::io;
use std::io::Write;

pub fn write_to_file(file_path: &str, text: &str, append: bool) -> io::Result<()>{

    if append {
        let mut file = OpenOptions::new()
            .append(true)
            .create(true)
            .open(file_path)?;
        file.write_all(text.as_bytes())?;
    } else {
        fs::write(file_path, text)?;
    }
    Ok(())
}