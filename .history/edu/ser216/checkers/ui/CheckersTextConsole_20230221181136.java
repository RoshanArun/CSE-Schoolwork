package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {
        final StringBuilder builder = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            builder.append(8 - row).append('|');
            for (int column = 0; column < 8; column++) {
                builder.append(game.board[row][column]).append('|');
            }
            builder.append('\n');
        }
        builder.append("  ").append("a b c d e f g h");
        return builder.toString();
    }
}