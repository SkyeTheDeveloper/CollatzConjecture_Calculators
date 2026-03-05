# SPDX-License-Identifier: Apache-2.0 OR MPL-2.0
#
# This Source Code Form is subject to the terms of the Apache License,
# v. 2.0. If a copy of the Apache License was not distributed with this
# file, You can obtain one at http://www.apache.org/licenses/LICENSE-2.0.
#
# Alternatively, this Source Code Form is subject to the terms of the 
# Mozilla Public License, v. 2.0. If a copy of the MPL was not 
# distributed with this file, You can obtain one at 
# https://mozilla.org/MPL/2.0/.
#
# Copyright 2026 Skylar Koningin

# frozen_string_literal: true

# fuck ts fr
module CCExtras
  def self.write_to_file(file_path, text, append)
    if append
      File.write file_path, text, mode: 'a'
    else
      File.write file_path, text
    end
  end
end
