package com.company;

public class Vector2Tester {

    public static void main(String[] args){
        // test basic vectors
        Vector2 testVector = new Vector2(0,0);
        Vector2 testVector2 = new Vector2(1,3);
        Vector2 testVector3 = new Vector2(-5.6, + 7.89);

        // Test static adding, non permanent changes
        Vector2 staticAddVector = Vector2.staticAddVectors(testVector, testVector2);
        System.out.println("Test Static Add: " + testVector.toString() + " + " + testVector2.toString() + " = " + staticAddVector.toString());

        // Test adding methods
        System.out.print("Test addVector : "+ testVector.toString() + " + " + testVector3.toString() + " = ");
        testVector.addVector(testVector3); // test vector3 has been added to testVector
        System.out.println(testVector.toString());

        // test magnitude and normalization
        System.out.print(testVector3.toString() + " magnitude " + testVector3.getMagnitude());
        System.out.print(testVector3.toString() + " normalized " + testVector3.getNormalized());

        // Test out distance
        System.out.print("Distance: " + testVector.toString() + " to " + testVector2.toString() + " is " + Vector2.getDistance(testVector,testVector2));
        Vector2 zero = new Vector2();
        Vector2 one = new Vector2(1, 0);
        System.out.print("Distance: " + zero.toString() + " to " + one.toString() + " is " + Vector2.getDistance( zero, one));

        // Test Drawing
        StdDraw.show(0);

        while(true){
            //StdDraw.clear();//
            double xMouse = StdDraw.mouseX();
            double yMouse = StdDraw.mouseY();

            Vector2 mouseVector = new Vector2(xMouse, yMouse);

            // Test Draw Ray and overloaded constructor.
            Vector2.drawRay(new Vector2(), new Vector2(0.25,0.25));

            // test draw line and mouse input.
            Vector2.drawLine(new Vector2(), mouseVector);

            // test the scaler mulitpler by drawing another line
            Vector2 multipledVector = new Vector2(0.25,0.25);
            multipledVector.multiplyByScalar(3);
            Vector2.drawRay(new Vector2(0.1, 0), multipledVector);

            // Test the normalization stuff

            Vector2 normalizedVector = new Vector2(-1,1);
            Vector2.drawRay(new Vector2(1,0),  normalizedVector.getNormalized());
            //Vector2.drawRay(new Vector2(1,0), new Vector2(-0.5,0.5));

            // display and pause for 20 msec, giving 50 frames/sec
            StdDraw.show(20);
        }
    }
}
