# NOTICE

## Collatz Conjecture Calculators

Copyright (c) 2026 Skylar Koningin

This project is licensed under the Apache License, Version 2.0 (the "Apache License")
or the Mozilla Public License, Version 2.0 (the "MPL"). You may use this work under
either license at your option.

### Apache License 2.0

You may obtain a copy of the Apache License at:

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

### Mozilla Public License 2.0

This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
If a copy of the MPL was not distributed with this file, You can obtain one at:

    http://mozilla.org/MPL/2.0/

---

## Project Description

This project contains multiple implementations of Collatz Conjecture calculators
across various programming languages, demonstrating both non-arbitrary and
arbitrary precision integer arithmetic techniques.

## Implementations Included

### Non-Arbitrary Precision Implementations:
- **Bash**: Uses native 64-bit signed integers with overflow checking
- **C**: Uses native uint64_t datatype with overflow checking
- **C++**: Uses native uint64_t datatype with overflow checking
- **Fortran**: Uses iso_c_binding to add C's int64_t datatype with overflow checking
- **Rust**: Uses native u64 datatype with overflow checking

### Arbitrary Precision Implementations:
- **C#**: Uses native BigInteger library
- **Go**: Uses native math/big library
- **Java**: Uses native BigInteger library
- **JavaScript**: Uses native bigint datatype
- **Kotlin**: Uses Java's BigInteger library
- **Python**: Uses native int datatype
- **Ruby**: Uses native integer datatype
- **TypeScript**: Uses native bigint datatype

## Third-Party Components

This project utilizes standard libraries and built-in datatypes from the respective
programming languages. No external third-party dependencies are required.

## Attribution

When redistributing or modifying this work, you must:
1. Retain this NOTICE file
2. Include a copy of the LICENSE file(s)
3. State any significant changes made to the original files
4. Comply with all terms of the Apache License 2.0 or Mozilla Public License 2.0

For the complete license terms, please refer to the LICENSE file(s) in the root
directory of this project.