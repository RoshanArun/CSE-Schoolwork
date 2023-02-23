package edu.ser216.checkers.core;

import java.util.Scanner;

public class CheckersGameLogic implements CheckersGame {
    private int turn = 0;
    private char[][] board;
    private Scanner scan;

    // implements and creates basic checkers board using a 2d array and x/o tokens
    public CheckersGameLogic(Scanner scan) {
        this.scan = scan;
        board = new char[8][8];

        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (row < 3 && (column + (row % 2)) % 2 != 1) {
                    board[row][column] = 'x';
                } else if (row > 4 && (column + (row % 2)) % 2 != 1) {
                    board[row][column] = 'o';
                } else {
                    board[row][column] = '_';
                }
            }
        }

    }

    /**
     * @param row
     * @param column
     * @return char
     */
    @Override
    // returns the value of a certain box of the checkers board
    public char getSquare(int row, int column) {
        return board[row][column];
    }

    @Override
    // sets the value of a certain box of the checkers board
    public void setSquare(int row, int column, char content) {
        board[row][column] = content;
    }

    @Override
    public void doTurn() {

        // Prompts user for input
        String input = scan.nextLine();

        if (input.length() != 5) {
            System.out.println("This move is invalid");
            doTurn();
        }

        char number = input.charAt(0);
        char letter = input.charAt(1);
        char number2 = input.charAt(3);
        char letter2 = input.charAt(4);

        int startRow = charToInt2(number);
        int startCol = charToInt(letter);
        int endRow = charToInt2(number2);
        int endCol = charToInt(letter2);

        System.out.println(startRow);

        char startContent = getSquare(startRow, startCol);

        // checks to see if the move to be made is valid or not
        if (isValidMove(startRow, startCol, endRow, endCol)) {

            setSquare(startRow, startCol, '_');
            setSquare(endRow, endCol, startContent);
            turn++;
        } else {
            System.out.println("This move is invalid");
            doTurn();
        }

    }

    private boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {

        if (endRow < 0 || endRow > 7 || endCol < 0 || endCol > 7) {
            return false;
        }

        if (startRow < 0 || startRow > 7 || startCol < 0 || startCol > 7) {
            return false;
        }

        // checks if the piece exists
        if (getSquare(startRow, startCol) == '_') {
            return false;
        }

        // checks if there is no movement
        if (startRow == endRow && startCol == endCol) {
            return false;
        }

        // checks if the movement is diagonal
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol)) {
            return false;
        }

        // check if destination is occupied
        if (getSquare(endRow, endCol) != '_') {
            return false;
        }

        // checks if the movement is greater than two
        if (Math.abs(endRow - startRow) > 2) {
            return false;
        }

        // checks if the destination is an opponent piece
        if (board[endRow][endCol] == 'x' && board[startRow][startCol] == 'o') {
            return false;
        }
        if (board[endRow][endCol] == 'o' && board[startRow][startCol] == 'x') {
            return false;
        }

        // checks if the movement is the opposite direction of the team
        // check if the direction of the movement is opposite
        // checks if the movement is going in the opposite direction from the current
        // player
        if (startRow - endRow > 0 && turn % 2 == 0 ||
                startRow - endRow < 0 && turn % 2 == 1) {
            return false;
        }

        // check if movement is further than one
        if (Math.abs(startRow - endRow) == 2) {
            int middleRow = (startRow + endRow) / 2;
            int middleCol = (startCol + endCol) / 2;
            char middleContent = getSquare(middleRow, middleCol);
            char startContent = getSquare(startRow, startCol);
            // check if friendly piece is in the middle
            if (middleContent == startContent || middleContent == '_') {
                return false;
            } else {
                setSquare(middleRow, middleCol, '_');
            }
        }

        // Check if the piece belongs to the current player
        if (turn % 2 == 0 && getSquare(startRow, startCol) == 'o' ||
                turn % 2 == 1 && getSquare(startRow, startCol) == 'x') {
            return false;
        }

        // returns true if all criteria is met
        return true;
    }

    @Override
    public char getWinningPlayer() {
        int xPieces = 0;
        int oPieces = 0;
        int xMoves = 0;
        int oMoves = 0;
        // check all squares
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                char currentSquare = getSquare(row, column);
                // if square isn't empty
                if (currentSquare != '_') {
                    // check if it can make any moves
                    if (isValidMove(row, column, row + 1, column + 1) ||
                            isValidMove(row, column, row + 1, column - 1)) {
                        // if so set moves to true
                        if (currentSquare == 'x') {
                            System.out.println("test");
                            xMoves++;
                        }
                    }
                    // count pieces
                    if (currentSquare == 'x') {
                        xPieces++;
                    } else {
                        oPieces++;
                    }
                }

            }
        }

        System.out.println(xPieces);
        System.out.println(oPieces);
        System.out.println(xMoves);
        System.out.println(oMoves);
        // if either player has no pieces or no moves they lose
        if (xPieces == 0 || xMoves == xPieces) {
            return 'o';
        } else if (oPieces == 0 || oMoves == oPieces) {
            return 'x';
        } else {
            return '_';
        }
    }

    @Override
    // checks and keeps track of who's turn is next
    public void nextTurn() {
        if (turn == 0 || turn % 2 == 0) {
            System.out.println(
                    "\nPlayer X - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h");
        } else {
            System.out.println(
                    "\nPlayer O - your turn. \nChoose a cell position of piece, 3a-4b 3g-4h");
        }
    }

    @Override
    // prints the winner
    public void onEnd() {
        char winner = getWinningPlayer();
        if (winner == 'x') {
            System.out.println("Player X wins!");
        } else if (winner == 'o') {
            System.out.println("Player O wins!");
        }
    }

    // align the letters to columns
    public int charToInt(char c) {

        int column;
        if (c == 'a') {
            column = 0;
        } else if (c == 'b') {
            column = 1;
        } else if (c == 'c') {
            column = 2;
        } else if (c == 'd') {
            column = 3;
        } else if (c == 'e') {
            column = 4;
        } else if (c == 'f') {
            column = 5;
        } else if (c == 'g') {
            column = 6;
        } else {
            column = 7;
        }
        return column;
    }

    // align the numbers to properly represent the array
    public int charToInt2(int row2) {

        int row;
        if (row2 == '1') {
            row = 0;
        } else if (row2 == '2') {
            row = 1;
        } else if (row2 == '3') {
            row = 2;
        } else if (row2 == '4') {
            row = 3;
        } else if (row2 == '5') {
            row = 4;
        } else if (row2 == '6') {
            row = 5;
        } else if (row2 == '7') {
            row = 6;
        } else {
            row = 7;
        }
        return row;
    }

}