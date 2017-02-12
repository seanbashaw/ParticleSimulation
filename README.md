# ParticleSimulation
A Particle Simulator Built For BrickHacks 3
Constructed by Jacob Mekker, Sean Bashaw, Connor Henley, and Federico Rueda (2/11-12/17)

Simulates thousands of colliding particles with weighted velocities in order to test the
 ideal gas law with the kinetic theory of gases.


Uses a Quad-tree search algorithm to reduce collision detection complexity.
Uses Multithreading to decrease computation time.
Uses OpenGL (LWJGL) for the GUI.

Use the sliders on the right hand side of the program to changed the number of particles,
 the Temperature, or mass of the particles.


HOW TO RUN:
- Run "Launch.bat"
- Enjoy!


KNOWN BUGS:
- Possible crashing on extreme settings (most likely fixed)
- Memory leak with theads, slows down after ~5 minutes
- When resetting particle velocity, particle distribution is broken
