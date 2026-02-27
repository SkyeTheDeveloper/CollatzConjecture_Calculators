# frozen_string_literal: true

require_relative 'cc_extras'

print "\x1b[H\x1b[2J"
collatz = 0
steps = 0
COLLATZ_FILE = 'Ruby-CollatzFile.txt'

loop do
  print 'What number would you like to run through the Collatz Conjecture: '
  collatz = gets.to_i
  break if collatz >= 1

  puts 'The Collatz Conjecture has strange and emergent behavior with numbers less than 1'
end
START = collatz
peak = START
CCExtras.write_to_file COLLATZ_FILE, "Start: #{START}\n", false

while collatz > 1
  steps += 1
  if collatz.even?
    collatz /= 2
  else
    collatz = collatz * 3 + 1
    peak = collatz if collatz > peak
  end
  CCExtras.write_to_file COLLATZ_FILE, "Step #{steps}: #{collatz}\n", true
end

puts <<~MSG
  #{START} reached 1 in #{steps} steps
  Its peak was #{peak}

  Full path is in the file named "#{COLLATZ_FILE}"
MSG
CCExtras.write_to_file COLLATZ_FILE, "#{START} reached 1 in #{steps} steps\nIts peak was #{peak}", true
