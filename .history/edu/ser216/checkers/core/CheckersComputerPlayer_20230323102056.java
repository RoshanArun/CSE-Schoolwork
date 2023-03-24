package edu.ser216.checkers.core;

import java.util.Scanner;

public class CheckersComputerPlayer implements CheckersGame {
    private int turn = 0;
    private char[][] board;
    private Scanner scan;

    // implements and creates basic checkers board using a 2d array and x/o tokens
    public CheckersComputerPlayer(Scanner scan) {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doTurn'");
    }

    @Override
    public char getWinningPlayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWinningPlayer'");
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
