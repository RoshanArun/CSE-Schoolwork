package edu.ser216.checkers.core;

import java.util.Scanner;

public class CheckersGameLogic implements CheckersGame {
    private int turn = 0;
    private char[][] board;
    Scanner scan = new Scanner(System.in);

    // implements and creates basic checkers board using a 2d array and x/o tokens
    public CheckersGameLogic(Scanner scan) {
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
        nextTurn();
        String input = "test";
        // Prompts user for input
        if (scan.hasNextLine()) {
            input = scan.nextLine();

            char number = input.charAt(0);
            char letter = input.charAt(1);
            char number2 = input.charAt(3);
            char letter2 = input.charAt(4);

            int startRow = charToInt2(number);
            int startCol = charToInt(letter);
            int endRow = charToInt2(number2);
            int endCol = charToInt(letter2);

            char startContent = getSquare(startRow, startCol);

            // checks to see if the move to be made is valid or not
            if (isValidMove(startRow, startCol, endRow, endCol)) {

                setSquare(startRow, startCol, '_');
                setSquare(endRow, endCol, startContent);
                turn++;
            } else {
                System.out.println("This move is invalid");
                if (scan.hasNextLine()) { // Added this line
                    doTurn();
                }
            }
        }

    }

    private boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {

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
        if (startRow - endRow > 0 && board[startRow][startCol] == 'x') {
            return false;
        }
        if (startRow - endRow < 0 && board[startRow][startCol] == 'o') {
            return false;
        }

        // check if movement is further than one
        if (Math.abs(startRow - endRow) == 2) {
            int middleRow = (startRow + endRow) / 2;
            int middleCol = (startCol + endCol) / 2;
            char middleContent = getSquare(middleRow, middleCol);
            char startContent = getSquare(startRow, startCol);
            // check if friendly piece is in the middle
            if (middleContent == startContent) {
                return false;
            }
        }

        // returns true if all criteria is met
        return true;
    }

    @Override
    public char getWinningPlayer() {
        // Checks who has won the game.
        int xCount = 0;
        int oCount = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char c = getSquare(row, col);
                if (c == 'x') {
                    xCount++;
                } else if (c == 'o') {
                    oCount++;
                }
            }
        }
        if (xCount == 0) {
            return 'o';
        } else if (oCount == 0) {
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