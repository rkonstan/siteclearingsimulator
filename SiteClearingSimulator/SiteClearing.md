## Site Clearing Simulator

_Before a supervisor can work at a construction site, they are to be trained in how to coordinate with a bulldozer operator to clear the site in preparation for building. The training consists of interactive sessions with a simulator, which you will write._

_Application Requirements_
- Inputs
  - 1 - The width and length of the site map
  - 2 - Commands entered by the trainee during the simulation run

- Outputs
  - 1 - The position of the bulldozer
  - L
  - A1
- Commands
  - L: turn the bulldozer to left
  - R: turn the bulldozer to right
  - A{number}: this command takes a positive integer parameter and moves the bulldozer forward by {number} blocks

- For example, with the initial position of the bulldozer at (0, 0, E), given the following commands:
  - A2
  - L
  - A1
- The result position should be
  - 2,1,N

  