# CitySim
A light-hearted and not at all serious attempt at simulating a cityModel.

By aseriesofdarkcaves and gui

## Implemented
- Form-based GUI that contains:
   - a 2D map of generated city (initially blank)
   - user input fields for the parameters used to generate a cityModel
   - the ability to generate and regenerate a cityModel based on the user input fields
   - read-only section to show the last generated parameters
- The program should generate a plan/map of the city with various tile types
   - use strategy pattern to decouple generation algorithms from the city

## Current Goals
- Implement a generation strategy that isn't random (i.e. roads connect)

## Future Goals
- Simulation:
   - add time - the ability for things to change within the city
   - ability to speed up or slow down time
- Add citizens:
   - citizens have various goals and go about their daily tasks
- Add transport:
   - automobiles
   - public transport
