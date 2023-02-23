package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {

        int row = 8;
        int col = 8;
        String[][] board = new String[8][8];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[row][col] = "| |";
            }
        }

        return "  \n\nasdfasdf ";
    }

}
