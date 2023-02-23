package edu.ser216.checkers.core;

import java.util.Scanner;

public class CheckersGameLogic implements CheckersGame {
    private int row = 7;
    private int col = 7;
    private char[][] board = new char[8][8];
    private int turn = 0;

    public CheckersGameLogic(Scanner scan) {
        for (int i = 0; i <= row; i++) {

            for (int j = 0; j <= col; j++) {
                if (j % 2 == 1 && i % 2 == 0 && i < 3 || j % 2 == 0 && i % 2 == 1 && i < 3) {
                    board[i][j] = 'o';
                }

                else if (j % 2 == 0 && i % 2 == 1 && i > 4 || j % 2 == 1 && i % 2 == 0 && i > 4) {
                    board[i][j] = 'x';
                }

                else {
                    board[i][j] = '_';
                }

                if (j == 7 && j % 2 == 1 && i % 2 == 0 && i < 3) {
                    board[i][j] = 'o';
                }

                if (j == 7 && j % 2 == 0 && i % 2 == 1 && i > 4) {
                    board[i][j] = 'x';
                }
            }
        }

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public char getSquare(int row, int column) {
        return board[row][column];
    }

    @Override
    public void setSquare(int row, int column, char content) {
        board[row][column] = content;
    }

    @Override
    public char getWinningPlayer() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void nextTurn() {
        if (turn == 0) {
            System.out.println(
                    "Begin Game. Player X – your turn. \nChoose a cell position of piece to be moved and the new position. e.g., 3a-4b  3g-4h ");
        }

        if (turn % 2 == 0) {
            System.out.println(
                    "Player X – your turn. \nChoose a cell position of piece to be moved and the new position. e.g., 3a-4b  3g-4h");
        } else {
            System.out.println(
                    "Player O – your turn. \nChoose a cell position of piece to be moved and the new position. e.g., 3a-4b  3g-4h");
        }

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
