package ser216.checkers.ui;

import edu.ser216.checkers.core.CheckersGame;

public class CheckersTextConsole implements CheckersViewer {

    /**
     * @param game
     * @return String
     */
    public String printBoard(final CheckersGame game) {
        // new strinbuilder
        StringBuilder sb = new StringBuilder();

        // loop to print out the board
        for (int row = 8; row > 0; row--) {
            sb.append(row + "|");
            for (int column = 0; column < 8; column++) {
                sb.append(game.getSquare(row - 1, column) + "|");
            }
            sb.append("\n");
        }
        sb.append("  a b c d e f g h\n");

        return sb.toString();
    }

}