package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    /**
     * @param game
     * @return String
     */
    public String printBoard(final CheckersGame game) {

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 8; row++) {
            sb.append(8 - row);
            sb.append(" ");

            for (int col = 0; col < 8; col++) {
                sb.append("|");
                sb.append(game.getSquare(row, col));
                sb.append("");
            }

            sb.append("|\n");
        }
        sb.append("    a   b   c   d   e   f   g   h\n");

        return sb.toString();
    }

}
