Enigma
======

Java Simulation of the WWII Enigma machine

     java enigma.Main

runs the program.



Files in this distribution:

Makefile
          A configuration file for the 'gmake' program.  This allows
          you to perform common tasks: compiling your program, running
          tests and performing style checks on it, cleaning up
          unneeded files.  See the comment at the top of the file for 
          details.
test-correct
          A bash test script for testing correct inputs to the enigma program.
test-error
          A bash test script for testing erroneous inputs to the enigma program.

enigma    Directory containing the enigma package:

  enigma/Main.java
              Contains the main procedure: enigma.Main.main.
  enigma/Machine.java
              A suggested skeleton file for objects modeling Enigma
              machines.
  enigma/Rotor.java
              A suggested skeleton file for objects modeling rotors.
  enigma/Reflector.java
              A suggested skeleton file for objects modeling reflectors.
  enigma/PermutationData.java
              Static data describing the Enigma rotors and reflectors.
              
tests      Directory for test files.
              Contains files *.inp, *.out, and *.err, intended as test input
              files, expected output files, and erroneous input files
              for the enigma program.
              The Makefile is set up so that 'gmake check' runs each
              .inp file through your program and compares the
              results to the corresponding .out file.  It also runs each
              .err file through your program and checks that the program 
              reports an error according to the project specification.

   tests/trivial.in, tests/trivial.out
              Sample test file input and output.



