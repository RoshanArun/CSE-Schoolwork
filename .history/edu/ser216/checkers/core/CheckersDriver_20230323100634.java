package edu.ser216.checkers.core;

import edu.ser216.checkers.ui.CheckersTextConsole;
import edu.ser216.checkers.ui.CheckersViewer;

import java.util.Scanner;

/**
 * This class provides the entry to run the checkers game. It also provides the
 * main game play loop
 * that calls methods from the two user-created classes (CheckersGameLogic and
 * CheckersTextConsole).
 *
 * The contents of this file should not be changed.
 * 
 * 
 * @author Acuna, Baron
 * @version 1.0
 */
public class CheckersDriver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CheckersGame game = new CheckersGameLogic(scan);
        CheckersViewer console = new CheckersTextConsole();
        int one = 0;

        // basic game play loop.
        while (game.getWinningPlayer() == '_') {
            System.out.println(console.printBoard(game));

            if (one == 0) {
                System.out.println(
                        "Begin Game. Enter ‘P’ if you want to play against another player; enter ‘C’ to play against computer.");
                String comp = scan.nextLine();

                if (comp == "P") {
                    game.doTurn();
                    one++;
                } else if (comp == "C") {
                    game.doCompTurn();
                    one++;
                }
            }

            game.doTurn();
            game.nextTurn();
        }
        game.onEnd();
    }

}
