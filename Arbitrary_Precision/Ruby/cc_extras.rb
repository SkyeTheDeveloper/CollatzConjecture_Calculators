# SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
#
# This Source Code Form is subject to the terms of the Apache License,
# v. 2.0.
# If a copy of the Apache License was not distributed with this file,
# You can obtain one at http://www.apache.org/licenses/LICENSE-2.0.
#
# Alternatively, this Source Code Form is subject to the terms of the
# GNU Lesser General Public License, v. 3.0 or later. If a copy of the
# LGPL was not distributed with this file, You can obtain one at
# https://www.gnu.org/licenses/lgpl-3.0.html.
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
