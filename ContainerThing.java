package com.company;
import java.util.ArrayList;

// Holds other Things. Will calculate the weight of all things it is carrying.
public class ContainerThing extends Thing{

    // All the Things stored in the Container.
    private ArrayList<Thing> things;
    //The maximum capacity. Anything added beyond this value should be refused.
    private double maxWeightCapacity;

    // Basic version
    public ContainerThing(){
        super();

        things = new ArrayList<Thing>();
        maxWeightCapacity = 10.0;

    }

    // This includes a list of all Things in the ArrayList as well.
    public String toStringLong(){
        String temp = super.toString() + " is a container holding:";
        for(int i =0 ; i < things.size(); i++){
            temp += "\n" + things.get(i).toString();
        }
        temp += "\nwith a total weight of " +totalWeight() + " and a max weight of " + maxWeightCapacity();
        return temp;
    }

    // Overrides Thing totalWeight
    public double totalWeight(){
        return totalWeightHelper(things.size());
    }
    // Calculates the total weight of all things in the container.
    public double totalWeightHelper(int n){
        if(n<=0){
            return 0;
        }
        return (totalWeightHelper(n-1) + things.get(n-1).totalWeight());
    }

    // max total amount of weight that can be carried.
    public double maxWeightCapacity(){
        return maxWeightCapacity;
    }

    private double calcWeightOfThings(){
        double tempWeight = 0;
        for(int i = 0; i < things.size(); i++){
            tempWeight += things.get(i).totalWeight();
        }


        return tempWeight;
    }

    // try to add an amount of things to the class.
    public boolean addThing(Thing newThing){
        if(maxWeightCapacity() - (calcWeightOfThings() + newThing.totalWeight()) >= 0){
            things.add(newThing);
            newThing.setDrawn(false);
            return true;
        }else{
            System.out.println("Not enough space in " + name + " for " + newThing.toString());
            return false;
        }
    }

    // try to remove an amount from the Thing.
    public Thing removeThing(Thing newThing){
        int contained = things.indexOf(newThing);
        Thing toRemove = null;
        // if found.
        if(contained >= 0 ){
            // found
            toRemove = things.get(contained);
            things.remove(contained);
            toRemove.setDrawn(true); // draw again
        }

        return toRemove;
    }

}
