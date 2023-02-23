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
                if (j % 2 == 1 && i % 2 == 0 && i < 3) {
                    printboard += "| o ";
                } else if (j % 2 == 0 && i % 2 == 1 && i < 3) {
                    printboard += "| o ";
                } else {
                    printboard += "| _ ";
                }

                if (j == 7) {
                    printboard += "|";

                }

            }
            printboard += "\n";
        }
        System.out.println(board[0][0]);
        return printboard;
    }

}
