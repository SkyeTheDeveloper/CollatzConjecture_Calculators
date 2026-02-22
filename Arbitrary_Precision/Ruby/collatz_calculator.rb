# frozen_string_literal: true

require_relative 'cc_extras'

print "\x1b[H\x1b[2J"
collatz = steps = 0
COLLATZ_FILE = 'Ruby-CollatzFile.txt'

loop do
  print 'What number would you like to run through the Collatz Conjecture: '
  collatz = gets.to_i
  if collatz != 1
    break unless collatz < 1

    puts 'The Collatz Conjecture has strange and emergent behavior with numbers less than 1'
  end
  next
end
START = collatz.freeze
peak = START
CCExtras.write_to_file COLLATZ_FILE, "Start: #{START}\n", false

while collatz > 1
  if collatz.even?
    collatz /= 2
  else
    collatz = collatz * 3 + 1
    peak = collatz if collatz > peak
  end
  CCExtras.write_to_file COLLATZ_FILE, "Step #{steps += 1}: #{collatz}\n", true
end

puts "#{START} reached 1 in #{steps} steps\
\nIts peak was #{peak}\
\n\nFull path is in the file named \"Ruby-CollatzFile.txt\"\n"
CCExtras.write_to_file COLLATZ_FILE, "#{START} reached 1 in #{steps} steps\nIts peak was #{peak}", true
