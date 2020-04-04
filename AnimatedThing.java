package com.company;
import java.util.ArrayList;

// The AnimatedThing is a Thing that can move towards a goal.
public class AnimatedThing extends Thing{

    // point to move towards.
    protected Vector2 destination;
    private double reachedGoalThreshold = 0.02;

    // Distance to move per frame OR you can store it as distance per second and convert it to frame by dividing 1/time per frame (with the frame time set by the show(int milliseconds) call to StdDraw).
    protected double movementSpeed = .01;
    protected boolean isMoving = false; // only used as a flag for animation or AI.
    protected boolean hasReachedThreshold = false;
    private boolean hasGoal = false;

    private boolean DEBUG_DRAW = false;
    private boolean DEBUG_LOGS = false;
    // Set a new position for this object to move towards.
    // return false if it is an invalid destination
    public boolean setDestination(Vector2 position){
        destination = position;
        hasGoal = true;
        isMoving = true;
        return destination.x == position.x && destination.y == position.y;
    }

    public AnimatedThing(){
        super();
        // random movement to a random goal.
        setDestination(new Vector2(Math.random(), Math.random()));
    }

    public AnimatedThing(Vector2 startPosition){
        super();
        position = startPosition;
    }

    public boolean isHasReachedThreshold() {
        return hasReachedThreshold;
    }

    public void setHasReachedThreshold(boolean hasReachedThreshold) {
        this.hasReachedThreshold = hasReachedThreshold;
    }

    // Tell the animated Thing to update itself.
    public void update(){

        if(hasGoal){
            // goal condition reached
            if(Vector2.getDistance(super.position, destination) < reachedGoalThreshold){
                // reached goal
                this.hasReachedThreshold = true;
                // find next goal
                reachedGoal();
                setPosition(destination);
            }else{
                // continue moving.
                isMoving = true;
                // move towards
                moveTowards(destination);

            }
        }
        // if we have no goal, do nothing.
    }

    // Does the Thing currently have a goal?
    public boolean hasGoal(){
        return hasGoal;
    }

    // move towards a given position at appropriate speed
    // Converts the goal from a point in space to a vector from current position to goal position,
    // then normalizes it and multiplies by the speed to get the next frames movement vector.
    protected void moveTowards(Vector2 goalInput){

        if(DEBUG_DRAW){
            Vector2.drawLine(position, destination);
        }

        if(DEBUG_LOGS){
            System.out.println("Position: " + position.toString() + " Goal:" + destination.toString());
        }

        Vector2 goal = goalInput.copyVector();

        // This is the Goal Position - CurrentPosition = Vector from current to goal
        goal.subtractVector(position); // position is in super, edits the goal vector itself. .
        // normalized vector to goal (length 1)
        Vector2 normVector = goal.getNormalized();
        // Get the movement vector (Vector from current to next frame) by multiplying the
        // direction (normalized vector) with the movementSpeed (distance moved per frame scalar value).
        normVector.multiplyByScalar(movementSpeed);

        // This gives us the movement to be applied next frame.
        Vector2 moveVector = Vector2.staticAddVectors(position, normVector);
        move(moveVector); // apply the move.

    }

    // Move the Thing by the given vector. This is the final move for next frame
    // including both direction and magnitude.
    private void move(Vector2 movementVector){

        if( DEBUG_DRAW ){
            Vector2.drawLine(position, movementVector);
        }

        position = movementVector; // update the position
    }

    // Simply sets the AnimatedThing to the provided position.
    private void setPosition(Vector2 position){
        super.position = position;
    }

    // Reached the goal. What now?
    protected void reachedGoal(){
        hasGoal = false;
        isMoving = false;
    }

}
