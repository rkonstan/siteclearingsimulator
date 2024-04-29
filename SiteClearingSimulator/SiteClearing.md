## Site Clearing Simulator

_What we know from requirements:_
- Inputs include the width and height (dimensions) of site area
- Inputs include a command from trainee
- Based on the example inputs, trainee enters one command at a time
- The bulldozer can only move forward

_Implementation steps to fulfill requirements:_
- Ensure bulldozer is in starting position of 0,0,E when turned on
  - A0
  - " " 
  - A0
- Ensure bulldozer is in position 2,1,N with command inputs 
  - A2
  - L
  - A1
- Ensure bulldozer is in starting position of 0,0,E when command entered is negative number
  - A-3
  - L
  - A-1
- Ensure bulldozer is in starting position of 0,0,E when command entered is larger than site area
  - A6
  - L
  - A8
- Ensure bulldozer is in position 4,3,E when commands given 
  - A4
  - L
  - A3
  - R



