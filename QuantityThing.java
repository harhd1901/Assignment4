package com.company;

// QuantityThing stores units of something. This could be used for
// many purposes including a health bar, coins, currency, etc.
public class QuantityThing extends Thing{

    //Unit of measurement ("Apples", "Dollars", etc)
    private String measurement;
    //The weight of one unit of the stored item (eg the weight of a single apple).
    private double weightPerUnit;
    //The quantity of what is stored (for example, the number of apples or dollars ).
    private int units;
    //The maximum capacity. Anything added beyond this value should be refused.
    private int maxCapacity;

    // Basic version
    public QuantityThing(){
        super();
        measurement = "Apples";
        weightPerUnit = .01;
        units = 0;
        maxCapacity = 10;
    }

    // [ ] Provide some overloaded Constructors later

    public String toStringLong(){
        return "A QuantityThing named " + name + " holding " + measurement + " . Currently holding " + units + " of " + maxCapacity;
    }

    // Overrides Thing totalWeight
    public double totalWeight(){
        double tempWeight = super.totalWeight();
        tempWeight += units * weightPerUnit;
        return tempWeight;
    }

    public int amount(){
        return units;
    }

    // Amount of space remaining
    public int remainingCapacity(){
        return maxCapacity - units;
    }

    // try to add an amount of things to the class.
    public boolean addStuff(int amount){
        if(remainingCapacity() >= amount){
            units += amount;
            return true;
        }else{
            System.out.println("Not enough space in " + name + " for " + amount + " of " + measurement);
            return false;
        }
    }

    // try to remove an amount from the Thing.
    public boolean removeStuff(int amount){
        if(amount <= units){
            units -= amount;
            return true;
        }else{
            System.out.println("Not enough " + measurement + " left in " + name + " to remove " + amount + " of " + measurement);
            return false;
        }
    }

}