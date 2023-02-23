package edu.ser216.checkers.core;

import java.util.Scanner;

public class CheckersGameLogic implements CheckersGame {
    private int row = 7;
    private int col = 7;
    private char[][] board = new char[8][8];

    public CheckersGameLogic(Scanner scan) {
        for (int i = 0; i <= row; i++) {

            for (int j = 0; j <= col; j++) {
                if (j % 2 == 1 && i % 2 == 0 && i < 3) {
                    board[i][j] = 'o';
                } else if (j % 2 == 0 && i % 2 == 1 && i < 3) {
                    board[i][j] = 'o';
                }

                else if (j % 2 == 0 && i % 2 == 1 && i > 4) {
                    board[i][j] = 'x';
                } else if (j % 2 == 1 && i % 2 == 0 && i > 4) {
                    board[i][j] = 'x';
                } else {
                    board[i][j] = '_';
                }
                if (j == 7) {
                    board[i][j] = '|';
                }
            }
        }
    }

    @Override
    public char getSquare(int row, int column) {
        // TODO Auto-generated method stub
        return board[row][column];
    }

    @Override
    public void setSquare(int row, int column, char content) {
        // TODO Auto-generated method stub

    }

    @Override
    public char getWinningPlayer() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void nextTurn() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doTurn() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEnd() {
        // TODO Auto-generated method stub

    }

}
