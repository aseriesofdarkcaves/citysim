# com.asodc.citysim.CitySim
A light-hearted and not at all serious attempt at simulating a city.

By: aseriesofdarkcaves and gui

## Initial Goals
- Form-based GUI that contains:
-- a 2D map of generated city (initially blank)
-- user input fields for the parameters used to generate a city
-- the ability to generate and regenerate a city based on the user input fields
-- read-only section to show the last generated parameters
- The program should generate a plan of the city with various tile types
-- use strategy pattern to decouple generation algorithms from the city

## Future Goals
- Simulation:
-- add time to the city (the ability for things to change within the city)
-- ability to speed up or slow down time
- Add citizens:
-- citizens have various goals and go about their daily business as you'd expect from a real city
- Add transport:
-- automobiles
-- public transport
