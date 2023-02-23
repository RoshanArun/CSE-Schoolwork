package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {

        public void displayBoard() {
            for (int row = 0; row < 8; row++) {
                System.out.printf("%d", 8 - row);
                for (int column = 0; column < 8; column++) {
                    System.out.printf("|%s", board[row][column]);
                }
                System.out.println('|');
            }
            System.out.println("  a  b  c  d  e  f  g  h");
        }
    }

}
