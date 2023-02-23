package edu.ser216.checkers.core;

import java.util.Scanner;

public class CheckersGameLogic implements CheckersGame {
    private int turn = 0;
    private char[][] board = new char[8][8];

    // implements and creates basic checkers board using a 2d array and x/o tokens
    public CheckersGameLogic(Scanner scan) {

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = '_';
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    board[row][col] = 'x';
                }
            }
        }

        // for (int row = 5; row < 8; row++) {
        // for (int col = 0; col < 8; col++) {
        // if ((row + col) % 2 == 0) {
        // board[row][col] = 'o';
        // }
        // }
        // }
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
    public char getWinningPlayer() {
        int x = 0;
        int o = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'x') {
                    x++;
                } else if (board[i][j] == 'o') {
                    o++;
                }
            }
        }

        if (x == 0) {
            return 'x';
        }
        if (o == 0) {
            return 'o';
        } else {
            return '_';
        }
    }

    @Override
    // checks and keeps track of who's turn is next
    public void nextTurn() {
        // if (turn % 2 == 0 && turn != 0) {
        // System.out.println(
        // "\nPlayer X - your turn. \nChoose a cell position of piece to be moved and
        // the new position. e.g., 3a-4b 3g-4h");
        // } else {
        // System.out.println(
        // "\nPlayer O - your turn. \nChoose a cell position of piece to be moved and
        // the new position. e.g., 3a-4b 3g-4h");
        // }
    }

    @Override
    public void doTurn() {
        // if (turn == 0) {
        // System.out.println(
        // "\nBegin Game. Player X - your turn. \nChoose a cell position of piece to be
        // moved and the new position. e.g., 3a-4b 3g-4h ");
        // }

        Scanner scan = new Scanner(System.in);
        String hold = scan.nextLine();
        String start = hold.substring(0, 2);
        String end = hold.substring(3, 5);

        // gathers the index's of where the tokens starts and ends
        int startRow = charToInt2(start.charAt(0));
        int endRow = charToInt2(end.charAt(0));

        int startCol = charToInt(start.charAt(1));
        int endCol = charToInt(end.charAt(1));

        // checks to see if the move to be made is valid or not
        if (!isValidMove(startRow, startCol, endRow, endCol)) {
            System.out.println("Invalid move, please try again");
            doTurn();
        } else {
            setSquare(startRow, startCol, '_');

            if (turn % 2 == 0) {
                setSquare(endRow, endCol, 'x');
                turn++;
            } else {
                setSquare(endRow, endCol, 'o');
                turn++;
            }
        }

    }

    @Override
    // prints the winner
    public void onEnd() {
        System.out.println("Game Over");
        if (getWinningPlayer() == 'x') {
            System.out.println("X has won!");
        } else {
            System.out.println("O has won!");
        }
    }

    private boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {

        // Check if the move is crossing an enemy piece
        char enemyPlayer;

        if (turn % 2 == 0) {
            enemyPlayer = 'o';
        } else {
            enemyPlayer = 'x';
        }

        // check if the move is crossing an enemy piece
        if ((startRow - endRow == 2 || startRow - endRow == -2)
                && (startCol - endCol == 2 || startCol - endCol == -2)) {
            int row = (startRow + endRow) / 2;
            int col = (startCol + endCol) / 2;

            if (getSquare(row, col) == enemyPlayer) {
                setSquare(row, col, '_');
                return true;
            }
        }

        // Check if the move is a diagonal move
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol)) {
            return false;
        }

        // Check if the move is one square away
        if (Math.abs(startRow - endRow) > 1 || Math.abs(startCol - endCol) > 1) {
            return false;
        }

        // Check if the move is not to an occupied space
        if (getSquare(endRow, endCol) != '_') {
            return false;
        }

        // Check if the piece belongs to the current player
        if (turn % 2 == 0 && getSquare(startRow, startCol) != 'x' ||
                turn % 2 == 1 && getSquare(startRow, startCol) != 'o') {
            return false;
        }

        return true;
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
    public int charToInt2(char c) {
        int row;
        if (c == '8') {
            row = 0;
        } else if (c == '7') {
            row = 1;
        } else if (c == '6') {
            row = 2;
        } else if (c == '5') {
            row = 3;
        } else if (c == '4') {
            row = 4;
        } else if (c == '3') {
            row = 5;
        } else if (c == '2') {
            row = 6;
        } else {
            row = 7;
        }
        return row;
    }

}
