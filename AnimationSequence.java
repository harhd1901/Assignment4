package com.company;

public class AnimationSequence extends AnimatedThing {
    private LinkedList vector2Waypoint;

    public LinkedList getVector2Waypoint() {
        return vector2Waypoint;
    }

    public AnimationSequence() {
        super();
        vector2Waypoint = new LinkedList();
    }

    /* addWaypoint - will add a new waypoint to the front of the list. This should also
    set the current destination to the new position */
    public void addWaypoint(Vector2 point) {
        vector2Waypoint.add(point);
        super.moveTowards(point);
    }

    /* drawPath - will draw a path from the current position, through all the remaining points on the
     current path. */
    public void drawPath() {
       while (!vector2Waypoint.isEmpty()) {
           vector2Waypoint.drawLine();
           if(vector2Waypoint.size()!= 1){
               boolean dest = super.setDestination(vector2Waypoint.remove());
               if(dest){
                   super.update();
               }
           }else {
               reachedGoal();
           }

        }
    }

    /* setSequence - will accept a LinkedList as input. It should
    immediately reset any current animations and use the new sequence as the new path to follow.*/
    public void setSequence(LinkedList sequence) {
        vector2Waypoint = sequence.deepCopy();
        setHasReachedThreshold(false);
        super.update();
        if(isMoving) {
            drawPath();
        }
    }

    /* insertWaypoint - will add a new waypoint to the current
        LinkedList of waypoints, at the specified index */
    public void insertWaypoint(int index, Vector2 point){
        vector2Waypoint.insert(index, point);
    }

    /* addLastWayPoint - will add a new waypoint to the end of the LinkedList. It should not affect
      the current animation sequence */
    public void addLastWaypoint(){
        Vector2 newVector2 = new Vector2();
        vector2Waypoint.addLast(newVector2);
        if(vector2Waypoint.size() == 1){
            super.update();
        }
    }

    /* reachedGoal - create a new version that can detect
        whether a waypoint is reached and a new waypoint needs to be set or the end of the path is reached. */
    @Override
    public void reachedGoal(){
        if(hasGoal() && !isHasReachedThreshold()){
            addLastWaypoint();
        }else {
            super.reachedGoal();
            vector2Waypoint.remove();
            return;
        }

    }
}
