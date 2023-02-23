package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            sb.append(8 - row).append("|");
            for (int column = 0; column < board[row].length; column++) {
                sb.append(board[row][column]);
                sb.append("|");
            }
            sb.append("\n");
        }
        sb.append("  ");
        for (int i = 0; i < board.length; i++) {
            sb.append((char) ('a' + i));
            sb.append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

}
