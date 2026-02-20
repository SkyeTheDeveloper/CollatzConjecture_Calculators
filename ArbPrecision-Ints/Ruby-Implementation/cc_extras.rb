# frozen_string_literal: true

# fuck ts fr
module CCExtras
  def self.clear
    print "\x1b[H\x1b[2J"
    $stdout.flush
  end

  def self.write_to_file(file_path, text, append)
    if append
      File.write file_path, text, mode: 'a'
    else
      File.write file_path, text
    end
  end
end
