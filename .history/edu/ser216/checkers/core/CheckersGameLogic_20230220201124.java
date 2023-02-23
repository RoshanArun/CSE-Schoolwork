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
        return '_';
    }

    @Override
    public void nextTurn() {
        if (turn % 2 == 0 && turn != 0) {
            System.out.println(
                    "\nPlayer X - your turn. \nChoose a cell position of piece to be moved and the new position. e.g., 3a-4b  3g-4h");
        } else {
            System.out.println(
                    "\nPlayer O - your turn. \nChoose a cell position of piece to be moved and the new position. e.g., 3a-4b  3g-4h");
        }
    }

    @Override
    public void doTurn() {
        if (turn == 0) {
            System.out.println(
                    "\nBegin Game. Player X - your turn. \nChoose a cell position of piece to be moved and the new position. e.g., 3a-4b  3g-4h ");
        }

        Scanner scan = new Scanner(System.in);
        String hold = scan.nextLine();
        String start = hold.substring(0, 2);
        String end = hold.substring(3, 5);

        int startRow = charToInt2(start.charAt(0));
        int endRow = charToInt2(end.charAt(0));

        int startCol = charToInt(start.charAt(1));
        int endCol = charToInt(end.charAt(1));

        setSquare(startRow, startCol, '_');
        setSquare(endRow, endCol, 'x');

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public void onEnd() {
        // TODO Auto-generated method stub

    }

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
