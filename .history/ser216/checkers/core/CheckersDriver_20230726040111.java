package ser216.checkers.core;

import ser216.checkers.ui.CheckersTextConsole;
import ser216.checkers.ui.CheckersViewer;

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
        CheckersGame gameP = new CheckersGameLogic(scan);
        CheckersGame gameC = new CheckersComputerPlayer(scan);
        CheckersViewer console = new CheckersTextConsole();
        String player = "";
        int one = 0;

        if (one == 0) {
            System.out.println(
                    "Begin Game. Enter P if you want to play against another player; enter C to play against computer.");
            one++;
            player = scan.nextLine();
        }

        if (player.equals("P")) {
            while (gameP.getWinningPlayer() == '_') {
                System.out.println(console.printBoard(gameP));
                gameP.doTurn();
                gameP.nextTurn();
            }
            gameP.onEnd();

        } else if (player.equals("C")) {
            while (gameC.getWinningPlayer() == '_') {
                System.out.println(console.printBoard(gameC));
                gameC.doTurn();
                gameC.nextTurn();
            }
            gameC.onEnd();
        }
    }
}
