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
                    board[i][j] = "| o ";
                } else if (j % 2 == 0 && i % 2 == 1 && i < 3) {
                    board[i][j] = "| o ";
                } else {
                    board[i][j] = "| _ ";
                }
                if (j == 7) {
                    board[i][j] = "|";
                }

                // if (j % 2 == 0 && i % 2 == 1 && i > 6) {
                // board[i][j] = "| x ";
                // } else if (j % 2 == 1 && i % 2 == 0 && i > 6) {
                // board[i][j] = "| x ";
                // }
            }
        }

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (j % 2 == 1 && i % 2 == 0 && i < 3) {
                    printboard += "| o ";
                } else if (j % 2 == 0 && i % 2 == 1 && i < 3) {
                    printboard += "| o ";
                }

                if (j % 2 == 0 && i % 2 == 1 && i > 4) {
                    printboard += "| x ";
                }
                // else if (j % 2 == 1 && i % 2 == 0 && i > 4) {
                // printboard += "| x ";
                // }

                else {
                    printboard += "| _ ";
                }
                if (j == 7) {
                    printboard += "|";
                }

            }
            printboard += "\n";
        }

        return printboard;
    }

}
