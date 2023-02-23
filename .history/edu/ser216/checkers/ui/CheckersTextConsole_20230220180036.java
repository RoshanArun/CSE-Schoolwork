package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {

        int row = 7;
        int col = 7;
        String[][] board = new String[8][8];
        String printboard = "";

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        printboard += "| O ";
                    } else {
                        printboard += "| X ";
                    }
                } else {
                    if (j % 2 == 0) {
                        printboard += "| X ";
                    } else {
                        printboard += "| O ";
                    }
                }

            }
            printboard += "\n";
        }
        System.out.println(board[1][7]);
        return printboard;
    }

}
