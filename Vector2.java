package com.company;
import javax.imageio.ImageIO;


/* *********************************
 * Vector2 class for storing and drawing simple 2D Vectors
 *
 * Created by Dylan Fries 2018
 * v 0.1 Nov 13 2018 - Added Vector Rotation
 ************************************/
public class Vector2{
    public double x;
    public double y;

    // empty vector
    public Vector2(){
        x = 0;
        y = 0;
    }

    // Constructor that takes two variables
    public Vector2(double newX, double newY){
        x = newX;
        y = newY;
    }

    // add another vector to this vector
    public void addVector(Vector2 addedVector){
        x = x + addedVector.x;
        y = y + addedVector.y;
    }

    // subtracts a given vector (parameter) from this vector
    public void subtractVector(Vector2 subtractedVector){
        x = x - subtractedVector.x;
        y = y - subtractedVector.y;
    }

    public void multiplyByScalar(double scaler){
        x = x * scaler;
        y = y * scaler;
    }

    public Vector2 rotateByDegrees(double degreesToRotate){
        double rads = degreesToRotate * 0.017453292;
        return rotateByRads(rads);
    }

    // returns a new vector2 that is rotated by degrees around the axis
    public Vector2 rotateByRads(double radsToRotate){
        Vector2 returnVector = new Vector2();
        returnVector.x = (this.x * Math.cos(radsToRotate)) - (this.y * Math.sin(radsToRotate));
        returnVector.y = (this.x * Math.sin(radsToRotate)) + (this.y * Math.cos(radsToRotate));
        return returnVector;
    }

    // Non-editing methods
    // Gets the magnitude
    public double getMagnitude(){
        // square root of vx^2 + vy^2
        return Math.sqrt(x * x + y * y);
    }

    // gets the normalized vector
    public Vector2 getNormalized(){
        double mag = this.getMagnitude();
        Vector2 returnVector = new Vector2(x,y);

        if( mag > 0){
            // to normalize a vector, divide each component by its magnitude
            returnVector.multiplyByScalar(1/mag); // dividing a vector is multiplying by its inverse
        }else{
            returnVector = new Vector2(); // returna zerod vector
        }

        return returnVector;
    }

    // return a copy of a vector
    public Vector2 copyVector(){
        return new Vector2(x, y);
    }

    // Return a vector string in the format v(x,y) where x and y are the coordinates.
    public String toString(){
        return " v(" + x + "," + y + ") ";
    }

    // Static methods
    // draws a line between
    public static void drawLine(Vector2 startingLocation, Vector2 endingLocation){
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(startingLocation.x, startingLocation.y, endingLocation.x, endingLocation.y);
    }

    // draws vector distance from a starting point
    public static void drawRay(Vector2 startingLocation, Vector2 direction){
        Vector2 offsetPosition = Vector2.staticAddVectors(startingLocation, direction);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(startingLocation.x, startingLocation.y, offsetPosition.x, offsetPosition.y);
    }

    // ** Vector2 static methods
    public static Vector2 staticAddVectors(Vector2 first, Vector2 second){
        Vector2 returnValue = new Vector2(first.x + second.x, first.y + second.y);
        return returnValue;
    }

    public static double getDistance(Vector2 firstVector, Vector2 secondVector){
        // Hypotenuse of the triangle formed by two vectors (and an imaginary third point forming a right triangle.)
        double distance = Math.hypot(firstVector.x - secondVector.x, firstVector.y - secondVector.y);
        return distance;
    }

}