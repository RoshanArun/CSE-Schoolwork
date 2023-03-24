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

}
