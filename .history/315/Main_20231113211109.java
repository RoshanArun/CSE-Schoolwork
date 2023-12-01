package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Control classes
        ReviewManagement reviewControl = new ReviewManagement();
        DevManagement devControl = new DevManagement();
        GameManagement gameControl = new GameManagement();
        GamerManagement gamerControl = new GamerManagement();

        // Create a bunch of gamers, games, reviews, and devs
        Gamer gamer1 = new Gamer("Alice");
        Gamer gamer2 = new Gamer("Bob");
        Game game1 = new Game(1, "Game A");
        Game game2 = new Game(2, "Game B");
        Dev developer1 = new Dev("Developer X");

        // Link gamers, games, and devs
        gamerControl.addGamer(gamer1);
        gamerControl.addGamer(gamer2);
        devControl.addDev(developer1);
        gameControl.addGame(game1);
        gameControl.addGame(game2);

        // Link games to gamers and reviews
        gamerControl.linkGameToGamer(gamer1, game1);
        gamerControl.linkGameToGamer(gamer2, game2);

        // Test the addReview method
        reviewControl.createReview(gamer1, game1, "Great game!", 5);
        reviewControl.createReview(gamer2, game2, "Not bad.", 4);
        reviewControl.createReview(gamer1, game1, "Awesome!", 5); // Would print that the gamer already reviewed the
                                                                  // game

        // Display the current state of the system
        displaySystemState(gamerControl, gameControl, reviewControl, devControl);
    }

    private static void displaySystemState(
            GamerManagement gamerControl,
            GameManagement gameControl,
            ReviewManagement reviewControl,
            DevManagement devControl) {
        // Print information about gamers, games, reviews, and devs
    }
    // remaining functions abstracted, just using what's necessary for assignment
}
