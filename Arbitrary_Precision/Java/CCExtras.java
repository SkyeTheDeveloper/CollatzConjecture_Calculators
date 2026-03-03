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


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

public class CCExtras {
    
    public static void writeToFile(Path filePath, String text, boolean append) {
        if (append) {
            try {
                Files.write(filePath, text.getBytes(StandardCharsets.UTF_8), 
                     StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.writeString(filePath, text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}