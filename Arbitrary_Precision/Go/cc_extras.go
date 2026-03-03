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


package main

import (
	"log"
	"os"
)

func WriteToFile(filePath string, text string, append bool) {
	flags := os.O_CREATE | os.O_WRONLY
	if append {
		flags |= os.O_APPEND
	} else {
		flags |= os.O_TRUNC
	}
	
	f, err := os.OpenFile(filePath, flags, 0644)
	if err != nil {
		log.Fatal(err)
	}
	defer f.Close()
	
	if _, err := f.WriteString(text); err != nil {
		log.Fatal(err)
	}
}