// SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
//
// This Source Code Form is subject to the terms of the Apache License,
// v. 2.0, or the GNU Lesser General Public License, v. 3.0 or later.
// If a copy of the Apache License was not distributed with this file,
// You can obtain one at http://www.apache.org/licenses/LICENSE-2.0.
//
// Alternatively, this Source Code Form is subject to the terms of the
// GNU Lesser General Public License, v. 3.0 or later. If a copy of the
// LGPL was not distributed with this file, You can obtain one at
// https://www.gnu.org/licenses/lgpl-3.0.html.
//
// Copyright 2026 Skylar Koningin


namespace CollatzCalculatorExtras
{
    public class CCExtras
    {
        public static void WriteToFile(string filePath, string text, bool append)
        {
            if (append)
            {
                File.AppendAllText(filePath, text);
            }
            else
            {
                File.WriteAllText(filePath, text);
            }
        }
    }
}