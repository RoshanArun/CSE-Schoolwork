package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    /**
     * @param game
     * @return String
     */
    public String printBoard(final CheckersGame game) {

        int row = 7;
        int col = 7;
        int test = 8;
        String printboard = "";

        for (int i = 0; i <= row; i++) {
            printboard += test = " ";

            for (int j = 0; j <= col; j++) {
                if (j % 2 == 1 && i % 2 == 0 && i < 3) {
                    printboard += "| o ";
                } else if (j % 2 == 0 && i % 2 == 1 && i < 3) {
                    printboard += "| o ";
                }

                else if (j % 2 == 0 && i % 2 == 1 && i > 4) {
                    printboard += "| x ";
                } else if (j % 2 == 1 && i % 2 == 0 && i > 4) {
                    printboard += "| x ";
                }

                else {
                    printboard += "| _ ";
                }

                if (j == 7) {
                    printboard += "|";
                }
            }
            printboard += "\n";
            test--;
        }
        return printboard;
    }

}
