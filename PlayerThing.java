package com.company;

// PlayerThing accepts input from the InputObject class and
// translates that into movement.
public class PlayerThing extends AnimatedThing{

    // Cache the input vector. V2.y is vertical axis, V2.x is horizontal.
    private Vector2 inputVector;
    // InputObject polls the keyboard input and returns a Vector2 representation
    private InputObject input;

    // Debugging.
    private boolean DEBUG_LOGS = true;
    private boolean DEBUG_RAYS = true;

    public PlayerThing(){
        input = new InputObject();
    }

    // Update the player input by getting the vector from InputObject
    // This is just the arrow keys mapped to a V2 (up is +Y, Right is +X)
    public void update(){
        // Tell the InputObject to check the keyboard for updated input values
        // This needs to get called before getInputVector
        input.updateInput();
        // Poll the input
        inputVector = input.getInputVector();

        if(DEBUG_RAYS){
            // Debug the input
            // Draws a red ray centered in the screen.
            Vector2.drawRay(new Vector2(.5,.5), inputVector); // just input
        }

        // Calculate the goal position.
        Vector2 goal = Vector2.staticAddVectors(position, inputVector);

        if(DEBUG_RAYS){
            // Debug the movement calculation. Blue line from the Player to the Goal .
            Vector2.drawLine(position, goal);
        }

        if(DEBUG_LOGS){
            System.out.println("Position: " + position.toString() + " Goal:" + destination.toString());
        }

        // Update the position and move towards the goal.
        moveTowards(goal);

        // I want to stop it only when the next step puts me out of range.
		/* This doesn't work to do what I want it to (keep in bounds of the screen)
		// can you spot the error?
		if(goal.x >= 0 && goal.x <= 1.0 && goal.y >= 0 && goal.y <= 1.0){
			moveTowards(goal);
		}
		*/
    }
}