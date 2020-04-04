package com.company;

import java.util.ArrayList;

// An example of how to use update and draw (this is a very "realtime systems" type architecture)
public class GameController {

    public static int frameTime = 20;

    public static void main(String[] args) {
        PlayerThing player = new PlayerThing();

        for (int i = 0; i < 5000; i++) {
            StdDraw.clear();
            player.update();
            player.draw();
            StdDraw.show(20); // draw and pause.
        }
            System.out.println("THE END");
            System.exit(0);// Quit normally

    }
}



