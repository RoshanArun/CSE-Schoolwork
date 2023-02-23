package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 8; row++) {
            sb.append(row + "|");
            for (int column = 7; column > 0; column--) {
                sb.append(game.getSquare(row, column) + "|");
            }
            sb.append("\n");
        }
        sb.append("  a b c d e f g h\n");

        return sb.toString();
    }

}
