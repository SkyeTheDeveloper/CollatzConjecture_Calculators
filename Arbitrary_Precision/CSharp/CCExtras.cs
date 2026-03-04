// SPDX-License-Identifier: Apache-2.0 OR MPL-2.0
//
// This Source Code Form is subject to the terms of the Apache License,
// Version 2.0. If a copy of the Apache License, Version 2.0 was not
// distributed with this file, You can obtain one at
// http://www.apache.org/licenses/LICENSE-2.0
//
// Alternatively, the contents of this file may be used under the terms
// of the Mozilla Public License, v. 2.0, in which case the provisions of
// the MPL are applicable instead of those above.

#pragma warning disable IDE0130

using System.IO;

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