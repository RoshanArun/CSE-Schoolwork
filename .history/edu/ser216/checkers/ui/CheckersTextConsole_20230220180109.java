package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {

        int row = 7;
        int col = 7;
        String[][] board = new String[8][8];
        String printboard = "";

        // Loop through the 2D array and populate it
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        board[i][j] = "O ";
                    } else {
                        board[i][j] = "X ";
                    }
                } else {
                    if (j % 2 == 0) {
                        board[i][j] = "X ";
                    } else {
                        board[i][j] = "O ";
                    }
                }
            }
        }

        // Print out the board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        return printboard;
    }

}
