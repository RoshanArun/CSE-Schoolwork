package edu.ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    public String printBoard(final CheckersGame game) {

        StringBuilder boardString = new StringBuilder();
        for (int row = 8; row > 0; row--) {
            boardString.append(row).append("|");
            for (int column = 0; column < 8; column++) {
                boardString.append(game.getSquare(row - 1, column)).append("|");
            }
            boardString.append("\n");
        }
        boardString.append("  A B C D E F G H\n");
        return boardString.toString();
    }

}
