package com.company;

import java.util.ArrayList;

public class TestClass {
    public static void main(String[] args) {
        testContainerThing_totalWeight();
        testLinkedList();
        testCompareLinkedList();
        testDeepCopy();
        addListTest();

        testAddWayPoint();
        testSetSequence();
        testDuplicatePoints();
        testInsertWaypoint();
    }

    public static void testLinkedList(){
        LinkedList testList = new LinkedList();
        System.out.println("Test list should be empty: ");
        if(testList.isEmpty()){
            System.out.println("It is empty");
        }else{
            System.out.println("it is not.");
        }
    }

    //Testing Recursion
    public static void testContainerThing_totalWeight(){
        ContainerThing containerThing = new ContainerThing();
        Thing testObj1 = new Thing();
        testObj1.weight = 1;
        Thing testObj2 = new Thing();
        testObj2.weight = 5;
        Thing testObj3 = new Thing();
        testObj1.weight = 2;
        containerThing.addThing(testObj1);
        containerThing.addThing(testObj2);
        containerThing.addThing(testObj3);
        double result = containerThing.totalWeight();
        System.out.print("Test result for recursive method totalWeight() in ContainerThing : ");
        if(result == testObj1.weight+testObj2.weight+testObj3.weight){
            System.out.println("Passed!");
        }
        else{
            System.out.println("Failed!");
        }
    }

    //Testing LinkedList and AnimationSequence Classes and Methods

    public static void testAddWayPoint() {
        AnimationSequence animationSequence = new AnimationSequence();
        Vector2 testVector = new Vector2(0, 0);
        Vector2 testVector2 = new Vector2(1, 3);
        Vector2 testVector3 = new Vector2(-5.6, +7.89);

        animationSequence.addWaypoint(testVector);
        animationSequence.addWaypoint(testVector2);
        animationSequence.addWaypoint(testVector3);

        if (animationSequence.getVector2Waypoint().isEmpty()) {
            System.out.println("add way did not work.");
        } else {
            System.out.println("Test passed addwaypoint");
        }
    }
    public static void testDuplicatePoints() {
        AnimationSequence animationSequence2 = new AnimationSequence();
        Vector2 testVector = new Vector2(0,0);
        Vector2 testVector2 = new Vector2(0,0);
        Vector2 testVector3 = new Vector2(0,0);

        animationSequence2.addWaypoint(testVector);
        animationSequence2.addWaypoint(testVector2);
        animationSequence2.addWaypoint(testVector3);
        if (animationSequence2.position == testVector3) {
            System.out.println("Test passed .Duplicate edge case works.");
        } else {
            System.out.println("Test.");
        }
    }
    public static void testSetSequence() {
        AnimationSequence animationSequence = new AnimationSequence();
        Vector2 testVector = new Vector2(4,4);
        Vector2 testVector2 = new Vector2(1,2);
        Vector2 testVector3 = new Vector2(0,0);

        animationSequence.addWaypoint(testVector);
        animationSequence.addWaypoint(testVector2);
        animationSequence.addWaypoint(testVector3);
        animationSequence.drawPath();

        Vector2 testVector4 = new Vector2(21,20);
        Vector2 testVector5 = new Vector2(21,20);
        Vector2 testVector6 = new Vector2(21,20);
        LinkedList testLinkedList = new LinkedList();
        testLinkedList.add(testVector4);
        testLinkedList.add(testVector5);
        testLinkedList.add(testVector6);
        animationSequence.setSequence(testLinkedList);

        System.out.println("before position" + animationSequence.position);
        System.out.println("after replacing set sequence position" + testVector6.toString());
        System.out.println("final position" + testVector6.toString()+ "- passed");
    }

