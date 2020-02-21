# com.asodc.citysim.dunno.CitySim
A light-hearted and not at all serious attempt at simulating a cityModel.

By: aseriesofdarkcaves and gui

## Initial Goals
- Form-based GUI that contains:
   - a 2D map of generated cityModel (initially blank)
   - user input fields for the parameters used to generate a cityModel
   - the ability to generate and regenerate a cityModel based on the user input fields
   - read-only section to show the last generated parameters
- The program should generate a plan of the cityModel with various tile types
   - use strategy pattern to decouple generation algorithms from the cityModel

## Future Goals
- Simulation:
   - add time to the cityModel (the ability for things to change within the cityModel)
   - ability to speed up or slow down time
- Add citizens:
   - citizens have various goals and go about their daily business as you'd expect from a real cityModel
- Add transport:
   - automobiles
   - public transport
