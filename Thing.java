package com.company;

// A Thing is an Object that can be carried by a Person or put in a Place.
public class Thing{

    // Instance variables.
    protected String name; // Note: So far name must be set in Constructor
    protected String description;

    // A3 Varibles - Thing attributes.
    protected double weight; // in kg
    protected double value; // currency

    // A3 - Phase 2 - Drawing
    protected Vector2 position;
    protected String drawFile = "Person0.png"; // default value
    protected boolean isDrawn = true;

    public Thing(){
        this("defaultName", "defaultDescription"); // call the other constructor.
    }

    // Alternate way of assigning variables, using "this" keyword
    public Thing(String name, String description){
        this.name = name;
        this.description = description;

        // A3 Varibles - Thing attributes.
        weight = 1; // in kg
        value = 1; // currency

        // A3 - Phase 2 - Drawing
        this.position = new Vector2(0.5,0.5);
    }

    public Thing(String name, String description,
                 Vector2 position, String drawFile,
                 double value, double weight){
        this.name = name; // Note: So far name must be set in Constructor
        this.description = description;

        // A3 Varibles - Thing attributes.
        this.weight = weight; // in kg
        this.value = value; // currency

        // A3 - Phase 2 - Drawing
        this.position = position;
        this.drawFile = drawFile;
    }

    // returns the name of the Thing
    public String toString(){
        return name;
    }

    // "Accessor" method for description
    public String getDescription(){
        return description;
    }

    // Alternate way of assigning variables, using "this" keyword
    // "Mutator" method for description
    public void setDescription(String description){
        this.description = description;
    }


    // Weight
    public double totalWeight(){
        return weight;
    }

    // -- A3 methods to override --
    public void update(){} // do nothing but override

    // Drawing the drawFile to the current position.
    public void draw(){
        StdDraw.picture(position.x, position.y, drawFile);
    }

    // set drawn
    public void setDrawn(boolean isDrawn){
        this.isDrawn = isDrawn;
    }

    // not used by arrayList
    //  [ ] Make a point of showing this to the class
    public boolean equals(Thing other){
        System.out.println("equals (Thing other) called");
        if(this.toString().equals(other.toString())
                && this.getDescription().equals(other.getDescription())){
            return true;
        }else{
            return false;
        }
    }
    public void updateWeight(int n){
        this.weight = n;
    }
    // not used by arrayList
    public boolean equals(Object other){
        System.out.println("equals (Object other) called");
        boolean toReturn = false;

        // If the other Object is not a Thing then it cannot be the same.
        if( other instanceof Thing){
            Thing otherThing = (Thing)other;
            // compare by string in this case. Compare name and description
            if(this.toString().equals(otherThing.toString())
                    && this.getDescription().equals(otherThing.getDescription())){
                toReturn = true;
            }else{
                toReturn = false;
            }
        }else{
            toReturn = false;
        }

        return toReturn;
    }

}
