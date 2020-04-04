package com.company;

import java.awt.event.*;

// A simple class that uses StdDraw to listen for arrow key input and stores it in an object form.
public class InputObject{

    private boolean[] rawInput; // Up Down Left Right
    private boolean debug_mode = true;

    private Vector2 inputVector;

    public InputObject(){
        rawInput = new boolean[4];
        inputVector = new Vector2();
    }

    public void updateInput(){
        inputVector = new Vector2();

        // Is UP key currently pressed?
        if( StdDraw.isKeyPressed(KeyEvent.VK_UP)){
            if(debug_mode)
                System.out.println("Up Pressed");
            rawInput[0] = true;

            inputVector.y +=1.0; // no smoothing
        }else{
            rawInput[0] = false;
        }

        // Is DOWN key currently pressed?
        if( StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
            if(debug_mode)
                System.out.println("Down Pressed");
            rawInput[1] = true;
            inputVector.y -=1.0; // no smoothing
        }else{
            rawInput[1] = false;
        }

        // Is LEFT key currently pressed?
        if( StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            if(debug_mode)
                System.out.println("Left Pressed");
            rawInput[2] = true;
            inputVector.x -=1.0; // no smoothing
        }else{
            rawInput[2] = false;
        }

        // Is RIGHT key currently pressed?
        if( StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
            if(debug_mode)
                System.out.println("Right Pressed");
            rawInput[3] = true;
            inputVector.x +=1.0; // no smoothing
        }else{
            rawInput[3] = false;
        }
    }

    public Vector2 getInputVector(){
        return inputVector;
    }

    public static void main(String[] args){

        InputObject input = new InputObject();

        input.updateLoop();

    }

    private void updateLoop(){

        while(true){

            updateInput();

            StdDraw.show(20);
        }
    }

}