!  SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
! 
!  This Source Code Form is subject to the terms of the Apache License,
!  v. 2.0.
!  If a copy of the Apache License was not distributed with this file,
!  You can obtain one at http://www.apache.org/licenses/LICENSE-2.0.
! 
!  Alternatively, this Source Code Form is subject to the terms of the
!  GNU Lesser General Public License, v. 3.0 or later. If a copy of the
!  LGPL was not distributed with this file, You can obtain one at
!  https://www.gnu.org/licenses/lgpl-3.0.html.
! 
!  Copyright 2026 Skylar Koningin

program main
    use, intrinsic :: iso_c_binding
    implicit none
    
    character(len=1), parameter :: esc = achar(27)
    integer(kind=c_int64_t) :: collatz = 0, start = 0, peak = 0
    integer(kind=8) :: steps = 0
    character(len=23), parameter :: collatz_file = "Fortran-CollatzFile.txt"
    integer, parameter :: cf_fp = 13
    print '(A)', esc // '[2J' // esc // '[H'
    open(unit=cf_fp, file=collatz_file, status='replace', action='write')
    
    do while (collatz == 0)
        print *, 'What number would you like to run through the Collatz Conjecture?'
        read (*, '(I20)') collatz
        if (collatz < 1) then
            print *, 'The Collatz Conjecture has strange and emergent behavior with numbers less than one.'
            collatz = 0
        end if
    end do
    start = collatz
    peak = start
    write(cf_fp, *) 'Start: ', start
    
    do while (collatz > 1)
        steps = steps + 1
        if (modulo(collatz, 2) == 0) then
            collatz = collatz / 2
        else
            if (collatz > (huge(collatz) - 1) / 3) then
                print *, start, ' overflowed on step ', steps
                print *, 'Exiting...'
                write(cf_fp, *) start, ' overflowed on step ', steps
                write(cf_fp, *) 'Program exited with error: ULong Integer Overflow'
                stop 1
            else
                collatz = collatz * 3 + 1
                if (collatz > peak) then
                    peak = collatz
                end if
            end if
        end if
        write(cf_fp, *) 'Step ', steps, ': ', collatz
    end do
    
    print *, start, ' reached 1 in ', steps, ' steps'
    print *, 'Its peak was ', peak
    print *
    print *, 'Full path is in the file names "', collatz_file, '"'
    write(cf_fp, *) start, ' reached 1 in ', steps, ' steps'
    write(cf_fp, *) 'Its peak was ', peak
end program main