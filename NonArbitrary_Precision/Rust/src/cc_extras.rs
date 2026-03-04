/*
 * SPDX-License-Identifier: Apache-2.0 OR MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Apache License,
 * Version 2.0. If a copy of the Apache License, Version 2.0 was not
 * distributed with this file, You can obtain one at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Alternatively, the contents of this file may be used under the terms
 * of the Mozilla Public License, v. 2.0, in which case the provisions of
 * the MPL are applicable instead of those above.
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