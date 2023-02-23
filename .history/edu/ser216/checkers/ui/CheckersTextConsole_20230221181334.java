package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {
        StringBuilder boardString = new StringBuilder();

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                boardString.append(game.getSquare(row, column)).append("|");
            }
            boardString.append("\n");
        }

        boardString.append(" a b c d e f g h");

        return boardString.toString();
    }
}