    public static void testInsertWaypoint(){
        AnimationSequence animationSequence = new AnimationSequence();
        Vector2 testVector = new Vector2(4,4);
        Vector2 testVector2 = new Vector2(1,2);
        Vector2 testVector3 = new Vector2(0,0);
        Vector2 testVector4 = new Vector2(21,20);


        animationSequence.addWaypoint(testVector);
        animationSequence.addWaypoint(testVector2);
        animationSequence.addWaypoint(testVector3);
        animationSequence.insertWaypoint(1,testVector4);
        LinkedList printList = animationSequence.getVector2Waypoint();
        LinkedList printListTwo = animationSequence.getVector2Waypoint();

        printListTwo.remove();
        if(printList.remove().equals(testVector4)){
            System.out.println("Insertion Test passed. ");
        }else{
            System.out.println("Test failed. ");
        }

    }

    public static void testCompareLinkedList(){

        AnimationSequence animationSequence = new AnimationSequence();
        Vector2 testVector = new Vector2(4,4);
        Vector2 testVector2 = new Vector2(1,2);
        Vector2 testVector3 = new Vector2(0,0);

        animationSequence.addWaypoint(testVector);
        animationSequence.addWaypoint(testVector2);
        animationSequence.addWaypoint(testVector3);
        AnimationSequence animationSequence2 = new AnimationSequence();
        Vector2 testVector4 = new Vector2(4,4);
        Vector2 testVector22 = new Vector2(1,2);
        Vector2 testVector32 = new Vector2(0,0);

        animationSequence2.addWaypoint(testVector4);
        animationSequence2.addWaypoint(testVector22);
        animationSequence2.addWaypoint(testVector32);

        int testInt = animationSequence.getVector2Waypoint().compareTo(animationSequence2.getVector2Waypoint());
        if(testInt==0){
            System.out.println("Equality Test Passed");
        }else {
            System.out.println("Equality Test failed");
        }

        animationSequence2.addWaypoint(testVector32);
        testInt = animationSequence.getVector2Waypoint().compareTo(animationSequence2.getVector2Waypoint());
        if(testInt==-1){
            System.out.println("unEquality Test Passed negative");
        }else {
            System.out.println("unEquality Test failed negative");
        }

        animationSequence.addWaypoint(testVector32);
        animationSequence.addWaypoint(testVector32);
        testInt = animationSequence.getVector2Waypoint().compareTo(animationSequence2.getVector2Waypoint());
        if(testInt==1){
            System.out.println("unEquality Test Passed positive");
        }else {
            System.out.println("unEquality Test failed positive");
        }

    }

    public static void testDeepCopy(){
        AnimationSequence animationSequence = new AnimationSequence();
        Vector2 testVector = new Vector2(4,4);
        Vector2 testVector2 = new Vector2(1,2);
        Vector2 testVector3 = new Vector2(0,0);

        animationSequence.addWaypoint(testVector);
        animationSequence.addWaypoint(testVector2);
        animationSequence.addWaypoint(testVector3);
        LinkedList testLinkedList = animationSequence.getVector2Waypoint().deepCopy();
        if(animationSequence.getVector2Waypoint().compareTo(testLinkedList)==0){
            System.out.println("Deep copy Test Passed");
        }else{
            System.out.println("Deep copy Test Failed");
        }

    }

    public static void addListTest(){
        AnimationSequence animationSequence = new AnimationSequence();
        Vector2 testVector = new Vector2(4,4);
        Vector2 testVector2 = new Vector2(1,2);
        Vector2 testVector3 = new Vector2(0,0);

        ArrayList<Vector2> newArrayList = new ArrayList<>();
        newArrayList.add(testVector);
        newArrayList.add(testVector2);
        newArrayList.add(testVector3);

        AnimationSequence animationSequence2 = new AnimationSequence();
        animationSequence2.addWaypoint(testVector);
        animationSequence2.addWaypoint(testVector2);
        animationSequence2.addWaypoint(testVector3);


        animationSequence.getVector2Waypoint().addList(newArrayList);
        if(animationSequence.getVector2Waypoint().compareTo(animationSequence2.getVector2Waypoint())==0){
            System.out.println("Add List Test Passed");
        }else{
            System.out.println("Add List Test Failed");
        }
    }
}
